package eu.sorp.minecraftdiscordconnect;

/**
 *
 * @author sorp
 */
public class Connector {
    
    public static void sendMinecraftMessage(String message){
        MinecraftDiscordConnect.instance.getServer().broadcastMessage(message);
    }
    
    public static void sendDiscordMessage(String message){
        long channelID = Long.parseLong(MinecraftDiscordConnect.config.channelID);
        MinecraftDiscordConnect.client.getChannelByID(channelID).sendMessage(message);
    }
    
}
