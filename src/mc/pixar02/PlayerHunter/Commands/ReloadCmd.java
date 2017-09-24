package mc.pixar02.PlayerHunter.Commands;

import org.bukkit.entity.Player;

public class ReloadCmd extends BaseCmd {

	@Override
	public void onCommand(Player player, String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "reload";
	}

	@Override
	public String info() {

		return "reloads the plugin";
	}

	@Override
	public String[] aliases() {

		return new String[0];
	}

}
