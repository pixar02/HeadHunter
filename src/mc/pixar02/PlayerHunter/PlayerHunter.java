package mc.pixar02.PlayerHunter;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import mc.pixar02.PlayerHunter.API.PlaceHolders;
import mc.pixar02.PlayerHunter.Events.InvClick;
import mc.pixar02.PlayerHunter.Events.OnJoin;
import mc.pixar02.PlayerHunter.Events.PlaceBlock;
import mc.pixar02.PlayerHunter.Managers.CmdManager;
import mc.pixar02.PlayerHunter.Managers.GameManager;
import mc.pixar02.PlayerHunter.Managers.InventoryManager;
import mc.pixar02.PlayerHunter.Managers.KitManager;
import mc.pixar02.PlayerHunter.Managers.PlayerManager;
import mc.pixar02.PlayerHunter.Managers.StorageManager;
import mc.pixar02.PlayerHunter.Utils.FileManager;
import mc.pixar02.PlayerHunter.Utils.Metrics;

public class PlayerHunter extends JavaPlugin {

	public boolean debug = false;
	private FileManager FM;
	private GameManager GM;
	private StorageManager SM;
	private PlayerManager PM;
	private KitManager KM;
	private InventoryManager IM;

	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	public void onEnable() {
		// dependencies? loaded not loaded?

		// register Managers
		loadManagers();

		// register events
		getServer().getPluginManager().registerEvents(new OnJoin(this), this);
		getServer().getPluginManager().registerEvents(new InvClick(this), this);
		getServer().getPluginManager().registerEvents(new PlaceBlock(this), this);
		// commands
		getCommand("PlayerHunter").setExecutor(new CmdManager(this));

		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");

		if (Bukkit.getPluginManager().isPluginEnabled("PlaceHolderAPI")) {
			new PlaceHolders(this).hook();
		}
	}

	public void loadManagers() {
		FM = new FileManager(this);
		FM.setup();
		GM = new GameManager(this);
		SM = new StorageManager(this);
		PM = new PlayerManager(this);
		KM = new KitManager(this);
		IM = new InventoryManager(this);

	}

	public void onDisable() {

	}

	@SuppressWarnings("unused")
	public void loadMetrics() {
		Metrics metrics = new Metrics(this);
	}

	public GameManager getGM() {
		return this.GM;
	}

	public StorageManager getSM() {
		return this.SM;
	}

	public FileManager getFM() {
		return this.FM;
	}

	public PlayerManager getPM() {
		return this.PM;
	}

	public KitManager getKM() {
		return this.KM;
	}

	public InventoryManager getIM() {
		return this.IM;
	}
}
