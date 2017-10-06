package mc.pixar02.PlayerHunter.Managers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Game.GameKit;

public class KitManager {
	private PlayerHunter plugin;
	private Map<String, GameKit> kits = new HashMap<>();

	public KitManager(PlayerHunter plugin) {
		this.plugin = plugin;
		kits.clear();
		File dataDirectory = plugin.getDataFolder();
		File kitsDirectory = new File(dataDirectory, "kits");
		if (!(kitsDirectory.exists())) {

		}
	}

}
