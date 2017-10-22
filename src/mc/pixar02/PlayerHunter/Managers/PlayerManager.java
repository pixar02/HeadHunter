package mc.pixar02.PlayerHunter.Managers;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Game.GPlayer;

public class PlayerManager {
	private PlayerHunter plugin;
	private HashMap<UUID, GPlayer> players = new HashMap<UUID, GPlayer>();

	public PlayerManager(PlayerHunter plugin) {
		this.plugin = plugin;
		for (Player player : Bukkit.getOnlinePlayers()) {
			addPlayer(player.getUniqueId());
		}
	}

	public void addPlayer(UUID uuid) {
		if (!(players.containsKey(uuid))) {
			GPlayer gPlayer = new GPlayer(plugin, uuid);
			players.put(uuid, gPlayer);
		}
	}

	public void removePlayer(UUID uuid) {
		if (!(players.containsKey(uuid))) {
			return;
		} else {
			GPlayer gPlayer = players.get(uuid);
			// TODO save players data to storage
			players.remove(uuid);
		}
	}

	public GPlayer getPlayer(UUID uuid) {
		return players.get(uuid);

	}

	public GPlayer getPlayerByName(String name) {
		for (GPlayer gPlayer : players.values()) {
			if (gPlayer.getName().equals(name)) {
				return gPlayer;
			}
		}
		return null;
	}
}
