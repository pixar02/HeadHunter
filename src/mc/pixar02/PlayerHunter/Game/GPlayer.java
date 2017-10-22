package mc.pixar02.PlayerHunter.Game;

import java.util.UUID;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class GPlayer {
	private PlayerHunter plugin;
	private UUID uuid;
	private String name;
	private int balance;
	private int kills;
	private int wins;
	private boolean ingame;
	private int game;

	public GPlayer(PlayerHunter plugin, UUID uuid) {
		this.plugin = plugin;
		this.setUuid(uuid);
		plugin.getSM().loadPlayer(this);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public boolean isIngame() {
		return ingame;
	}

	public void setIngame(boolean ingame) {
		this.ingame = ingame;
	}

	public Integer getGame() {
		return game;
	}

	public void setGame(int gameNum) {
		this.game = gameNum;
	}
}
