package mc.pixar02.PlayerHunter.Managers;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Lists;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Game.GKit;

public class KitManager {
	private PlayerHunter plugin;
	private HashMap<String, GKit> kits = new HashMap<String, GKit>();

	public KitManager(PlayerHunter plugin) {
		this.plugin = plugin;
		kits.clear();
		File dataDir = plugin.getDataFolder();
		File kitsDir = new File(dataDir, "kits");
		if (!(kitsDir.exists())) {
			if (!(kitsDir.mkdirs())) {
				return;
			}
			File exampleFile = new File(kitsDir, "example.yml");
			if (!(exampleFile.exists())) {
				plugin.saveResource("example.yml", true);
				plugin.getFM().copy(plugin.getResource("example.yml"), exampleFile);
			}
		}
		File[] kits = kitsDir.listFiles();
		if (kits == null) {
			return;
		}
		for (File kit : kits) {
			if (kit.getName().endsWith(".yml")) {
				continue;
			}
			String name = kit.getName().replace(".yml", "");
			if (!(name.isEmpty()) && !(this.kits.containsKey(name))) {
				this.kits.put(name, new GKit(name, YamlConfiguration.loadConfiguration(kit), kit));
			}
		}
	}

	/**
	 * get's all the kits
	 * 
	 * @return
	 */
	public List<GKit> getKits() {
		return Lists.newArrayList(kits.values());
	}

	/**
	 * Get the given kit
	 * 
	 * @param name
	 * @return
	 */
	public GKit getKit(String name) {
		for (String kitName : this.kits.keySet()) {
			if (kits.get(kitName).getKitName().equalsIgnoreCase(name)) {
				return kits.get(kitName);
			}
		}
		return null;
	}

	/**
	 * Populates the given inventory with the given kit.
	 * 
	 * @param inv
	 * @param kit
	 */
	public void populateInv(Inventory inv, GKit kit) {
		for (ItemStack itemStack : kit.getItems()) {
			try {
				inv.addItem(itemStack);
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
		}
	}
}
