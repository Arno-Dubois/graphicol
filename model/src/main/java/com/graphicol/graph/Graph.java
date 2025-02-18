package com.graphicol.graph;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Graph<E> implements IGraph<E> {
    private final List<INode<E>> nodes = new ArrayList<>();

    @Override
    public List<INode<E>> getNodes() {
        return this.nodes;
    }

    @Override
    public void addNodes(final @NotNull INode<E> node) {
        if (this.nodes.contains(node)) return;
        this.nodes.add(node);
    }

    @Override
    public void loadFromJson(final String jsonFileName) {
        final URL url = this.getClass().getClassLoader().getResource(jsonFileName);
        if (url == null) throw new FileSystemNotFoundException("Resource not found : " + jsonFileName);

        final StringBuilder jsonString = new StringBuilder();
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Gson toJson() {
        return null;
    }
}
