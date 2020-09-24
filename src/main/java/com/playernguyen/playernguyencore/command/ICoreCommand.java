package com.playernguyen.playernguyencore.command;

import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * The represent command class to player
 */
public interface ICoreCommand {

    /**
     * @return The current command
     */
    String getCommand();

    /**
     * @return The description of command
     */
    String getDescription();

    /**
     * @return The parameters of command
     */
    String getParameters();

    /**
     * @param sender    The sender execution tab executor
     * @param arguments The argument list
     * @return Tab executor listen to sender
     */
    List<String> onTab(CommandSender sender, List<String> arguments);

    /**
     * On execute the command
     *
     * @param sender    The sender to execute
     * @param arguments The argument list
     * @return the status code to handle
     */
    int onExecute(CommandSender sender, List<String> arguments);

}
