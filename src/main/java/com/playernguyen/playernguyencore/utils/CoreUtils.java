package com.playernguyen.playernguyencore.utils;

/**
 * The utility class for Bukkit/SpigotMC/Paper plugins.
 */
public class CoreUtils {

    /**
     * Check whether the {@link String} value can convert to {@link Integer}
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

    /**
     * Check whether the {@link String} can convert to {@link Float}
     * @param string String value to check
     * @return true if the string value is an float <br>
     *     or false
     */
    public static boolean isFloatFromString(String string) {
        try {
            Float.parseFloat(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
