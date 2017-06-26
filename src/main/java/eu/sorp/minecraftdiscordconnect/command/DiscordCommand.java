package eu.sorp.minecraftdiscordconnect.command;

import eu.sorp.minecraftdiscordconnect.Connector;
import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import eu.sorp.minecraftdiscordconnect.discord.DiscordClient;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.HandlerList;

/**
 *
 * @author ashimara
 */
public class DiscordCommand implements TabExecutor{
    
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(strings[0].equals("connect")){
            if(!MinecraftDiscordConnect.client.isLoggedIn()){
                MinecraftDiscordConnect.client = DiscordClient.createClient(MinecraftDiscordConnect.config.token);
                MinecraftDiscordConnect.instance.registerDiscordListeners();
                cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Connected your Discord Bot!");
                cs.getServer().broadcastMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "The Discord Bot was connected by " + ChatColor.GREEN + cs.getName() + ChatColor.GRAY + "!");
            }else
                cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Your Discord Bot is already connected!");
            return true;
        }else if(strings[0].equals("disconnect")){
            if(MinecraftDiscordConnect.client.isLoggedIn()){
                Connector.sendDiscordMessage("This Bot is now disonnected");
                MinecraftDiscordConnect.client.logout();
                HandlerList.unregisterAll(MinecraftDiscordConnect.instance);
                cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Disconnected your Discord Bot!");
                cs.getServer().broadcastMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "The Discord Bot was disconnected by " + ChatColor.RED + cs.getName() + ChatColor.GRAY + "!");
            }else
                cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Your Discord Bot is already disconnected!");
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1){
            List<String> list = new ArrayList<>();
            list.add("connect");
            list.add("disconnect");
            return list;
        }
        return null;
    }

}
