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
    
    public boolean connectAutoConnect;
    public boolean connectJoinMessages;
    public boolean connectChatMessages;
    public boolean connectDeathMessages;
    public boolean connectDiscordMessages;
    public boolean connectOriginalUser;
    
    
    public String joinMessage;
    public String quitMessage;
    public String chatMessage;
    public String broadcastMessage;
    public String discordMessage;
    
    
    
    public String tokenPath;
    public String sendChannelIDsPath;
    public String recieveChannelIDsPath;
    
    public String connectAutoConnectPath;
    public String connectJoinMessagesPath;
    public String connectChatMessagesPath;
    public String connectDeathMessagesPath;
    public String connectDiscordMessagesPath;
    public String connectOriginalUserPath;
    
    public String joinMessagePath;
    public String quitMessagePath;
    public String chatMessagePath;
    public String broadcastMessagePath;
    public String discordMessagePath;
    
    public Config(){
        tokenPath = "discord.bot-token";
        sendChannelIDsPath = "discord.send.channel-ids";
        recieveChannelIDsPath = "discord.recieve.channel-ids";
        
        connectAutoConnectPath = "settings.connect.autoConnect";
        connectJoinMessagesPath = "settings.connect.joinMessages";
        connectChatMessagesPath = "settings.connect.chatMessages";
        connectDeathMessagesPath = "settings.connect.deathMessages";
        connectDiscordMessagesPath = "settings.connect.discordMessages";
        connectOriginalUserPath = "settings.connect.originalUser";
        
        joinMessagePath = "messages.joinMessage";
        quitMessagePath = "messages.quitMessage";
        chatMessagePath = "messages.chatMessage";
        broadcastMessagePath = "messages.broadcastMessage";
        discordMessagePath = "messages.discordMessage";
        
        ArrayList<String> defaultID = new ArrayList<>();
        defaultID.add("INSERT-ID-HERE");
        
        MinecraftDiscordConnect.instance.getConfig().addDefault(tokenPath, "INSERT-TOKEN-HERE");
        MinecraftDiscordConnect.instance.getConfig().addDefault(sendChannelIDsPath, defaultID.clone());
        MinecraftDiscordConnect.instance.getConfig().addDefault(recieveChannelIDsPath, defaultID.clone());
        
        MinecraftDiscordConnect.instance.getConfig().addDefault(connectAutoConnectPath, true);
        MinecraftDiscordConnect.instance.getConfig().addDefault(connectJoinMessagesPath, true);
        MinecraftDiscordConnect.instance.getConfig().addDefault(connectChatMessagesPath, true);
        MinecraftDiscordConnect.instance.getConfig().addDefault(connectDeathMessagesPath, true);
        MinecraftDiscordConnect.instance.getConfig().addDefault(connectDiscordMessagesPath, true);
        MinecraftDiscordConnect.instance.getConfig().addDefault(connectOriginalUserPath, true);
        
        MinecraftDiscordConnect.instance.getConfig().addDefault(joinMessagePath, "%u% joined the game");
        MinecraftDiscordConnect.instance.getConfig().addDefault(quitMessagePath, "%u% left the game");
        MinecraftDiscordConnect.instance.getConfig().addDefault(chatMessagePath, "<%u%> %m%");
        MinecraftDiscordConnect.instance.getConfig().addDefault(broadcastMessagePath, "[%u%] %m%");
        MinecraftDiscordConnect.instance.getConfig().addDefault(discordMessagePath, "[Discord] <%u%> %m%");
        
        MinecraftDiscordConnect.instance.getConfig().options().copyDefaults(true);
        MinecraftDiscordConnect.instance.saveConfig();
        
        read();
        
    }
    
    private void read(){
        token = MinecraftDiscordConnect.instance.getConfig().getString(tokenPath); 
        sendChannelIDs = MinecraftDiscordConnect.instance.getConfig().getStringList(sendChannelIDsPath);
        recieveChannelIDs = MinecraftDiscordConnect.instance.getConfig().getStringList(recieveChannelIDsPath);
        
        connectAutoConnect = MinecraftDiscordConnect.instance.getConfig().getBoolean(connectAutoConnectPath);
        connectJoinMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean(connectJoinMessagesPath);
        connectChatMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean(connectChatMessagesPath);
        connectDeathMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean(connectDeathMessagesPath);
        connectDiscordMessages = MinecraftDiscordConnect.instance.getConfig().getBoolean(connectDiscordMessagesPath);
        connectOriginalUser = MinecraftDiscordConnect.instance.getConfig().getBoolean(connectOriginalUserPath);
        
        joinMessage = MinecraftDiscordConnect.instance.getConfig().getString(joinMessagePath); 
        quitMessage = MinecraftDiscordConnect.instance.getConfig().getString(quitMessagePath); 
        chatMessage = MinecraftDiscordConnect.instance.getConfig().getString(chatMessagePath); 
        broadcastMessage = MinecraftDiscordConnect.instance.getConfig().getString(broadcastMessagePath); 
        discordMessage = MinecraftDiscordConnect.instance.getConfig().getString(discordMessagePath); 
    }
    
}
