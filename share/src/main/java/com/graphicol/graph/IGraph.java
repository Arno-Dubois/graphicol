package com.graphicol.graph;

import com.google.gson.Gson;
import fr.arnodubois.treenode.NaryTreeNode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IGraph<E> {

    List<INode<E>> getNodes();

    void addNodes(@NotNull final INode<E> node);

    void loadFromJson(final String jsonFileName);

    Gson toJson();

    NaryTreeNode<INode<E>> getSpanningTreeByPrim();
}
