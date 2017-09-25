package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class JoinCmd extends BaseCmd {

	/*
	 * /PlayerHunter join <game>
	 * 
	 */
	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "join";
	}

	@Override
	public String info() {
		return "Join the given game";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}

}
