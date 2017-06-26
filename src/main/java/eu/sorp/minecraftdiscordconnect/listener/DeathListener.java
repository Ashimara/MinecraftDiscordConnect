package eu.sorp.minecraftdiscordconnect.listener;

import eu.sorp.minecraftdiscordconnect.Connector;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 *
 * @author ashimara
 */
public class DeathListener implements Listener{
    
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Connector.sendDiscordMessage(event.getDeathMessage());
    }
    
}
