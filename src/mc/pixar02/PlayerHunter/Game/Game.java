package mc.pixar02.PlayerHunter.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.World;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class Game {
	private PlayerHunter plugin;
	private String mapName;
	private World mapWorld;
//	private GameMap gameMap;
	private Location specSpawn;
	private Location joinSpawn;
	private List<GamePlayer> gPlayers = new ArrayList<GamePlayer>();
	private List<GamePlayer> spectators = new ArrayList<GamePlayer>();
	private Map<GamePlayer, Integer> kills = new HashMap<GamePlayer, Integer>();
	private int gameNumb;
	private int minPlayers;

	public Game(PlayerHunter plugin, int gameNumb, String map) {
		this.plugin = plugin;
		this.gameNumb = gameNumb;
		this.mapName = map;
	}

	public void startGame() {

	}

	public void endGame() {

	}

	public String getMapName() {
		return mapName;
	}

	public Location getSpecSpawn() {
		return specSpawn;
	}

	public World getMapWorld() {
		return mapWorld;
	}
}
