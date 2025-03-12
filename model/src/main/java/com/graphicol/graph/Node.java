package com.graphicol.graph;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Node<E> implements INode<E> {
    private final List<ILink<E>> links = new ArrayList<>();
    private E value;

    public Node(final E value) {
        this.value = value;
    }

    @Override
    public List<ILink<E>> getLinks() {
        return this.links;
    }

    @Override
    public void addLink(@NotNull final ILink<E> link) {
        if (this.links.contains(link)) return;
        this.links.add(link);
    }

    @Override
    public E getValue() {
        return this.value;
    }

    @Override
    public void setValue(final E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
}
