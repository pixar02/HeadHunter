package mc.pixar02.PlayerHunter.API;

import org.bukkit.entity.Player;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Game.GPlayer;
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
		GPlayer gPlayer = (GPlayer) pl;
		// %playerhunter_player_wins%
		if (identifier.equalsIgnoreCase("player_wins")) {
			return String.valueOf(gPlayer.getWins());
		}
		// %playerhunter_player_balance%
		if (identifier.equalsIgnoreCase("player_balance")) {
			return String.valueOf(gPlayer.getBalance());
		}
		// %playerhunter_player_deaths%
		if (identifier.equalsIgnoreCase("player_deaths")) {
			return String.valueOf(gPlayer.getDeaths());
		}
		// %playerhunter_player_kills%
		if (identifier.equalsIgnoreCase("player_kills")) {
			return String.valueOf(gPlayer.getKills());
		}
		// %playerhunter_XXX%
		if (identifier.equalsIgnoreCase("XXX")) {
			return "XXX";
		}
		return null;
	}

}
