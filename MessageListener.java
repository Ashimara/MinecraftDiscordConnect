package eu.sorp.minecraftdiscordconnect.discord.listener;

import eu.sorp.minecraftdiscordconnect.Connector;
import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 *
 * @author sorp, ashimara
 */
public class MessageListener implements IListener<MessageReceivedEvent>{

    @Override
    public void handle(MessageReceivedEvent event) {
        String discordMsg = MinecraftDiscordConnect.config.discordMessage;
        discordMsg = discordMsg.replaceAll("%u%", event.getMessage().getAuthor().getDisplayName(event.getGuild()));
        discordMsg = discordMsg.replaceAll("%m%", event.getMessage().getContent());
        if(event.getMessage().getContent().length() >= 1)
            Connector.sendMinecraftMessage(discordMsg);
    }
    
}
