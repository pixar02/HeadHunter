package mc.pixar02.PlayerHunter.Managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Lists;

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
			if (!(kitsDirectory.mkdirs())) {
				return;
			}
			plugin.saveResource("example.yml", true);
			copyFiles(new File(dataDirectory, "example.yml"), new File(kitsDirectory, "example.yml"));
			File delete = new File(dataDirectory, "example.yml");
			delete.delete();
		}
		File[] kits = kitsDirectory.listFiles();
		if (kits == null) {
			return;
		}
		for (File kit : kits) {
			if (!(kit.getName().endsWith(".yml"))) {
				continue;
			}
			String name = kit.getName().replace(".yml", "");
			if (!(name.isEmpty()) && !(this.kits.containsKey(name))) {
				this.kits.put(name, new GameKit(name, kit, YamlConfiguration.loadConfiguration(kit)));
			}
		}

	}

	/**
	 * 
	 * @param source
	 * @param target
	 */
	public void copyFiles(File source, File target) {
		try {
			ArrayList<String> ignore = new ArrayList<String>(Arrays.asList("uid.dat", "session.dat"));
			if (!ignore.contains(source.getName())) {
				if (source.isDirectory()) {
					if (!target.exists())
						target.mkdirs();
					String files[] = source.list();
					for (String file : files) {
						File srcFile = new File(source, file);
						File destFile = new File(target, file);
						copyFiles(srcFile, destFile);
					}
				} else {
					InputStream in = new FileInputStream(source);
					OutputStream out = new FileOutputStream(target);
					byte[] buffer = new byte[1024];
					int length;
					while ((length = in.read(buffer)) > 0)
						out.write(buffer, 0, length);
					in.close();
					out.close();
				}
			}
		} catch (IOException e) {

		}
	}

	public void populateInventory(Inventory inv, GameKit kit) {
		for (ItemStack itemStack : kit.getItems()) {
			try {
				inv.addItem(itemStack);

			} catch (Exception ex) {

			}
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public GameKit getKit(String name) {
		for (String kitName : this.kits.keySet()) {
			if (this.kits.get(kitName).getKitName().equalsIgnoreCase(name)) {
				return this.kits.get(kitName);
			}
		}

		return null;
	}

	/**
	 * 
	 * @return
	 */
	public List<GameKit> getKits() {
		return Lists.newArrayList(this.kits.values());
	}

}
