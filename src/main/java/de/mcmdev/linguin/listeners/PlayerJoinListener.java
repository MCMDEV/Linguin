package de.mcmdev.linguin.listeners;

import de.mcmdev.linguin.Linguin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final Linguin linguin;

    public PlayerJoinListener(Linguin linguin) {
        this.linguin = linguin;
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event)  {
        linguin.getLanguageManager().join(event.getPlayer());
    }

}
