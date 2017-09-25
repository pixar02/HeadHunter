package mc.pixar02.PlayerHunter.Managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Commands.BaseCmd;
import mc.pixar02.PlayerHunter.Commands.CreateCmd;
import mc.pixar02.PlayerHunter.Commands.DeleteCmd;
import mc.pixar02.PlayerHunter.Commands.HelpCmd;
import mc.pixar02.PlayerHunter.Commands.JoinCmd;
import mc.pixar02.PlayerHunter.Commands.LeaveCmd;
import mc.pixar02.PlayerHunter.Commands.ReloadCmd;
import mc.pixar02.PlayerHunter.Commands.StartCmd;
import mc.pixar02.PlayerHunter.Commands.StopCmd;

public class CommandManager implements CommandExecutor {

	private ArrayList<BaseCmd> cmds = new ArrayList<BaseCmd>();
	private PlayerHunter pl;

	public CommandManager(PlayerHunter pl) {
		this.pl = pl;
		// add new commands here:
		cmds.add(new HelpCmd(this));
		cmds.add(new ReloadCmd());
		cmds.add(new CreateCmd());
		cmds.add(new DeleteCmd());
		cmds.add(new JoinCmd());
		cmds.add(new LeaveCmd());
		cmds.add(new StartCmd());
		cmds.add(new StopCmd());

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("PlayerHunter")) {
			if (args.length == 0) {
				BaseCmd target = cmds.get(0);
				try {
					target.onCommand(player, args);
					return true;
				} catch (Exception ex) {
					player.sendMessage(ChatColor.DARK_RED + "An error occured while executing the command!");
					ex.printStackTrace();
				}

			}
			BaseCmd target = this.get(args[0]);
			if (target == null) {
				player.sendMessage(ChatColor.RED + "Invalid command");
				return true;
			}
			ArrayList<String> arraylist = new ArrayList<String>();
			arraylist.addAll(Arrays.asList(args));
			arraylist.remove(0);
			try {
				target.onCommand(player, args);
			} catch (Exception ex) {
				player.sendMessage(ChatColor.DARK_RED + "An error occured while executing the command!");
				ex.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	private BaseCmd get(String name) {
		Iterator<BaseCmd> basecmds = this.cmds.iterator();
		while (basecmds.hasNext()) {
			BaseCmd bc = (BaseCmd) basecmds.next();
			if (bc.name().equalsIgnoreCase(name)) {
				return bc;
			}
			String[] aliases = bc.aliases();
			int length = (bc.aliases()).length;
			for (int i = 0; i < length; i++) {
				String alias = aliases[i];
				if (name.equalsIgnoreCase(alias)) {
					return bc;
				}
			}
		}
		return null;
	}

	public ArrayList<BaseCmd> getCmds() {
		return cmds;
	}
}
