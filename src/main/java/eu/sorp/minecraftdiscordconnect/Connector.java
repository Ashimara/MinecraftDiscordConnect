package eu.sorp.minecraftdiscordconnect;

/**
 *
 * @author sorp, ashimara
 */
public class Connector {
    
    public static void sendMinecraftMessage(String message){
        MinecraftDiscordConnect.instance.getServer().broadcastMessage(message);
    }
    
    public static void sendDiscordMessage(String message){
        for(String channelID : MinecraftDiscordConnect.config.sendChannelIDs){
            System.out.println(Long.parseLong(channelID));
            MinecraftDiscordConnect.client.getChannelByID(Long.parseLong(channelID)).sendMessage(message);
        }
    }
    
}
