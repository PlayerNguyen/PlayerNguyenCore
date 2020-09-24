package com.playernguyen.playernguyencore.manager;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * A immutable class to store item.
 * This can store any type like {@link java.util.List}
 */
public interface CoreManager<T> extends Iterable<T> {

    /**
     * Collection which contain all items
     * The collection is represent for storage kind (List, Set,...)
     * @return Current collection of manager class
     */
    Collection<T> collection();

    /**
     * Add new item to the collection
     * @param item The item to add into collection
     */
    void add(T item);

    /**
     * Remove existed item out of collection.
     * Using {@link Collection#remove(Object)} to remove item from {@link #collection()}
     * @param item The item to remove out of collection
     */
    void remove(T item);

    /**
     * Get Stream API (Java 8) of current {@link #collection()}
     * @return the {@link Collection#stream()} methods
     */
    Stream<T> stream();

    /**
     * Clear all item out of collection
     */
    default void clear() {
        collection().clear();
    }

}
