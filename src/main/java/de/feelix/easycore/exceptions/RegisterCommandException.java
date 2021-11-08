package de.feelix.easycore.exceptions;

import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Class to show if the Command isn't registered successfully
 */
public class RegisterCommandException extends Exception {

    /**
     * Reference to the Plugin
     */
    private final Plugin plugin;

    /**
     * Reference to the Command
     */
    private final Command command;

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @param command the CommandClass
     */
    public RegisterCommandException(@NotNull Plugin plugin, @NotNull Command command) {
        super("Failed to register Command " + command.getName() + " on Plugin " + plugin.getDescription().getName());
        this.plugin = plugin;
        this.command = command;
    }

    /**
     * Getter for the Plugin
     * @return the Plugin
     */
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * Getter for the Command
     * @return the Command
     */
    public Command getCommand() {
        return command;
    }
}
