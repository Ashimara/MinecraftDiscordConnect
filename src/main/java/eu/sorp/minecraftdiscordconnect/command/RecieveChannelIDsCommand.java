package eu.sorp.minecraftdiscordconnect.command;

import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author ashimara
 */
public class RecieveChannelIDsCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(strings.length >= 1){
            MinecraftDiscordConnect.instance.getConfig().set("discord.recieve.channel-ids", strings);
            MinecraftDiscordConnect.instance.saveConfig();
            MinecraftDiscordConnect.instance.reloadConfig();
            MinecraftDiscordConnect.config.recieveChannelIDs = MinecraftDiscordConnect.instance.getConfig().getStringList("discord.recieve.channel-ids");
            cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "RecieveChannelIDs updated");
            return true;
        }
        return false;
    }
    
}
