package mc.pixar02.PlayerHunter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String message, String[] args) {
		// TODO Auto-generated method stub
		if (cmd.equals("HeadHunter")) {
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("Join")) {
					if (args.length > 1) {
						String arena = args[1];
						//
					} else {
						// send command usage
					}
				} else if (args[0].equalsIgnoreCase("")) {

				}
			} else {

			}
		}

		return false;
	}

}
