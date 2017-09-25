package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class LeaveCmd extends BaseCmd {
	/*
	 * /PH leave
	 * 
	 */

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "leave";
	}

	@Override
	public String info() {
		return "Leave your current game";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
