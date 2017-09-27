package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class CreateCmd extends BaseCmd {
	private PlayerHunter plugin;

	public CreateCmd(PlayerHunter plugin) {
		this.plugin = plugin;
	}

	/*
	 * /PlayerHunter create <game>
	 * 
	 */

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub
		if (plugin.getFM().getFile("config").getString("lobby.world") == null
				| plugin.getFM().getFile("config").getDouble("lobby.x") == 0
				| plugin.getFM().getFile("config").getDouble("lobby.y") == 0
				| plugin.getFM().getFile("config").getDouble("lobby.z") == 0) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',
					plugin.getFM().getFile("messages").getString("error.no-lobby")));
		} else {

		}

	}

	@Override
	public String name() {
		return "create";
	}

	@Override
	public String info() {
		return "Creates a map";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
