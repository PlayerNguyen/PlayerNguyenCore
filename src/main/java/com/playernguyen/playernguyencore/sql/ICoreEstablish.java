package com.playernguyen.playernguyencore.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represent for SQL Establish class
 */
public interface ICoreEstablish {

    /**
     * Open the connect to SQL
     * @return the SQL connection class ({@link Connection})
     */
    Connection openConnection() throws SQLException;

    /**
     * Test connection of this establish.
     * @return Whether can connect
     * @param stackTrace Print the stack trace
     */
    boolean testConnect(boolean stackTrace);

}
