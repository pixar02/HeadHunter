package mc.pixar02.PlayerHunter.Events;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
		if (plugin.getFM().getFile("config").getBoolean("Settings.teleport-onjoin") == true) {
			if (plugin.getFM().getFile("config").getString("lobby.world") != null
					| plugin.getFM().getFile("config").getDouble("lobby.x") == 0
					| plugin.getFM().getFile("config").getDouble("lobby.y") == 0
					| plugin.getFM().getFile("config").getDouble("lobby.z") == 0) {
				Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("lobby.world")),
						plugin.getConfig().getDouble("lobby.x"), plugin.getConfig().getDouble("lobby.y"),
						plugin.getConfig().getDouble("lobby.z"), plugin.getConfig().getLong("lobby.yaw"),
						plugin.getConfig().getLong("lobby.pitch"));
				player.teleport(loc);
			}
		}

		UUID uuid = player.getUniqueId();

		plugin.playerManager.put(uuid, new PlayerManager(uuid, false, false, 0));
	}
}
