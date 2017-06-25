package eu.sorp.minecraftdiscordconnect.command;

import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

/**
 *
 * @author ashimara
 */
public class DisconnectDiscordCommand implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(MinecraftDiscordConnect.client.isLoggedIn()){
            MinecraftDiscordConnect.client.logout();
            HandlerList.unregisterAll(MinecraftDiscordConnect.instance);
            cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.RESET + "Disconnected your Discord Bot!");
            cs.getServer().broadcastMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "The Discord Bot was disconnected by " + ChatColor.RED + cs.getName() + ChatColor.GRAY + "!");
        }else
            cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.RESET + "Your Discord Bot is already disconnected!");
        return true;
    }

}
