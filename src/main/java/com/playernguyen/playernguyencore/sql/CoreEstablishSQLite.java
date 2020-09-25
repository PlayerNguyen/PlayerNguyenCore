package com.playernguyen.playernguyencore.sql;

import com.playernguyen.playernguyencore.utils.CorePreconditions;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CoreEstablishSQLite implements ICoreEstablish {

    private static final String CLASS_DRIVER = "org.sqlite";

    private final Plugin plugin;
    private final File file;

    public CoreEstablishSQLite(@NotNull Plugin plugin,
                               @NotNull File file) throws ClassNotFoundException {
        this.plugin = plugin;
        this.file = file;
        // File checker
        CorePreconditions.state(!this.file.exists() && !this.file.mkdir(),
                "Cannot initiate SQLite database file: " + file.getPath());

        // Using class with reflection
        Class.forName(CLASS_DRIVER);
    }

    public CoreEstablishSQLite(@NotNull Plugin plugin,
                               @NotNull String name) throws ClassNotFoundException {
        this.plugin = plugin;
        this.file = new File(this.plugin.getDataFolder(), name);
        // File checker
        CorePreconditions.state(!this.file.exists() && !this.file.mkdir(),
                "Cannot initiate SQLite database file: " + file.getPath());

        // Using class with reflection
        Class.forName(CLASS_DRIVER);
    }

    @Override
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + this.file.getPath());
    }

}
