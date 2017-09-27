package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class SaveCmd extends BaseCmd {
	/*
	 * 
	 * 
	 * 
	 */
	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "save";
	}

	@Override
	public String info() {
		return "saves a map after editing";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
