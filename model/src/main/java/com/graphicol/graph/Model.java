package com.graphicol.graph;

public class Model implements IModel {
    private final IGraph<INode<String>> graph = new Graph<>();

    public Model() {
        this.graph.loadFromJson("AventuriersDuRailEurope.json");
    }
}
