package de.mcmdev.linguin.manager;

import de.mcmdev.linguin.downloader.IAssetDownloader;
import de.mcmdev.linguin.downloader.InventivetalentAssetDownloader;
import de.mcmdev.linguin.loader.LanguageLoader;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class LanguageManager {

    private final JavaPlugin plugin;
    private final File languageFolder;
    private final IAssetDownloader assetDownloader;
    private final LanguageLoader languageLoader;

    public LanguageManager(JavaPlugin plugin) {
        this.plugin = plugin;

        this.languageFolder = createLanguageFolder();
        this.assetDownloader = new InventivetalentAssetDownloader(languageFolder);
        this.languageLoader = new LanguageLoader(languageFolder);
    }

    public void join(Player player) {
        String locale = transformLocale(player.getLocale());
        assetDownloader.upgrade(locale);
    }

    public String getLocalizedEntry(String languageName, String key)    {
        return languageLoader.loadEntry(transformLocale(languageName), key);
    }

    private File createLanguageFolder()    {
        File file = new File(plugin.getDataFolder() + "/lang");
        boolean success = file.mkdirs();

        if(!success)    {
            throw new IllegalStateException("Language folder could not be created.");
        }
        return file;
    }

    public String transformLocale(String locale)   {
        return locale.toLowerCase();
    }

}
