package de.mcmdev.linguin;

import com.comphenix.protocol.ProtocolLibrary;
import de.mcmdev.linguin.adapter.ClientSettingsAdapter;
import de.mcmdev.linguin.api.LinguinAPI;
import de.mcmdev.linguin.listeners.PlayerJoinListener;
import de.mcmdev.linguin.manager.LanguageManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Linguin extends JavaPlugin {

    public static LinguinAPI linguinAPI;

    @Getter
    private LanguageManager languageManager;

    @Override
    public void onEnable() {
        this.languageManager = new LanguageManager(this);
        ProtocolLibrary.getProtocolManager().addPacketListener(new ClientSettingsAdapter(this));
        //this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

        linguinAPI = new LinguinAPI(languageManager);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LinguinAPI getAPI() {
        return linguinAPI;
    }
}
