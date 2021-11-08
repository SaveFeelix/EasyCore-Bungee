package de.feelix.easycore.utils;

import de.feelix.easycore.EasyPlugin;
import de.feelix.easycore.commands.abstracts.CommandExecutor;
import de.feelix.easycore.exceptions.RegisterCommandException;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Class to register Commands and Listeners
 */
public class Register {

    /**
     * Reference to the Plugin
     */
    private final Plugin plugin;

    /**
     * Reference to the PluginManager
     */
    private final PluginManager manager = ProxyServer.getInstance().getPluginManager();

    /**
     * Default Constructor
     * @param plugin the Plugin
     */
    public Register(EasyPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Default Constructor
     * @param plugin the Plugin
     */
    public Register(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Method to register a Command
     * @param executor the CommandClass
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     */
    public void registerCommand(@NotNull Command executor) throws RegisterCommandException {
        try {
            manager.registerCommand(plugin, executor);
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin, executor);
        }
    }

    /**
     * Method to register a Command
     * @param executor the CommandClass
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     */
    public void registerCommand(@NotNull CommandExecutor executor) throws RegisterCommandException {
        try {
            manager.registerCommand(plugin, executor);
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin, executor);
        }
    }

    /**
     * Method to register one or more Commands
     * @param executors the CommandClasses
     * @throws RegisterCommandException if one of the Commands isn't registered in the plugin.yml
     */
    public void registerCommand(@NotNull Command @NotNull ... executors) throws RegisterCommandException {
        for (Command command : executors) {
            registerCommand(command);
        }
    }

    /**
     * Method to register one or more Commands
     * @param executors the CommandClasses
     * @throws RegisterCommandException if one of the Commands isn't registered in the plugin.yml
     */
    public void registerCommand(@NotNull CommandExecutor @NotNull ... executors) throws RegisterCommandException {
        for (CommandExecutor command : executors) {
            registerCommand(command);
        }
    }

    /**
     * Method to register a Listener
     * @param listener the ListenerClass
     */
    public void registerListener(@NotNull Listener listener) {
        manager.registerListener(plugin, listener);
    }

    /**
     * Method to register one or more Commands
     * @param listeners the ListenerClasses
     */
    public void registerListener(@NotNull Listener... listeners) {
        Arrays.asList(listeners).forEach(this::registerListener);
    }

}
