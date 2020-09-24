package com.playernguyen.playernguyencore;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerNguyenCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("PlayerNguyenCore initial");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
