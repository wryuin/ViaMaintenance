package ru.viamaintenance.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.viamaintenance.ViaMaintenance;

public class MaintenanceCommand implements CommandExecutor {

    private final ViaMaintenance plugin;

    public MaintenanceCommand(ViaMaintenance plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("viamaintenance.admin")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        boolean newState;
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("on")) {
                newState = true;
            } else if (args[0].equalsIgnoreCase("off")) {
                newState = false;
            } else {
                sender.sendMessage(ChatColor.RED + "Usage: /" + label + " [on|off]");
                return true;
            }
        } else {
            // Toggle current state if no argument provided
            newState = !plugin.isMaintenanceMode();
        }

        plugin.setMaintenanceMode(newState);

        if (newState) {
            sender.sendMessage(ChatColor.GOLD + "Maintenance mode enabled.");
            // Optionally broadcast a message
            // plugin.getServer().broadcastMessage(ChatColor.RED + "Server is now under maintenance!");
        } else {
            sender.sendMessage(ChatColor.GREEN + "Maintenance mode disabled.");
            // Optionally broadcast a message
            // plugin.getServer().broadcastMessage(ChatColor.GREEN + "Server maintenance finished!");
        }

        return true;
    }
} 