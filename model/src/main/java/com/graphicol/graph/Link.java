package com.graphicol.graph;

import org.jetbrains.annotations.NotNull;

public class Link<E> implements ILink<E> {
    private final INode<E> start;
    private final INode<E> end;
    private int weight;

    //Prendre le NotNull de Lombok
    public Link(@NotNull final INode<E> start, @NotNull final INode<E> end, final int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.start.addLink(this);
        this.end.addLink(this);
        // Interdit de throw dans un constructeur
    }

    @Override
    public INode<E> getStart() {
        return this.start;
    }

    @Override
    public INode<E> getEnd() {
        return this.end;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(final int weight) {
        this.weight = weight;
    }
}
