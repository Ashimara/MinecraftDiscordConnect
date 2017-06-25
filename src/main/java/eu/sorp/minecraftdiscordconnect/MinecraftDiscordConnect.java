package eu.sorp.minecraftdiscordconnect;

import eu.sorp.minecraftdiscordconnect.command.ConnectDiscordCommand;
import eu.sorp.minecraftdiscordconnect.command.DisconnectDiscordCommand;
import eu.sorp.minecraftdiscordconnect.discord.DiscordClient;
import eu.sorp.minecraftdiscordconnect.discord.listener.MessageListener;
import eu.sorp.minecraftdiscordconnect.discord.listener.ReadyListener;
import eu.sorp.minecraftdiscordconnect.listener.ChatListener;
import eu.sorp.minecraftdiscordconnect.listener.JoinListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;

/**
 *
 * @author sorp, ashimara
 */
public class MinecraftDiscordConnect extends JavaPlugin {

    public static MinecraftDiscordConnect instance;
    public static IDiscordClient client;
    public static Config config;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("[MinecraftDiscordConnect] Enabled Plugin (v. " + getDescription().getVersion() + ")");
        
        config = new Config();
        
        if(config.token.equals("INSERT-TOKEN-HERE")){
            System.out.println("[MinecraftDiscordConnect] Please insert your bot-token");
            return;
        }
        
        client = DiscordClient.createClient(config.token); 
        
        registerDiscordListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        client.logout();
        System.out.println("[MinecraftDiscordConnect] Disabled Plugin (v. " + getDescription().getVersion() + ")");
    }
    
    public void registerMinecraftListeners(){
        PluginManager pluginManager = getServer().getPluginManager();
        if(config.connectChatMessages) pluginManager.registerEvents(new ChatListener(), this);
        if(config.connectJoinMessages) pluginManager.registerEvents(new JoinListener(), this);
    }
    
    public void registerDiscordListeners(){
        EventDispatcher eventDispatcher = client.getDispatcher();
        eventDispatcher.registerListener(new ReadyListener());
        if(config.connectDiscordMessages) eventDispatcher.registerListener(new MessageListener());
    }
    
    public void registerCommands(){
        getCommand("discordconnect").setExecutor(new ConnectDiscordCommand());
        getCommand("discorddisconnect").setExecutor(new DisconnectDiscordCommand());
    }
    
}
