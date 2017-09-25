package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public abstract class BaseCmd {

	public BaseCmd() {

	}

	public abstract void onCommand(Player player, String[] args);

	public abstract String name();

	public abstract String info();

	public abstract String[] aliases();
}
