package mc.pixar02.PlayerHunter.Managers;

import java.util.UUID;

public class PlayerManager {

	private UUID uuid;
	public boolean ingame;
	private boolean isdead;
	private int balance;

	public PlayerManager(UUID uuid, boolean ingame, boolean isdead, int balance) {
		this.uuid = uuid;
		this.ingame = ingame;
		this.isdead = isdead;
		this.balance = balance;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public boolean isIngame() {
		return ingame;
	}

	public void setIngame(boolean ingame) {
		this.ingame = ingame;
	}

	public boolean isIsdead() {
		return isdead;
	}

	public void setIsdead(boolean isdead) {
		this.isdead = isdead;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
