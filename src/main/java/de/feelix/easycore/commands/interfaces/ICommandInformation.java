package de.feelix.easycore.commands.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Interface to get the Information for the Commands
 */
public interface ICommandInformation {

    /**
     * Getter for the CommandName
     * @return the commandName
     */
    @NotNull String getCommandName();

    /**
     * Getter for the CommandPermission
     * @return the Permission
     */
    @Nullable String getCommandPermission();

    /**
     * Getter for the CommandAliases
     * @return the Aliases
     */
    @Nullable List<String> getCommandAliases();
}
