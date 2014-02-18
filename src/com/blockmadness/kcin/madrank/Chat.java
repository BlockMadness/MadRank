package com.blockmadness.kcin.madrank;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Chat {
	
	private MadRank plugin;
	
	public Chat(MadRank plugin) {
		this.plugin = plugin;
	}
	
    /** Chat prefix and colors
     */
    public static String prefix = "&f[&4Mad&3Rank&f] ";
    public static ChatColor group = ChatColor.DARK_GREEN;
    public static ChatColor normal = ChatColor.WHITE;
    public static ChatColor special = ChatColor.GRAY;
    
    
    /** Class to send messages to players or the console
     * 
     * @author K_Cin
     * @category Chat
     * @param receiver To who or what the message will be send
     * @param message What needs to be send
     * @return Returns true if there where no problems, otherwise false
     * @version 0.1
     */
    public boolean cSendMsg(CommandSender receiver, String message) {
    	if(receiver instanceof Player) {
    		Player player = (Player) receiver;
    		player.sendMessage(addColor(message));
		} else {
			plugin.log.info(message);
		}
		return false;
    }
    
    
    /** Class to send colors to chat messages send to players. 
     * 
     * @author arriej
     * @author K_Cin
     * @category Chat
     * @param text String with chat color variables (&)
     * @return Returns String with actual colors
     * @version 0.1
     */
  	public String addColor(String text) {
  		 String output = text.replace("&0", ChatColor.BLACK + "");
  		 output = output.replace("&1", ChatColor.DARK_BLUE + "");
  		 output = output.replace("&2", ChatColor.DARK_GREEN + "");
  		 output = output.replace("&3", ChatColor.DARK_AQUA + "");
  		 output = output.replace("&4", ChatColor.DARK_RED + "");
  		 output = output.replace("&5", ChatColor.DARK_PURPLE + "");
  		 output = output.replace("&6", ChatColor.GOLD + "");
  		 output = output.replace("&7", ChatColor.GRAY + "");
  		 output = output.replace("&8", ChatColor.DARK_GRAY + "");
  		 output = output.replace("&9", ChatColor.BLUE + "");
  		 output = output.replace("&a", ChatColor.GREEN + "");
  		 output = output.replace("&b", ChatColor.AQUA + "");
  		 output = output.replace("&c", ChatColor.RED + "");
  		 output = output.replace("&d", ChatColor.LIGHT_PURPLE + "");
  		 output = output.replace("&e", ChatColor.YELLOW + "");
  		 output = output.replace("&l", ChatColor.BOLD + "");
  		 output = output.replace("&m", ChatColor.STRIKETHROUGH + "");
  		 output = output.replace("&n", ChatColor.UNDERLINE + "");
  		 output = output.replace("&o", ChatColor.ITALIC + "");
  		 output = output.replace("&r", ChatColor.RESET + "");

  		 return output;
  	}    
  	
}
