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
public class SendChannelIDsCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(strings.length >= 1){
            MinecraftDiscordConnect.instance.getConfig().set("discord.send.channel-ids", strings);
            MinecraftDiscordConnect.instance.saveConfig();
            MinecraftDiscordConnect.instance.reloadConfig();
            MinecraftDiscordConnect.config.sendChannelIDs = MinecraftDiscordConnect.instance.getConfig().getStringList("discord.send.channel-ids");
            cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "SendChannelIDs updated");
            return true;
        }
        return false;
    }
    
}
