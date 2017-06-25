package eu.sorp.minecraftdiscordconnect.listener;

import eu.sorp.minecraftdiscordconnect.Connector;
import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 *
 * @author sorp, ashimara
 */
public class ChatListener implements Listener {
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        String chatMsg = MinecraftDiscordConnect.config.chatMessage;
        chatMsg = chatMsg.replaceAll("%u%", event.getPlayer().getName());
        chatMsg = chatMsg.replaceAll("%m%", event.getMessage());
        Connector.sendDiscordMessage(chatMsg);
    }
    
}
