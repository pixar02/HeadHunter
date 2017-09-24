package mc.pixar02.PlayerHunter.Managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class GameManager {
	private PlayerHunter plugin = PlayerHunter.getPlugin(PlayerHunter.class);

	private int lobbycountdown;
	private int playersNeeded;
	private boolean isStarted;

	Location gameSpawn;
	Location lobbySpawn;

	public void setupGame() {
		// gameSpawn = new Location(world, X, Y, Z, yawn, pitch));
		lobbySpawn = new Location(Bukkit.getServer().getWorld(plugin.getConfig().getString("Lobby.world")),
				plugin.getConfig().getDouble("Lobby.x"), plugin.getConfig().getDouble("Lobby.y"),
				plugin.getConfig().getDouble("Lobby.z"), (float) plugin.getConfig().getLong("Lobby.yawn"),
				(float) plugin.getConfig().getLong("Lobby.pitch"));
	}

	public void gameStart() {

	}

	public void gameStop() {

	}
}