package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class DeleteCmd extends BaseCmd {

	/*
	 * /PlayerHunter remove <game>
	 *
	 */

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "delete";
	}

	@Override
	public String info() {
		return "Deletes a map";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
