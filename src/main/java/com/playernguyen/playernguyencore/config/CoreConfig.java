package com.playernguyen.playernguyencore.config;

import com.playernguyen.playernguyencore.utils.CorePreconditions;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class CoreConfig<T extends CoreConfigFlag> {

    private final File currentParent;
    private final File file;
    private final FileConfiguration fileConfiguration;

    public CoreConfig(@NotNull Plugin plugin,
                      @NotNull String name,
                      @NotNull CoreConfigFlag[] chunks,
                      @NotNull String parent) throws IOException {
        // Create data folder when null
        CorePreconditions.state(
                !plugin.getDataFolder().exists() && !plugin.getDataFolder().mkdir(),
                "Cannot initiate the data folder of plugin " + plugin.getDescription().getName()
        );
        // Create parent
        this.currentParent = new File(plugin.getDataFolder(), parent);
        CorePreconditions.state(
                !currentParent.exists() && !currentParent.mkdir(),
                "Cannot initiate the data folder of plugin " + plugin.getDescription().getName()
        );
        // File load
        this.file = new File(currentParent, name);
        this.fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
        // Load chunks
        for (CoreConfigFlag chunk : chunks) {
            this.fileConfiguration.set(chunk.getPath(), chunk.getDefault());
        }
        // Save loaded
        this.save();
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

    protected void save() throws IOException {
        this.fileConfiguration.save(this.file);
    }

    public Object getObject(@NotNull T flag) {
        return this.fileConfiguration.get(flag.getPath());
    }

    public String getString(@NotNull T flag) {
        return this.fileConfiguration.getString(flag.getPath());
    }

    public int getInt(@NotNull T flag) {
        return this.fileConfiguration.getInt(flag.getPath());
    }

    public double getDouble(@NotNull T flag) {
        return this.fileConfiguration.getDouble(flag.getPath());
    }
}
