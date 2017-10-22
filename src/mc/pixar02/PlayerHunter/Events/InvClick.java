package mc.pixar02.PlayerHunter.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class InvClick implements Listener {
	private PlayerHunter plugin;

	public InvClick(PlayerHunter plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void InvtoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ClickType click = event.getClick();
		Inventory open = event.getInventory();
		ItemStack item = event.getCurrentItem();

		if (open.getName().equals("")) {
			if (item.equals(null)) {

			}
		}
	}
}
