package eu.sorp.minecraftdiscordconnect.discord;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

/**
 *
 * @author sorp
 */
public class DiscordClient {
    
    public static IDiscordClient createClient(String token){
       
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.withToken(token);
        return clientBuilder.login();
        
    }
    
}
