package eu.sorp.minecraftdiscordconnect.discord.listener;

import eu.sorp.minecraftdiscordconnect.Connector;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 *
 * @author sorp
 */
public class MessageListener implements IListener<MessageReceivedEvent>{

    @Override
    public void handle(MessageReceivedEvent event) {
        String author = event.getMessage().getAuthor().getDisplayName(event.getGuild());
        String message = event.getMessage().getContent();
        if(message.length() >= 1)
            Connector.sendMinecraftMessage("[Discord] <" + author + "> " + message);
    }
    
}
