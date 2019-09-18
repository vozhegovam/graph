package graph;

import graph.simple_entries.Edge;

public class DirectedGraph<V> extends AbstractGraph<V> {

    @Override
    public Graph<V> addEdge(Edge<V> edge) {

        addEdgeValidation(edge);

        graphData.get(edge.getVertexA()).add(edge);
        return this;
    }
}
