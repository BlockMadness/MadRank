package com.blockmadness.kcin.madrank;

import java.io.File;
import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class MadRank extends JavaPlugin {
	
	/** Register variables
	 * 
	 * Chat logger
	 * File configuration
	 * Permission variable static
	 * Plugin variable static
	 */
	public final Logger log = Logger.getLogger("Minecraft");
    public FileConfiguration config;
	public static Permission perms = null;
	public static MadRank plugin; 
	
	
	public void onEnable() {
		
		// Generate config if not exists.
		try { 
			if (!new File(getDataFolder(), "MadRank.yml").exists()) {
				new File(getDataFolder(), "MadRank.yml").createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	// Vault and Permissions
    	if (!setupPermissions()) {
    		log.info(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
    	}
	
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
	
    private boolean setupPermissions() {
        Permission permission = null;
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
	
}