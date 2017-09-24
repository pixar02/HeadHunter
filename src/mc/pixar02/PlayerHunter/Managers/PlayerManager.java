package mc.pixar02.PlayerHunter.Managers;

import java.util.UUID;

public class PlayerManager {
	private UUID uuid;
	public boolean ingame;
	private boolean isdead;

	PlayerManager(UUID uuid, boolean ingame, boolean isdead) {
		this.setUuid(uuid);
		this.setIngame(ingame);
		this.setIsdead(isdead);
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
}
