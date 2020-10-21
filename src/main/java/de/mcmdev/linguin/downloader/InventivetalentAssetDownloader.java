package de.mcmdev.linguin.downloader;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class InventivetalentAssetDownloader implements IAssetDownloader {

    public static final String ASSETS_URL = "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.16.3/assets/minecraft/lang/%s.json";
    private final File languageFolder;

    public InventivetalentAssetDownloader(File languageFolder) {
        this.languageFolder = languageFolder;
    }

    @SneakyThrows
    @Override
    public void download(String name) {
        download(name, getLanguageFile(name));
    }

    @SneakyThrows
    private void download(String name, File file)   {
        String modifiedUrl = String.format(ASSETS_URL, name);
        FileUtils.copyURLToFile(new URL(modifiedUrl), file);
    }

    @Override
    public void upgrade(String name) {
        File languageFile = getLanguageFile(name);
        if(!languageFile.exists())    {
            download(name, languageFile);
        }
    }

    public File getLanguageFile(String languageName)   {
        return new File(languageFolder, languageName + ".json");
    }

    @Override
    public void downloadAll() {
        throw new UnsupportedOperationException("Not supported with InventivetalentAssetDownloader");
    }
}
