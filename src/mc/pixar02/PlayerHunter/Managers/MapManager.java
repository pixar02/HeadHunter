package mc.pixar02.PlayerHunter.Managers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import mc.pixar02.PlayerHunter.PlayerHunter;
//import mc.pixar02.PlayerHunter.Game.GameMap;

public class MapManager {
	private PlayerHunter plugin;
	private File dataDirectory;
	private File maps;
	private File rootDirectory;
	// private Map<String, GameMap> mapList = new HashMap<String, GameMap>();

	public MapManager(PlayerHunter plugin) {
		this.plugin = plugin;
		this.dataDirectory = plugin.getDataFolder();
		this.maps = new File(dataDirectory, "maps");
		String root = plugin.getServer().getWorldContainer().getAbsolutePath();
		this.rootDirectory = new File(root);
		if (maps.exists() && maps.isDirectory()) {
			for (File map : maps.listFiles()) {
				registerMap(map.getName());
			}
		} else {
			plugin.getLogger().info("Maps not found");
		}
	}

	public Boolean registerMap(String name) {

		return null;

	}

	public Boolean mapExists(String name) {
		
		return true;
	}
}
