package eu.sorp.minecraftdiscordconnect;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sorp, ashimara
 */
public class Config {
    
    public String token;
    public List<String> sendChannelIDs;
    public List<String> recieveChannelIDs;
    
    public boolean connectJoinMessages;
    public boolean connectChatMessages;
    public boolean connectDiscordMessages;
    
    public String joinMessage;
    public String quitMessage;
    public String chatMessage;
    public String discordMessage;
    
    public Config(){
        ArrayList<String> defaultID = new ArrayList<>();
        defaultID.add("INSERT-ID-HERE");
        
        MinecraftDiscordConnect.instance.getConfig().addDefault("discord.bot-token", "INSERT-TOKEN-HERE");
        MinecraftDiscordConnect.instance.getConfig().addDefault("discord.send.channel-ids", defaultID.clone());
        MinecraftDiscordConnect.instance.getConfig().addDefault("discord.recieve.channel-ids", defaultID.clone());
        MinecraftDiscordConnect.instance.getConfig().addDefault("settings.connectJoinMessages", true);
        MinecraftDiscordConnect.instance.getConfig().addDefault("settings.connectChatMessages", true);
        MinecraftDiscordConnect.instance.getConfig().addDefault("settings.connectDiscordMessages", true);
        MinecraftDiscordConnect.instance.getConfig().addDefault("messages.joinMessage", "%u% joined the game");
        MinecraftDiscordConnect.instance.getConfig().addDefault("messages.quitMessage", "%u% left the game");
        MinecraftDiscordConnect.instance.getConfig().addDefault("messages.chatMessage", "<%u%> %m%");
        MinecraftDiscordConnect.instance.getConfig().addDefault("messages.discordMessage", "[Discord] <%u%> %m%");
        MinecraftDiscordConnect.instance.getConfig().options().copyDefaults(true);
        MinecraftDiscordConnect.instance.saveConfig();
        
        read();
        
    }
    
    private void read(){
        token = MinecraftDiscordConnect.instance.getConfig().getString("discord.bot-token"); 
        sendChannelIDs = MinecraftDiscordConnect.instance.getConfig().getStringList("discord.send.channel-ids");
        recieveChannelIDs = MinecraftDiscordConnect.instance.getConfig().getStringList("discord.recieve.channel-ids");
        connectJoinMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean("settings.connectJoinMessages");
        connectChatMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean("settings.connectChatMessages");
        connectDiscordMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean("settings.connectDiscordMessages");
        joinMessage = MinecraftDiscordConnect.instance.getConfig().getString("messages.joinMessage"); 
        quitMessage = MinecraftDiscordConnect.instance.getConfig().getString("messages.quitMessage"); 
        chatMessage = MinecraftDiscordConnect.instance.getConfig().getString("messages.chatMessage"); 
        discordMessage = MinecraftDiscordConnect.instance.getConfig().getString("messages.discordMessage"); 
    }
    
}
