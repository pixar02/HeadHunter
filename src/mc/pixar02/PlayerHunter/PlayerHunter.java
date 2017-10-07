package mc.pixar02.PlayerHunter;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import mc.pixar02.PlayerHunter.API.PlaceHolders;
import mc.pixar02.PlayerHunter.Events.onJoin;
import mc.pixar02.PlayerHunter.Managers.CmdManager;
import mc.pixar02.PlayerHunter.Managers.GameManager;
import mc.pixar02.PlayerHunter.Managers.KitManager;
import mc.pixar02.PlayerHunter.Managers.MapManager;
import mc.pixar02.PlayerHunter.Managers.PlayerManager;
import mc.pixar02.PlayerHunter.Managers.WorldManager;
import mc.pixar02.PlayerHunter.Utils.FileManager;
import mc.pixar02.PlayerHunter.Utils.Metrics;

public class PlayerHunter extends JavaPlugin {

	public boolean debug = false;
	private FileManager FM;
	private WorldManager WM;
	private GameManager GM;
	private KitManager KM;
	private PlayerManager PM;
	private MapManager MM;

	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	public void onEnable() {
		// dependencies? loaded not loaded?

		// register Managers
		loadManagers();

		// register events
		getServer().getPluginManager().registerEvents(new onJoin(this), this);

		// commands
		getCommand("PlayerHunter").setExecutor(new CmdManager(this));

		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");

		if (Bukkit.getPluginManager().isPluginEnabled("PlaceHolderAPI")) {
			new PlaceHolders(this).hook();
		}
	}

	public void loadManagers() {
		WM = new WorldManager(this);
		FM = new FileManager();
		GM = new GameManager(this);
		KM = new KitManager(this);
		PM = new PlayerManager(this);
		MM = new MapManager(this);
		FM.setup();
	}

	public void onDisable() {

	}

	@SuppressWarnings("unused")
	public void loadMetrics() {
		Metrics metrics = new Metrics(this);
	}

	public WorldManager getWM() {
		return this.WM;
	}

	public GameManager getGM() {
		return this.GM;
	}

	public FileManager getFM() {
		return this.FM;
	}

	public PlayerManager getPM() {
		return PM;
	}

	public KitManager getKM() {
		return KM;

	}

	public MapManager getMM() {
		return MM;
	}
}
