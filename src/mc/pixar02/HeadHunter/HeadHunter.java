package mc.pixar02.HeadHunter;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import mc.pixar02.HeadHunter.Managers.PlayerManager;
import mc.pixar02.HeadHunter.Utils.FileManager;
import mc.pixar02.HeadHunter.Utils.Metrics;

public class HeadHunter extends JavaPlugin {

	public HashMap<UUID, PlayerManager> playerManager = new HashMap<>();
	public boolean debug = false;
	private FileManager fm;
	
	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	public void onEnable() {
		// dependencies? loaded not loaded?

		// register Files
		LoadFileManager();
		// commands
		getCommand("HeadHunter").setExecutor(new Commands());

		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
	}

	public void LoadFileManager() {
		fm = new FileManager();
		fm.setup();

	}

	public void onDisable() {

	}

	@SuppressWarnings("unused")
	public void loadMetrics() {
		Metrics metrics = new Metrics(this);
	}

	public void g() {

	}
}
