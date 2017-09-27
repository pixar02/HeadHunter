package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class SetlobbyCmd extends BaseCmd {
	private PlayerHunter plugin;

	public SetlobbyCmd(PlayerHunter plugin) {
		this.plugin = plugin;
	}

	/*
	 * /PlayerHunter setlobby
	 * 
	 */
	@Override
	public void onCommand(Player player, String[] args) {
		Location location = (Location) player.getLocation();
		plugin.getFM().getFile("config").set("lobby.world", location.getWorld().getName());
		plugin.getFM().getFile("config").set("lobby.x", location.getX());
		plugin.getFM().getFile("config").set("lobby.y", location.getY());
		plugin.getFM().getFile("config").set("lobby.z", location.getZ());
		plugin.getFM().getFile("config").set("lobby.pitch", location.getPitch());
		plugin.getFM().getFile("config").set("lobby.yaw", location.getYaw());
		plugin.getFM().saveFile("config");
		player.sendMessage("Lobby location set!");
	}

	@Override
	public String name() {
		return "setlobby";
	}

	@Override
	public String info() {
		return "Sets the lobby location";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}
}
