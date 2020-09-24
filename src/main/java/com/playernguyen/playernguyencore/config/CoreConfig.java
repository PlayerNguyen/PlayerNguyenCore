package com.playernguyen.playernguyencore.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class CoreConfig<T extends CoreConfigFlag> {

    private final File currentParent;
    private final File file;
    private final FileConfiguration fileConfiguration;

    public CoreConfig(Plugin plugin, String name, CoreConfigFlag[] chunks, String parent) throws IOException {
        // Create data folder when null
        if (!plugin.getDataFolder().exists() && !plugin.getDataFolder().mkdir())
            throw new IllegalStateException("Cannot initiate the data folder of plugin "
                    + plugin.getDescription().getName());
        // Create parent
        this.currentParent = new File(plugin.getDataFolder(), parent);
        if (!currentParent.exists() && !currentParent.mkdir())
            throw new IllegalStateException("Cannot initiate the data folder of plugin "
                    + plugin.getDescription().getName());
        // File load
        this.file = new File(currentParent, name);
        this.fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
        // Load chunks
        for (CoreConfigFlag chunk : chunks) {
            this.fileConfiguration.set(chunk.getPath(), chunk.getDefault());
        }
        // Save loaded
        save();
    }

    protected File getCurrentParent() {
        return currentParent;
    }

    protected File getFile() {
        return file;
    }

    protected FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    protected void save () throws IOException {
        this.fileConfiguration.save(this.file);
    }
}
