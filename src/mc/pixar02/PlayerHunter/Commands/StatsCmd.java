package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class StatsCmd extends BaseCmd {
	/*
	 *  /PH stats [player]
	 *
	 */

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "stats";
	}

	@Override
	public String info() {
		return "gives your stats or given player there stata";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
