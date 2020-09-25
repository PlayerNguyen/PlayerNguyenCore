package com.playernguyen.playernguyencore.listener;

import com.playernguyen.playernguyencore.manager.CoreManagerSet;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

/**
 * Manager class for Bukkit {@link Listener}, just new instance then add, remove like another manager.
 * Not to register anything.
 */
public class CoreListenerManager extends CoreManagerSet<Listener> {

    private final Plugin plugin;
    private final boolean observation;

    public CoreListenerManager (Plugin plugin, boolean observation) {
        this.plugin = plugin;
        this.observation = observation;
    }

    @Override
    public void add(Listener item) {
        super.add(item);
        // Register the listener
        Bukkit.getPluginManager().registerEvents(item, plugin);
        if (observation) {
            plugin.getLogger().info("Register the listener");
        }
    }

    @Override
    public void remove(Listener item) {
        // Unregister first
        HandlerList.unregisterAll(item);
        // Clear out
        super.remove(item);
    }

    @Override
    public void clear() {
        // Unregister listener
        HandlerList.unregisterAll(this.plugin);
        // Clear the garbage
        super.clear();
    }
}
