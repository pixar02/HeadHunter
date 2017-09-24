package mc.pixar02.PlayerHunter;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import mc.pixar02.PlayerHunter.Managers.CommandManager;
import mc.pixar02.PlayerHunter.Managers.PlayerManager;
import mc.pixar02.PlayerHunter.Managers.WorldManager;
import mc.pixar02.PlayerHunter.Utils.FileManager;
import mc.pixar02.PlayerHunter.Utils.Metrics;

public class PlayerHunter extends JavaPlugin {

	public HashMap<UUID, PlayerManager> playerManager = new HashMap<>();
	public boolean debug = false;
	private FileManager FM;
	private WorldManager WM;

	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	public void onEnable() {
		// dependencies? loaded not loaded?

		// register Managers
		loadManagers();

		// commands
		getCommand("PlayerHunter").setExecutor(new CommandManager(this));

		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
	}

	public void loadManagers() {
		WM = new WorldManager();
		FM = new FileManager();
		FM.setup();
		WM.setup();
	}

	public void onDisable() {

	}

	@SuppressWarnings("unused")
	public void loadMetrics() {
		Metrics metrics = new Metrics(this);
	}
}
