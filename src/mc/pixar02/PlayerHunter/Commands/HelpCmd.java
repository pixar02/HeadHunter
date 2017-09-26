package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import mc.pixar02.PlayerHunter.Managers.CmdManager;

public class HelpCmd extends BaseCmd {
	private CmdManager CM;

	public HelpCmd(CmdManager CM) {
		this.CM = CM;
	}

	/*
	 * /PlayerHunter help [command]
	 * 
	 */

	@Override
	public void onCommand(Player player, String[] args) {
		player.sendMessage(
				ChatColor.GOLD + "--------[" + ChatColor.BLUE + "PlayerHunter" + ChatColor.GOLD + "]--------");
		for (BaseCmd cmd : CM.getCmds()) {
			player.sendMessage(ChatColor.GOLD + "- /PH " + cmd.name() + ": " + ChatColor.AQUA + cmd.info());
		}

	}

	@Override
	public String name() {
		return "help";
	}

	@Override
	public String info() {
		return "Shows this help page";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
