package com.blockmadness.kcin.madrank;

import org.bukkit.plugin.java.JavaPlugin;

public class MadRank extends JavaPlugin {
	
	public void onEnable() {
		/* Start timer thread
		 * 
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