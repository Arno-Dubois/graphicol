package com.graphicol.graph;

import fr.arnodubois.treenode.NaryTreeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph<E> implements IGraph<E> {
    private final List<INode<E>> nodes = new ArrayList<>();

    @Override
    public NaryTreeNode<INode<E>> getSpanningTreeByPrim() {
        if (this.getNodes().isEmpty()) return null;
        NaryTreeNode<INode<E>> spanningTree = new NaryTreeNode<>(this.get(0));

        while (spanningTree.getSize() != this.getNodes().size()) {
            ILink<E> minLink = Graph.getMinLinkFromTreeNode(spanningTree);

            if (minLink != null) {
                spanningTree.getNodeFromElement(minLink.getStart()).addChild(minLink.getEnd());
            }
        }
        return spanningTree;
    }

    private static <E> @Nullable ILink<E> getMinLinkFromTreeNode(final NaryTreeNode<INode<E>> treeNode) {
        ILink<E> minLink = null;
        for (INode<E> node : treeNode.toByWidthList()) {
            for (ILink<E> link : node.getLinks()) {
                if (!treeNode.contains(link.getEnd())) {
                    minLink = (minLink == null ? link : (minLink.compareTo(link) > 0 ? link : minLink));
                }
            }
        }
        return minLink;
    }

    @Override
    public List<INode<E>> getNodes() {
        return this.nodes;
    }

    @Override
    public void addNodes(final @NotNull INode<E> node) {
        if (this.nodes.contains(node)) return;
        this.nodes.add(node);
    }

    public final INode<E> get(final int index) {
        return this.getNodes().get(index);
    }

}
