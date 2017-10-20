package mc.pixar02.PlayerHunter.Managers;

import java.util.HashMap;
import java.util.Map;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Game.Game;

public class GameManager {
	private Map<Integer, String> games = new HashMap<>();
	private PlayerHunter plugin;
	private int gameNumber;

	public GameManager(PlayerHunter plugin) {
		this.plugin = plugin;
	}

	public void createGame(String map) {
		Game game = new Game(plugin, gameNumber, map);
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

}
