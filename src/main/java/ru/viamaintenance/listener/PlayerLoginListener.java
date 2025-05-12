package ru.viamaintenance.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import ru.viamaintenance.ViaMaintenance;
import org.bukkit.entity.Player;

public class PlayerLoginListener implements Listener {

    private final ViaMaintenance plugin;

    public PlayerLoginListener(ViaMaintenance plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (plugin.isMaintenanceMode()) {
            Player player = event.getPlayer();
            if (!player.hasPermission("viamaintenance.bypass")) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, plugin.getKickMessage());
            }
        }
    }
} 