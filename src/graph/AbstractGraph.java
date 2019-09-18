package graph;

import graph.simple_entries.Edge;
import path_finder.PathFinder;

import java.util.*;

public abstract class AbstractGraph<V> implements Graph<V> {

    Map<V, Set<Edge<V>>> graphData = new HashMap<>();

    public Graph<V> addVertex(V vertex) {
        this.graphData.putIfAbsent(vertex, new HashSet<>());
        return this;
    }

    void addEdgeValidation(Edge<V> edge){
        if (!graphData.containsKey(edge.getVertexA()) || !graphData.containsKey(edge.getVertexB())) {
            throw new RuntimeException("Can't add edge to graph without vertex");
        }
    }

    public abstract Graph<V> addEdge(Edge<V> edge);

    public List<Edge<V>> getPath(PathFinder<V> pathFinder, V fromVertex, V toVertex) {

        if (pathFinder == null){
            throw new RuntimeException("PathFinder can not be NULL");
        } else if (fromVertex == null || toVertex == null) {
            throw new RuntimeException("Input can't be NULL");
        }
        List<Edge<V>> resultList = pathFinder.getPath(this, fromVertex, toVertex);
        if (resultList.isEmpty()) {
            throw new RuntimeException("Path between the vertices does not exist");
        }
        return resultList;
    }

    public Map<V, Set<Edge<V>>> getGraphStructure(){
        return graphData;
    }
}
