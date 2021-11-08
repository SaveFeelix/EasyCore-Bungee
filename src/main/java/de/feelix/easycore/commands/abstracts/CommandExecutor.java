package de.feelix.easycore.commands.abstracts;

import de.feelix.easycore.commands.interfaces.ICommandInformation;
import net.md_5.bungee.api.plugin.Command;
import org.jetbrains.annotations.NotNull;

/**
 * Extended Class to create a Command
 */
public abstract class CommandExecutor extends Command {

    /**
     * Default Constructor
     * @param information the CommandInformation
     */
    public CommandExecutor(@NotNull ICommandInformation information) {
        super(information.getCommandName(), (information.getCommandPermission() != null ? information.getCommandPermission() : ""), (information.getCommandAliases() != null ? information.getCommandAliases().toArray(new String[0]) : new String[0]));
    }
}
