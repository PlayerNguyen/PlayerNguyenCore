package com.playernguyen.playernguyencore.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CoreManagerList<T> implements CoreManager<T> {

    private final List<T> collection;

    public CoreManagerList(List<T> collection) {
        this.collection = collection;
    }

    public CoreManagerList() {
        this.collection = new ArrayList<>();
    }

    @Override
    public Collection<T> collection() {
        return this.collection;
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

    @Override
    public Iterator<T> iterator() {
        return collection.iterator();
    }
}
