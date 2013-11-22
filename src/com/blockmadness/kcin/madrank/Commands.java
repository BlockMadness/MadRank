package com.blockmadness.kcin.madrank;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
	
	private MadRank plugin;
	
	public Commands(MadRank plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("playtime") | cmd.getName().equalsIgnoreCase("age")) { // If the player typed /playtime or /age
			/* Check for arguments using
			 * 
			 * if(args.length > 1) {
			 * 	sender.sendMessage("Too many arguments!");
			 * 	return false;
			 * } elseif(args.length == 1) {
			 * 	// they typed in a player name after the command (or something else, but it's something!)
			 * } elseif(args.length < 1) {
			 * 	// they didn't type anything after the command, so send them their playtime
			 *	// don't forget to check if it's a player or the console ofc (see below)
			 * }
			 * 
			 * 
			 * If no arguments then make sure to check if it's a player or the console using
			 *
			 * if(sender instanceof Player) {
			 *	sender.sendMessage("This command can only be run by a player.");
			 * } else {
			 *	Player player = (Player) sender;
			 *	// do something
			 * }
			 * 
			 * 
			 * Checking for permissions (do this after you checked if it's console or not)
			 * 
			 * if(player.hasPermission("madrank.playtime")) {
			 * 	// Do someting
			 * } else {
			 * 	// no permission, send message to player
			}*/
			return true;
		}
		return false;
	}
	
}