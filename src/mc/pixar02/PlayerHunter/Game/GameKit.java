package mc.pixar02.PlayerHunter.Game;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import mc.pixar02.PlayerHunter.Utils.ItemUtils;

public class GameKit {
	private ItemStack icon;
	private String name;
	private String kitName;
	private int cost;
	private List<ItemStack> items = new ArrayList<ItemStack>();
	private List<PotionEffect> potionEffects = new ArrayList<PotionEffect>();

	public GameKit(String name, File kit, FileConfiguration storage) {
		try {
			this.name = name;
			List<String> itemData = storage.getStringList("items");
			for (String ItemData : itemData) {
				List<String> item = Arrays.asList(ItemData.split(" "));
				ItemStack itemStack = ItemUtils.parseItem(item);
				if (itemStack != null) {
					items.add(itemStack);
				}
			}
			List<String> effects = storage.getStringList("potion effects");
			for (String effect : effects) {
				List<String> effectDetails = Arrays.asList(effect.split(" "));
				PotionEffect potionEffect = ItemUtils.parseEffect(effectDetails);
				if (potionEffect != null) {
					potionEffects.add(potionEffect);
				}
			}

			if (storage.getString("kitName") != null) {
				this.kitName = storage.getString("kitName");
			} else {
				this.kitName = this.name;
				storage.set("kitName", this.name);
				try {
					storage.save(kit);
				} catch (Exception ex) {

				}
			}

			if (storage.getString("cost") != null) {
				this.cost = storage.getInt("cost");
			} else {
				this.cost = 100000;
				storage.set("cost", cost);
				try {
					storage.save(kit);
				} catch (Exception ex) {

				}

			}
			String icon = storage.getString("icon").toUpperCase();
			Material material;
			material = Material.getMaterial(icon);

			if (material == null) {
				material = Material.STONE;
			}
			this.icon = new ItemStack(material, 1);

		} catch (Exception ex) {

		}
	}

	public String getName() {
		return name;
	}

	public String getKitName() {
		return kitName;
	}

	public int getCost() {
		return cost;
	}

	public Collection<ItemStack> getItems() {
		return items;
	}

	public Collection<PotionEffect> getPotionEffects() {
		return potionEffects;
	}

	public ItemStack getIcon() {
		return icon;
	}
}
