package mc.pixar02.PlayerHunter.Player;

import java.util.UUID;

public class Player {
	private UUID uuid;
	private boolean ingame;
	private boolean isdead;
	private int balance;

	public Player(UUID uuid, boolean ingame, boolean isdead, int balance) {
		this.setUuid(uuid);
		this.setIngame(ingame);
		this.setIsdead(isdead);
		this.setBalance(balance);
	}

	/**
	 * @return the uuid
	 */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return the isdead
	 */
	public boolean isIsdead() {
		return isdead;
	}

	/**
	 * @param isdead
	 *            the isdead to set
	 */
	public void setIsdead(boolean isdead) {
		this.isdead = isdead;
	}

	/**
	 * @return the ingame
	 */
	public boolean isIngame() {
		return ingame;
	}

	/**
	 * @param ingame
	 *            the ingame to set
	 */
	public void setIngame(boolean ingame) {
		this.ingame = ingame;
	}
}
