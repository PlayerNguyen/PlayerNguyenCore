package com.playernguyen.playernguyencore.command;

public abstract class CoreCommandSubCommand implements ICoreCommand {

    private final String command;
    private final String parameters;
    private final String description;
    private final PermissionsManager permissions;
    private final ICoreCommand parentCommand;

    public CoreCommandSubCommand(String command,
                                 String parameters,
                                 String description,
                                 PermissionsManager permissions,
                                 ICoreCommand parentCommand) {
        this.command = command;
        this.parameters = parameters;
        this.description = description;
        this.permissions = permissions;
        this.parentCommand = parentCommand;
    }

    public CoreCommandSubCommand(String command,
                                 String parameters,
                                 String description,
                                 ICoreCommand parentCommand) {
        this(command, parameters, description, new PermissionsManager(), parentCommand);
    }

    @Override
    public String getParameters() {
        return parameters;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getCommand() {
        return command;
    }

    public ICoreCommand getParentCommand() {
        return parentCommand;
    }

    public PermissionsManager getPermissions() {
        return permissions;
    }
}
