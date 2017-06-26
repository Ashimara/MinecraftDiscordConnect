package eu.sorp.minecraftdiscordconnect.discord.listener;

import eu.sorp.minecraftdiscordconnect.Connector;
import eu.sorp.minecraftdiscordconnect.MinecraftDiscordConnect;
import org.bukkit.ChatColor;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 *
 * @author sorp, ashimara
 */
public class MessageListener implements IListener<MessageReceivedEvent>{

    @Override
    public void handle(MessageReceivedEvent event) {
        for(String channelID : MinecraftDiscordConnect.config.recieveChannelIDs){
            if(event.getChannel().getLongID() == Long.parseLong(channelID)){ 
                String discordMsg = MinecraftDiscordConnect.config.discordMessage; 
                if(event.getAuthor().getDisplayName(event.getGuild()).equals(event.getAuthor().getName())||!MinecraftDiscordConnect.config.displayUserUnnicked)
                    discordMsg = discordMsg.replaceAll("%u%", event.getAuthor().getDisplayName(event.getGuild()));
                else
                    discordMsg = discordMsg.replaceAll("%u%", event.getAuthor().getDisplayName(event.getGuild()) + " [" + event.getAuthor().getName() + "]");
                discordMsg = discordMsg.replaceAll("%m%", event.getMessage().getContent());
                discordMsg = ChatColor.translateAlternateColorCodes('&', discordMsg);
                if(event.getMessage().getContent().length() >= 1)
                    Connector.sendMinecraftMessage(discordMsg);
            }
        }
    }
    
}
