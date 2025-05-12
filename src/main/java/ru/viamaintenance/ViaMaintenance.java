package ru.viamaintenance;

import org.bukkit.plugin.java.JavaPlugin;
import ru.viamaintenance.command.MaintenanceCommand;
import ru.viamaintenance.listener.PlayerLoginListener;
import org.bukkit.ChatColor;

public final class ViaMaintenance extends JavaPlugin {

    private boolean maintenanceMode = false;
    private String kickMessage;

    @Override
    public void onEnable() {
        // Load config
        saveDefaultConfig();
        reloadConfigValues();

        // Register command
        getCommand("maintenance").setExecutor(new MaintenanceCommand(this));

        // Register listener
        getServer().getPluginManager().registerEvents(new PlayerLoginListener(this), this);

        getLogger().info("ViaMaintenance enabled!");
        if (maintenanceMode) {
            getLogger().warning("Server is currently in maintenance mode!");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("ViaMaintenance disabled!");
    }

    public boolean isMaintenanceMode() {
        return maintenanceMode;
    }

    public void setMaintenanceMode(boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
        getConfig().set("maintenance-mode", maintenanceMode);
        saveConfig();
    }

    public String getKickMessage() {
        return kickMessage;
    }

    public void reloadConfigValues() {
        reloadConfig();
        this.maintenanceMode = getConfig().getBoolean("maintenance-mode", false);
        this.kickMessage = ChatColor.translateAlternateColorCodes('&',
                getConfig().getString("kick-message", "&cServer is under maintenance.\nPlease try again later."));
    }
}
