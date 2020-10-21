package de.mcmdev.linguin.downloader;

public interface IAssetDownloader {

    void upgrade(String name);

    void download(String name);

    void downloadAll();

}
