package eu.sorp.minecraftdiscordconnect.discord.listener;

import eu.sorp.minecraftdiscordconnect.Connector;
import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.ReadyEvent;

/**
 *
 * @author sorp, ashimara
 */
public class ReadyListener implements IListener<ReadyEvent> {

    @Override
    public void handle(ReadyEvent event) {
        if(event.getClient().equals(MinecraftDiscordConnect.client)){
            MinecraftDiscordConnect.instance.registerMinecraftListeners();
            Connector.sendDiscordMessage("This Bot is now connected");
        }
    }

}