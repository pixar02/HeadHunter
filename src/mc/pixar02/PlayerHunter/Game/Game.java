package mc.pixar02.PlayerHunter.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
	private List<GPlayer> players = new ArrayList<GPlayer>();
	private HashMap<GPlayer, Integer> kills = new HashMap<GPlayer, Integer>();
	private GameState GameState;
	private int gameNum;
	private int minplayers;
	private int maxplayers;

	public Game(int number, String name) {
		this.gameNum = number;

		this.GameState = GameState.PREGAME;

	}

	public enum GameState {
		PREGAME, PLAYING, ENDING,
	}

	public GameState getGameState() {
		return GameState;
	}

	public void setGameState(GameState gameState) {
		GameState = gameState;
	}

	public boolean isfull() {
		if (players.size() >= this.maxplayers) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxplayers() {
		return maxplayers;
	}

	public void setMaxplayers(int maxplayers) {
		this.maxplayers = maxplayers;
	}

	public int getMinplayers() {
		return minplayers;
	}

	public void setMinplayers(int minplayers) {
		this.minplayers = minplayers;
	}

	public void addPlayer(GPlayer player) {
		if (players.size() >= maxplayers || players.contains(player)) {
			return;
		} else {
			if (player.getUuid() != null) {
				players.add(player);
				kills.put(player, 0);
				player.setIngame(true);
				player.setGame(this.gameNum);
			}
		}

	}

}
