package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class HelpCmd extends BaseCmd {
	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "help";
	}

	@Override
	public String info() {
		return "shows a help page with all the commands";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
