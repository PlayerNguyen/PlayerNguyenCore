package com.playernguyen.playernguyencore.manager;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class CoreManagerSet<T> implements CoreManager<T> {

    private final Set<T> collection;

    public CoreManagerSet(Set<T> collection) {
        this.collection = collection;
    }

    public CoreManagerSet() {
        this.collection = new HashSet<>();
    }

    @Override
    public Collection<T> collection() {
        return collection;
    }

    @Override
    public void add(T item) {
        collection.add(item);
    }

    @Override
    public void remove(T item) {
        collection.remove(item);
    }

    @Override
    public Stream<T> stream() {
        return collection.stream();
    }

    @Override @NotNull
    public Iterator<T> iterator() {
        return collection.iterator();
    }
}
