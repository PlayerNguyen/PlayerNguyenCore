package com.playernguyen.playernguyencore.sql;

import com.playernguyen.playernguyencore.utils.CorePreconditions;
import com.playernguyen.playernguyencore.utils.CoreUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CoreEstablishMySQL implements ICoreEstablish {

    private static final String CLASS_DRIVER = "com.mysql.jdbc.Driver";

    private final String host;
    private final String username;
    private final String password;
    private final String port;
    private final String database;
    private final String params;

    public CoreEstablishMySQL(String host,
                              String username,
                              String password,
                              String port,
                              String database,
                              String params) throws ClassNotFoundException {
        // Preconditions checking
        CorePreconditions.notNull(host);
        CorePreconditions.notNull(username);
        CorePreconditions.notNull(password);
        CorePreconditions.notNull(database);
        // Port checking
        CorePreconditions.argument(CoreUtils.isIntFromString(port));
        int portValue = Integer.parseInt(port);
        CorePreconditions.argument(portValue < 0 || portValue > 65535,
                "Port out of range: 0 ~ 65535");
        // End checking protocol
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
        this.database = database;
        this.params = params;
        // Get class with reflection
        Class.forName(CLASS_DRIVER);
    }

    public CoreEstablishMySQL(String host,
                              String username,
                              String password,
                              String port,
                              String database) throws ClassNotFoundException {
        this(host, username, password, port, database, "");
    }

    public CoreEstablishMySQL(String host,
                              String username,
                              String password,
                              String database) throws ClassNotFoundException {
        this(host, username, password, "3306", database, "");
    }

    @Override
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(
                String.format("jdbc:mysql://%s:%s/%s?%s",
                        this.host,
                        this.port,
                        this.database,
                        this.params),
                this.username, this.password
        );
    }

    @Override
    public boolean testConnect(boolean stackTrace) {
        // Create dummy connection
        try (Connection connection = this.openConnection()) {
            connection.close(); // <--- Then close the dummy connection
            return true;
        } catch (SQLException e) {
            if (stackTrace)
                e.printStackTrace();
            return false;
        }
    }
}
