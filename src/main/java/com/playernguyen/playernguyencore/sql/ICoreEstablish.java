package com.playernguyen.playernguyencore.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represent for SQL Establish class
 */
public interface ICoreEstablish {

    /**
     * Open the connect to SQL
     *
     * @return the SQL connection class ({@link Connection})
     */
    Connection openConnection() throws SQLException;

    /**
     * Test connection of this establish by making a dummy connect.
     *
     * @param stackTrace Print the stack trace
     * @return Whether can connect
     */
    default boolean testConnect(boolean stackTrace) {
        try (Connection connection = this.openConnection()) {
            // Make a dummy connection
            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


}
