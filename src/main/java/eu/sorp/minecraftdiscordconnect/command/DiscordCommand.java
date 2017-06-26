package eu.sorp.minecraftdiscordconnect.command;

import eu.sorp.minecraftdiscordconnect.Connector;
import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import eu.sorp.minecraftdiscordconnect.discord.DiscordClient;
import eu.sorp.minecraftdiscordconnect.discord.listener.MessageListener;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.HandlerList;
import sx.blah.discord.handle.obj.StatusType;

/**
 *
 * @author ashimara
 */
public class DiscordCommand implements TabExecutor{
    
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(strings.length >= 1){
            if(strings[0].equals("enable")){
                if(MinecraftDiscordConnect.client.getOurUser().getPresence().getStatus() == StatusType.IDLE){
                    MinecraftDiscordConnect.client.online();
                    MinecraftDiscordConnect.client.getDispatcher().registerListener(new MessageListener());
                    MinecraftDiscordConnect.instance.registerMinecraftListeners();
                    cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Connected your Discord Bot!");
                    cs.getServer().broadcastMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "The Bot was enabled by " + ChatColor.GREEN + cs.getName() + ChatColor.GRAY + "!");
                }else
                    cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "The Bot is already enabled!");
                return true;
            }else if(strings[0].equals("disable")){
                if(MinecraftDiscordConnect.client.getOurUser().getPresence().getStatus() == StatusType.ONLINE){
                    MinecraftDiscordConnect.client.idle();
                    MinecraftDiscordConnect.client.getDispatcher().unregisterListener(MessageListener.instance);
                    HandlerList.unregisterAll(MinecraftDiscordConnect.instance);
                    cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Disconnected your Discord Bot!");
                    cs.getServer().broadcastMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "The Bot was disabled by " + ChatColor.RED + cs.getName() + ChatColor.GRAY + "!");
                }else
                    cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "The Bot is already disabled!");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1){
            List<String> list = new ArrayList<>();
            if("enable".startsWith(args[0]))list.add("enable");
            if("disable".startsWith(args[0]))list.add("disable");
            return list;
        }
        return null;
    }

}
