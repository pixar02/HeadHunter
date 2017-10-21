package mc.pixar02.PlayerHunter.Managers;

import java.util.UUID;

import org.bukkit.Bukkit;

import mc.pixar02.PlayerHunter.PlayerHunter;
import mc.pixar02.PlayerHunter.Game.GPlayer;

public class StorageManager {
	private PlayerHunter plugin;
	private String method;

	public StorageManager(PlayerHunter plugin) {
		this.plugin = plugin;
		switch (plugin.getFM().getFile("config").getString("storage-method")) {
		case "mysql":
			this.setMethod("MySQL");
		case "sqlite":
			this.setMethod("SqLite");
		case "mongodb":
			this.setMethod("MongoDB");
		case "h2":
			this.setMethod("H2");

		}
	}

	public void savePlayer(GPlayer player) {
		
	}

	public void savePlayerAsync(UUID uuid, String name, int wins, int kills, int balance) {
		Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}

		});
	}

	public void loadPlayer(GPlayer player) {
		Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}

		});
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
