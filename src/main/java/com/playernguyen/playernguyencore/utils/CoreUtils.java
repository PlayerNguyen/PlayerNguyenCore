package com.playernguyen.playernguyencore.utils;

/**
 * The utility class for Bukkit/SpigotMC/Paper plugins.
 */
public class CoreUtils {

    /**
     * Check whether the {@link String} value can coverted to {@link Integer}
     * @param string String value to check
     * @return true if the string value is an integer <br>
     *     or false
     */
    public static boolean isIntFromString(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
