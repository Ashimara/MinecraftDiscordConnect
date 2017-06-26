package eu.sorp.minecraftdiscordconnect.command;

import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

/**
 *
 * @author ashimara
 */
public class SettingsCommand implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            switch(args[0]){
                case "joinMessages":
                    sender.sendMessage(args[0] + " = " + MinecraftDiscordConnect.config.connectJoinMessages);
                    break;
                case "chatMessages":
                    sender.sendMessage(args[0] + " = " + MinecraftDiscordConnect.config.connectChatMessages);
                    break;
                case "deathMessages":
                    sender.sendMessage(args[0] + " = " + MinecraftDiscordConnect.config.connectDeathMessages);
                    break;
                case "discordMessages":
                    sender.sendMessage(args[0] + " = " + MinecraftDiscordConnect.config.connectDiscordMessages);
                    break;
                case "displayOriginalUser":
                    sender.sendMessage(args[0] + " = " + MinecraftDiscordConnect.config.connectOriginalUser);
                    break;
                default:
                    return false;
            }
            return true;
        }else if(args.length >= 2){
            if(!args[1].equalsIgnoreCase("true")||args[1].equalsIgnoreCase("false"))
                return false;
            boolean setting = Boolean.parseBoolean(args[1]);
            switch(args[0]){
                case "joinMessages":
                    MinecraftDiscordConnect.instance.getConfig().set(MinecraftDiscordConnect.config.connectJoinMessagesPath, setting);
                    MinecraftDiscordConnect.instance.saveConfig();
                    MinecraftDiscordConnect.instance.reloadConfig();
                    MinecraftDiscordConnect.config.connectJoinMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean(MinecraftDiscordConnect.config.connectJoinMessagesPath);
                    break;
                case "chatMessages":
                    MinecraftDiscordConnect.instance.getConfig().set(MinecraftDiscordConnect.config.connectChatMessagesPath, setting);
                    MinecraftDiscordConnect.instance.saveConfig();
                    MinecraftDiscordConnect.instance.reloadConfig();
                    MinecraftDiscordConnect.config.connectChatMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean(MinecraftDiscordConnect.config.connectChatMessagesPath);
                    break;
                case "deathMessages":
                    MinecraftDiscordConnect.instance.getConfig().set(MinecraftDiscordConnect.config.connectDeathMessagesPath, setting);
                    MinecraftDiscordConnect.instance.saveConfig();
                    MinecraftDiscordConnect.instance.reloadConfig();
                    MinecraftDiscordConnect.config.connectDeathMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean(MinecraftDiscordConnect.config.connectDeathMessagesPath);
                    break;
                case "discordMessages":
                    MinecraftDiscordConnect.instance.getConfig().set(MinecraftDiscordConnect.config.connectDiscordMessagesPath, setting);
                    MinecraftDiscordConnect.instance.saveConfig();
                    MinecraftDiscordConnect.instance.reloadConfig();
                    MinecraftDiscordConnect.config.connectDiscordMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean(MinecraftDiscordConnect.config.connectDiscordMessagesPath);
                    break;
                case "displayOriginalUser":
                    MinecraftDiscordConnect.instance.getConfig().set(MinecraftDiscordConnect.config.connectOriginalUserPath, setting);
                    MinecraftDiscordConnect.instance.saveConfig();
                    MinecraftDiscordConnect.instance.reloadConfig();
                    MinecraftDiscordConnect.config.connectOriginalUser = MinecraftDiscordConnect.instance.getConfig().getBoolean(MinecraftDiscordConnect.config.connectOriginalUserPath);
                    break;
                default: 
                    return false;
            }
            sender.sendMessage(ChatColor.BLUE + "[Discord] " + ChatColor.GRAY + "Setting updated");
            return true;
        }
        return false;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if(args.length == 1){
            if("joinMessages".startsWith(args[0]))list.add("joinMessages");
            if("chatMessages".startsWith(args[0]))list.add("chatMessages");
            if("deathMessages".startsWith(args[0]))list.add("deathMessages");
            if("discordMessages".startsWith(args[0]))list.add("discordMessages");
            if("displayOriginalUser".startsWith(args[0]))list.add("displayOriginalUser");
            return list;
        }else if(args.length == 2){
            if("true".startsWith(args[1]))list.add("true");
            if("false".startsWith(args[1]))list.add("false");
            return list;
        }
        return null;
    }

}
