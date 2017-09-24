package mc.pixar02.PlayerHunter.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import mc.pixar02.PlayerHunter.PlayerHunter;

public class FileManager {
	private PlayerHunter plugin = PlayerHunter.getPlugin(PlayerHunter.class);

	private FileConfiguration messages;

	private File messagesFile;

	public void setup() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		/*
		 * Checking if messages.yml exists creating it if not
		 */
		messagesFile = new File(plugin.getDataFolder(), "messages.yml");
		if (!messagesFile.exists()) {
			try {
				messagesFile.createNewFile();
				copy(plugin.getResource("messages.yml"), messagesFile);
				if (plugin.debug) {
					Bukkit.getServer().getConsoleSender()
							.sendMessage(ChatColor.GREEN + "The messages.yml file has been created");
				}
			} catch (IOException e) {
				if (plugin.debug) {
					Bukkit.getServer().getConsoleSender()
							.sendMessage(ChatColor.RED + "Could not create the messages.yml file" + e);
				}
			}
		}
		messages = YamlConfiguration.loadConfiguration(messagesFile);
		/*
		 * Checking if config.yml exists creating it if not
		 */
		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
	}

	public void saveFile(String s) {
		try {
			if (s == "messages") {
				messages.save(messagesFile);
			} else if (s == "config") {
				plugin.saveConfig();
			} else if (s == "all") {
				messages.save(messagesFile);
				plugin.saveConfig();
			}

		} catch (IOException e) {
			if (plugin.debug) {
				Bukkit.getServer().getConsoleSender()
						.sendMessage(ChatColor.RED + "Could not save the " + s + ".yml file" + e);
			}
		}
	}

	public void reloadFile(String s) {
		if (s == "config") {
			plugin.reloadConfig();
		} else if (s == "messages") {
			messages = YamlConfiguration.loadConfiguration(messagesFile);
		} else if (s == "all") {
			plugin.reloadConfig();
			messages = YamlConfiguration.loadConfiguration(messagesFile);
		}
	}

	public FileConfiguration getFile(String s) {
		if (s == "config") {
			return plugin.getConfig();
		} else if (s == "messages") {
			return messages;
		} else {
			return null;
		}
	}

	private void copy(InputStream in, File file) {
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
