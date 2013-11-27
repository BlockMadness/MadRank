package com.blockmadness.kcin.madrank;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class MadRank extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static MadRank plugin; 
	
	public void onEnable() {
		PluginDescriptionFile pdfFile = this .getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + "Has Been enabled!!");
		
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
		PluginDescriptionFile pdfFile = this .getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");	// Stop timer thread
	}
	
}