package graph;

import graph.simple_entries.Edge;
import path_finder.PathFinder;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph<V> {

    /**
     * adds vertex to the graph
     */
    Graph<V> addVertex(V vertex);

    /**
     * adds edge to the graph
     */
    Graph<V> addEdge(Edge<V> edge);

    /**
     * returns a list of edges between 2 vertices (path doesn't have to be optimal)
     */
    List<Edge<V>> getPath(PathFinder<V> pathFinder, V start, V end);

    Map<V, Set<Edge<V>>> getGraphStructure();
}
