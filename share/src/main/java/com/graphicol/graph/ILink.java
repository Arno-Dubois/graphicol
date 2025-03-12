package com.graphicol.graph;

import org.jetbrains.annotations.NotNull;

public interface ILink<E> {
    INode<E> getStart();

    INode<E> getEnd();

    int getWeight();

    void setWeight(final int weight);

    int compareTo(@NotNull ILink<E> other);
}
