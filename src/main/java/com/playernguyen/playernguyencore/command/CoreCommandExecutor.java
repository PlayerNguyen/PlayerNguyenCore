package com.playernguyen.playernguyencore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.List;

public abstract class CoreCommandExecutor implements TabExecutor, ICoreCommand {

    private final String command;
    private final String parameters;
    private final String description;

    public CoreCommandExecutor(String command, String parameters, String description) {
        this.command = command;
        this.parameters = parameters;
        this.description = description;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getParameters() {
        return parameters;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return this.onTab(sender, Arrays.asList(args));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Status code catch
        int statusCode = this.onExecute(sender, Arrays.asList(args));
        this.catchStatusCode(statusCode);
        // Return true
        return true;
    }

    public abstract void catchStatusCode(int code);
}
