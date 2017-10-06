package mc.pixar02.PlayerHunter.Game;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

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
		} catch (Exception ex) {

		}
	}

	public String getName() {
		return name;
	}

	public String KitName() {
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
