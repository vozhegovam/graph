package path_finder;

import graph.Graph;
import graph.simple_entries.Edge;

import java.util.List;

public interface PathFinder<V> {
    List<Edge<V>> getPath(Graph<V> graph, V fromVertex, V toVertex);
}
