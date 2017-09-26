package mc.pixar02.PlayerHunter.Events;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Managers.PlayerManager;

public class onJoin implements Listener {
	private PlayerHunter plugin;

	public onJoin(PlayerHunter plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void Join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		UUID uuid = player.getUniqueId();
		
		plugin.playerManager.put(uuid, new PlayerManager(uuid, false, false, 0));
	}
}
