package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class ReloadCmd extends BaseCmd {

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		return "reload";
	}

	@Override
	public String info() {
		return "Reloads the plugin";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}

}
