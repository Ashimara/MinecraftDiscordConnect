package eu.sorp.minecraftdiscordconnect.listener;

import eu.sorp.minecraftdiscordconnect.Connector;
import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

/**
 *
 * @author ashimara
 */
public class BroadcastListener implements Listener {
    
    @EventHandler
    public void onCommand(ServerCommandEvent event){
        if(event.getCommand().startsWith("say")){
            if (event.getCommand().replaceAll("say", "").length() > 0){
                String broadcastMsg = MinecraftDiscordConnect.config.broadcastMessage;
                broadcastMsg = broadcastMsg.replaceAll("%u%", "Server");
                broadcastMsg = broadcastMsg.replaceAll("%m%", event.getCommand().replaceAll("say", ""));
                Connector.sendDiscordMessage(broadcastMsg);
            }
        }
    }
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        if(event.getMessage().startsWith("/say")){
            if (event.getMessage().replaceAll("/say", "").length() > 0){
                String broadcastMsg = MinecraftDiscordConnect.config.broadcastMessage;
                broadcastMsg = broadcastMsg.replaceAll("%u%", event.getPlayer().getName());
                broadcastMsg = broadcastMsg.replaceAll("%m%", event.getMessage().replaceAll("/say", ""));
                Connector.sendDiscordMessage(broadcastMsg);
            }
        }
    }
    
    
}
