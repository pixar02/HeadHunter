package mc.pixar02.PlayerHunter.API;

import org.bukkit.entity.Player;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Managers.PlayerManager;
import me.clip.placeholderapi.external.EZPlaceholderHook;

public class PlaceHolders extends EZPlaceholderHook {
	private PlayerHunter plugin;

	public PlaceHolders(PlayerHunter plugin) {
		super(plugin, "playerhunter");
		this.plugin = plugin;
	}

	@Override
	public String onPlaceholderRequest(Player pl, String identifier) {

		if (pl == null) {
			return "";
		}
		PlayerManager PM = plugin.playerManager.get(pl.getUniqueId());
		// %playerhunter_player_wins%
		if (identifier.equalsIgnoreCase("player_wins")) {
			return "";
		}
		// %playerhunter_player_balance%
		if (identifier.equalsIgnoreCase("player_balance")) {
			return String.valueOf(PM.getBalance());
		}
		// %playerhunter_player_deaths%
		if (identifier.equalsIgnoreCase("player_deaths")) {
			return "";
		}
		// %playerhunter_player_kills%
		if (identifier.equalsIgnoreCase("player_kills")) {
			return "";
		}
		// %playerhunter_XXX%
		if (identifier.equalsIgnoreCase("XXX")) {
			return "XXX";
		}
		return null;
	}

}
