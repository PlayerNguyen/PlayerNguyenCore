package com.playernguyen.playernguyencore.permision;

import com.playernguyen.playernguyencore.manager.CoreManagerSet;
import org.bukkit.command.CommandSender;

public class PermissionsManager extends CoreManagerSet<String> {

    /**
     * Request the permission of {@link CommandSender}
     *
     * @param sender The sender the request permissions
     * @return Whether having permission inside permission list
     */
    public boolean requestPermissions(CommandSender sender) {
        // Whether the sender is op
        if (sender.isOp())
            return true;
        // Iterate the permission list
        for (String permission : collection()) {
            if (sender.hasPermission(permission))
                return true;
        }
        return false;
    }

}
