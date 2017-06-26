package eu.sorp.minecraftdiscordconnect.command;

import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

/**
 *
 * @author ashimara
 */
public class ChannelIDsCommand implements TabExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(strings.length >= 2){
            List<String> args = new ArrayList<>();
            args.addAll(Arrays.asList(strings));
            if(strings[0].equals("send")){
                args.remove("send");
                MinecraftDiscordConnect.instance.getConfig().set(MinecraftDiscordConnect.config.sendChannelIDsPath, args);
                MinecraftDiscordConnect.instance.saveConfig();
                MinecraftDiscordConnect.instance.reloadConfig();
                MinecraftDiscordConnect.config.sendChannelIDs = MinecraftDiscordConnect.instance.getConfig().getStringList(MinecraftDiscordConnect.config.sendChannelIDsPath);
                cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "SendChannelIDs updated");
            }else if(strings[0].equals("recieve")){
                args.remove("recieve");
                MinecraftDiscordConnect.instance.getConfig().set(MinecraftDiscordConnect.config.recieveChannelIDsPath, args);
                MinecraftDiscordConnect.instance.saveConfig();
                MinecraftDiscordConnect.instance.reloadConfig();
                MinecraftDiscordConnect.config.recieveChannelIDs = MinecraftDiscordConnect.instance.getConfig().getStringList(MinecraftDiscordConnect.config.recieveChannelIDsPath);
                cs.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "RecieveChannelIDs updated");
            }
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if(args.length == 1){
            list.add("send");
            list.add("recieve");
            return list;
        }
        return list;
    }
    
}
