package eu.sorp.minecraftdiscordconnect.listener;

import eu.sorp.minecraftdiscordconnect.Connector;
import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author sorp
 */
public class JoinListener implements Listener {
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        String joinMsg = MinecraftDiscordConnect.config.joinMessage;
        joinMsg = joinMsg.replaceAll("%u%", event.getPlayer().getName());
        Connector.sendDiscordMessage(joinMsg);
    }
    
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        String quitMsg = MinecraftDiscordConnect.config.quitMessage;
        quitMsg = quitMsg.replaceAll("%u%", event.getPlayer().getName());
        Connector.sendDiscordMessage(quitMsg);
    }
    
}
