package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class StopCmd extends BaseCmd {

	/*
	 * /PlayerHunter stop [game]
	 * 
	 */

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "stop";
	}

	@Override
	public String info() {
		return "Stops the given map or current";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
