package de.mcmdev.linguin.adapter;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import de.mcmdev.linguin.Linguin;

public class ClientSettingsAdapter extends PacketAdapter {

    private final Linguin plugin;

    public ClientSettingsAdapter(Linguin plugin) {
        super(plugin, PacketType.Play.Client.SETTINGS);

        this.plugin = plugin;
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        String read = event.getPacket().getStrings().read(0);
        plugin.getLanguageManager().setLocale(event.getPlayer(), read);
        plugin.getLanguageManager().join(event.getPlayer());
    }
}
