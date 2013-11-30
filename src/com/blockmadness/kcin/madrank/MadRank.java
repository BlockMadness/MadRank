package com.blockmadness.kcin.madrank;

import java.io.File;
import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class MadRank extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft"); //Logger
    public static Permission perms = null; // Permissions
    FileConfiguration config; // Config
	public static MadRank plugin; 
	
	public void onEnable() {

		
		//Generate config if not exists.
		try { 
			if (!new File(getDataFolder(), "Madrank.yml").exists()) {
				new File(getDataFolder(), "Madrank.yml").createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	// Vault and Permissions
    	if (!setupPermissions()) {
    		log.info(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
	
		/* Start timer thread
		 * 
		 * Connect to MYSQL database.
		 * Also need to do something about reloads using:
		 * for(Player player : this.getServer().getOnlinePlayers()) {
		 *	playerList.put(player, playerData(player));
		 * }
		 */
		
		getCommand("playtime").setExecutor(new Commands(this));
		getCommand("age").setExecutor(new Commands(this));
	}
	
	public void onDisable() {
	// Stop timer thread
	}
	
}