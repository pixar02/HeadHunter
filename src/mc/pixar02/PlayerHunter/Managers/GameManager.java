package mc.pixar02.PlayerHunter.Managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Game.GPlayer;
import mc.pixar02.PlayerHunter.Game.Game;
import mc.pixar02.PlayerHunter.Game.Game.GameState;

public class GameManager {
	private Map<Integer, Game> games = new HashMap<Integer, Game>();
	private Queue<GPlayer> Queued = new LinkedList<GPlayer>();
	private PlayerHunter plugin;
	private int gameNumber;

	public GameManager(PlayerHunter plugin) {
		this.plugin = plugin;
	}

	public Game findGame() {
		ArrayList<Game> games = getGames();
		Collections.shuffle(games);
		for (int i = 0; i < games.size(); i++) {
			if (!(games.get(i).isfull()) && games.get(i).getGameState() == GameState.PREGAME) {
				return games.get(i);
			}
		}
		return createGame();
	}

	public Game createGame() {
		this.gameNumber = findNextNum();
		if (gameNumber != -1) {
			Game game = new Game(gameNumber, "");
			if (!(Queued.isEmpty())) {
				while (!(game.isfull()) && !(Queued.isEmpty())) {
					game.addPlayer(Queued.remove());
				}
				if (game.isfull()) {
					createGame();
				}
			}
			return game;
		} else {
			return null;
		}
	}

	public void deleteGame(int number) {
		games.remove(number);
	}

	public ArrayList<Game> getGames() {
		ArrayList<Game> games = new ArrayList<Game>();
		for (Game game : this.games.values()) {
			games.add(game);
		}
		return games;
	}

	private int findNextNum() {
		int maxNum = plugin.getFM().getFile("config").getInt("");
		if (maxNum == -1) {
			maxNum = Integer.MAX_VALUE;
		}
		int gameNum = -1;
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i) == null) {
				return i;
			}
		}
		return gameNum;
	}

	public Game getGame(int number) {
		return this.games.get(number);
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

}
