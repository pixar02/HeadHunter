package mc.pixar02.PlayerHunter.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class PlaceBlock implements Listener {
	private PlayerHunter plugin;

	public PlaceBlock(PlayerHunter plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlaceBlock(BlockPlaceEvent event) {

	}
}
