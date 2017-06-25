package eu.sorp.minecraftdiscordconnect.command;

import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import eu.sorp.minecraftdiscordconnect.discord.DiscordClient;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author ashimara
 */
public class ConnectDiscordCommand implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(!MinecraftDiscordConnect.client.isLoggedIn()){
            MinecraftDiscordConnect.client = DiscordClient.createClient(MinecraftDiscordConnect.config.token);
            MinecraftDiscordConnect.instance.registerDiscordListeners();
            cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Connected your Discord Bot!");
            cs.getServer().broadcastMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "The Discord Bot was connected by " + ChatColor.GREEN + cs.getName() + ChatColor.GRAY + "!");
        }else
            cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Your Discord Bot is already connected!");
        return true;
    }

}
