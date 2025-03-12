package com.graphicol.graph;

public class Model implements IModel {
    private final IGraph<String> graph = new StringGraph();

    public Model() {
        this.graph.loadFromJson("AventuriersDuRailEurope.json");
        System.out.println(this.graph.getSpanningTreeByPrim().toPrettyText());
    }
}
