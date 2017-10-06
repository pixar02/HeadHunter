package mc.pixar02.PlayerHunter.Game;

import java.util.UUID;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class GamePlayer {
	private PlayerHunter plugin;
	private UUID uuid;
	private String name;
	private boolean ingame;
	private boolean spectating;
	private int balance;
	private int wins;
	private int kills;
	private int deaths;
	private int gamesPlayed;

	public GamePlayer(PlayerHunter plugin, UUID uuid) {
		this.plugin = plugin;
		this.uuid = uuid;
		this.name = plugin.getServer().getPlayer(uuid).getName();
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public boolean isIngame() {
		return ingame;
	}

	public void setIngame(boolean ingame) {
		this.ingame = ingame;
	}

	public UUID getUuid() {
		return uuid;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public boolean isSpectating() {
		return spectating;
	}

	public void setSpectating(boolean spectating) {
		this.spectating = spectating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
