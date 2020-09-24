package com.playernguyen.playernguyencore.utils;

/**
 * Preconditions util class to check the condition state of variables, functions,...<br>
 * This class likely Guava Precondition <i>(I don't know which version from Spigot, Bukkit support this)</i>
 */
public class CorePreconditions {

    /**
     * Check not null to template class.<br>
     *
     * @param which   The object to check not null
     * @param message The message of {@link NullPointerException} catch
     * @param <T>     Template object to check not null
     */
    public static <T> void notNull(T which, String message) {
        if (which == null) {
            throw new NullPointerException(message);
        }
    }

    /**
     * Check not null to template class
     *
     * @param which The object to check not null
     * @param <T>   Template object to check not null
     */
    public static <T> void notNull(T which) {
        if (which == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Check argument express
     *
     * @param express The boolean express of that arguments
     * @throws IllegalArgumentException When the express is wrong
     */
    public static void argument(boolean express) {
        if (!express) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Check argument express with message.
     *
     * @param express The boolean express of that arguments
     * @param message The message will send to {@link IllegalArgumentException}
     * @throws IllegalArgumentException When the express is wrong
     */
    public static void argument(boolean express, String message) {
        if (!express) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Check state is legit with boolean express.
     *
     * @param express The boolean express
     * @param message The message will send {@link IllegalStateException}
     * @throws IllegalStateException When the express is wrong
     */
    public static void state(boolean express, String message) {
        if (!express) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * Check state is legit with boolean express.
     *
     * @param express The boolean express
     * @throws IllegalStateException When the express is wrong
     */
    public static void state(boolean express) {
        CorePreconditions.state(express, "");
    }


}
