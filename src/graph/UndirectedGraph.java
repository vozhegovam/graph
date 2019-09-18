package graph;

import graph.simple_entries.Edge;

public class UndirectedGraph<V> extends AbstractGraph<V> {

    @Override
    public Graph<V> addEdge(Edge<V> edge) {
        addEdgeValidation(edge);
        graphData.get(edge.getVertexA()).add(edge);
        graphData.get(edge.getVertexB()).add(edge);
        return this;
    }

}
