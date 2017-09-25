package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class CreateCmd extends BaseCmd {

	/*
	 * /PlayerHunter create <game>
	 * 
	 */

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "create";
	}

	@Override
	public String info() {
		return "creates a map";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
