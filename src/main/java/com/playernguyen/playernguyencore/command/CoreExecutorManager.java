package com.playernguyen.playernguyencore.command;

import com.playernguyen.playernguyencore.manager.CoreManagerSet;
import com.playernguyen.playernguyencore.utils.CorePreconditions;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

public class CoreExecutorManager extends CoreManagerSet<CoreCommandExecutor> {

    @Override
    public void add(CoreCommandExecutor item) {
        super.add(item);
        // Register command
        PluginCommand command = Bukkit.getPluginCommand(item.getCommand());
        // Check null
        CorePreconditions.notNull(command,
                "Command not register, please config in plugin.yml -> commands");
        // Set executor to item
        command.setExecutor(item);
    }


}
