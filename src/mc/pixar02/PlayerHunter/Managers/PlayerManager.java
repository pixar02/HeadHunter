package mc.pixar02.PlayerHunter.Managers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Game.GamePlayer;

public class PlayerManager {
	private PlayerHunter plugin;
	private Map<UUID, GamePlayer> players = new HashMap<UUID, GamePlayer>();

	public PlayerManager(PlayerHunter plugin) {
		this.plugin = plugin;
		for (Player player : Bukkit.getOnlinePlayers()) {
			addPlayer(player.getUniqueId());
		}
	}

	/**
	 * 
	 * @param uuid
	 */
	public void addPlayer(UUID uuid) {
		if (!(players.containsKey(uuid))) {
			GamePlayer gamePlayer = new GamePlayer(plugin, uuid);
			players.put(uuid, gamePlayer);
		}
	}

	/**
	 * 
	 * @param uuid
	 */
	public void removePlayer(UUID uuid) {
		GamePlayer gamePlayer = getPlayer(uuid);
		// TODO save GamePlayer data in storage
		players.remove(uuid);

	}

	public GamePlayer getPlayer(UUID uuid) {
		return players.get(uuid);

	}

	public GamePlayer getPlayerName(String name) {
		for (GamePlayer gp : players.values()) {
			if (gp.getName().equalsIgnoreCase(name)) {
				return gp;
			}
		}
		return null;
	}

	public Collection<GamePlayer> getAll() {
		return players.values();
	}
}
