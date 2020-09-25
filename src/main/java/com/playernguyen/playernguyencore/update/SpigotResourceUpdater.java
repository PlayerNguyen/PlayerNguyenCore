package com.playernguyen.playernguyencore.update;

import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Spigot Resource Update class. Connect to the Spigot server and check for new update
 */
public class SpigotResourceUpdater {

    private static final String SPIGOT_RESOURCE_URL = "https://api.spigotmc.org/legacy/update.php?resource=";

    private final Plugin plugin;
    private final int resourceId;

    public SpigotResourceUpdater(Plugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
        // Check for update
    }

    /**
     * @return Plugin object
     */
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * @return The resource id of Spigot
     */
    public int getResourceId() {
        return resourceId;
    }

    private String getSpigotVersion() throws IOException {
        URL url = new URL(SPIGOT_RESOURCE_URL + this.resourceId);
        InputStream stream = url.openStream();
        Scanner scanner = new Scanner(stream);
        String builder = "";
        while (scanner.hasNextLine()) {
            builder = builder.concat(scanner.nextLine().trim());
        }
        return builder;
    }

    public boolean hasNewUpdate() throws IOException {
        // Mismatch algo
        return !this.getSpigotVersion().
                equalsIgnoreCase(plugin.getDescription().getVersion());
    }


}
