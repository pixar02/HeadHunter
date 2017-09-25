package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class StartCmd extends BaseCmd {

	/*
	 * /PlayerHunter start [game]
	 *
	 */

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "start";
	}

	@Override
	public String info() {
		return "force starts a game";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
