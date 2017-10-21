package mc.pixar02.PlayerHunter.Game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

public class GKit {
	private String name;
	private String kitName;
	private int cost;
	private ItemStack icon;

	private List<ItemStack> items = new ArrayList<ItemStack>();

	public GKit(String name, FileConfiguration storage, File file) {
		this.name = name;
		try {
			List<String> itemDatas = storage.getStringList("items");
			for (String itemData : itemDatas) {
				// TODO do something

			}
			// Get the kits name if it's not named set it to the name
			if (storage.getString("kit-name") != null) {
				this.kitName = storage.getString("kit-name");
			} else {
				this.kitName = name;
				storage.set("kit-name", name);
				try {
					storage.save(file);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			// set the cost of the kit
			this.cost = storage.getInt("cost", 0);
			// set the icon of the kit
			String icon = storage.getString("icon").toUpperCase();
			Material material = Material.getMaterial(icon);
			if (material == null) {
				material = Material.STONE;
			}
			this.icon = new ItemStack(material, 1);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKitName() {
		return kitName;
	}

	public void setKitName(String kitName) {
		this.kitName = kitName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public ItemStack getIcon() {
		return icon;
	}

	public void setIcon(ItemStack icon) {
		this.icon = icon;
	}

	public List<ItemStack> getItems() {
		return items;
	}

	public void setItems(List<ItemStack> items) {
		this.items = items;
	}

}
