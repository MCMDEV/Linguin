package de.mcmdev.linguin.manager;

import de.mcmdev.linguin.downloader.IAssetDownloader;
import de.mcmdev.linguin.downloader.InventivetalentAssetDownloader;
import de.mcmdev.linguin.loader.LanguageLoader;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LanguageManager {

    private final JavaPlugin plugin;
    private final File languageFolder;
    private final IAssetDownloader assetDownloader;
    private final LanguageLoader languageLoader;
    private final Map<UUID, String> locales = new HashMap<>();

    public LanguageManager(JavaPlugin plugin) {
        this.plugin = plugin;

        this.languageFolder = createLanguageFolder();
        this.assetDownloader = new InventivetalentAssetDownloader(languageFolder);
        this.languageLoader = new LanguageLoader(languageFolder);
    }

    public void setLocale(Player player, String locale) {
        this.locales.put(player.getUniqueId(), locale);
    }

    public String getLocale(Player player)  {
        return locales.computeIfAbsent(player.getUniqueId(), uuid -> "en_us");
    }

    public void join(Player player) {
        String locale = transformLocale(getLocale(player));
        assetDownloader.upgrade(locale);
    }

    public String getLocalizedEntry(String languageName, String key)    {
        return languageLoader.loadEntry(transformLocale(languageName), key);
    }

    private File createLanguageFolder()    {
        return new File(plugin.getDataFolder() + "/lang");
    }

    public String transformLocale(String locale)   {
        return locale.toLowerCase();
    }

}
