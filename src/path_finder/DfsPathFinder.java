package path_finder;

import graph.Graph;
import graph.simple_entries.Edge;

import java.util.*;

public class DfsPathFinder<V> implements PathFinder<V> {

    private Map<V, Set<Edge<V>>> graphStructure;

    @Override
    public List<Edge<V>> getPath(Graph<V> graph, V fromVertex, V toVertex) {

        validateGetPathInput(graph, fromVertex, toVertex);
        this.graphStructure = graph.getGraphStructure();
//        if (fromVertex.equals(toVertex)) {
//            return loopCheck(graphStructure, fromVertex);
//        }
        return getPath(fromVertex, toVertex, new ArrayList<>());
    }

    private void validateGetPathInput(Graph<V> graph, V fromVertex, V toVertex){
        if(graph == null){
            throw new RuntimeException("Graph can't be empty");
        } else if(fromVertex == null || toVertex == null){
            throw new RuntimeException("Please specify input Vertices");
        }
    }
//
//    private List<Edge<V>> loopCheck(Map<V, Set<Edge<V>>> graphStructure, V fromVertex) {
//
//        Optional<Edge<V>> resultEdge = graphStructure.get(fromVertex).stream()
//                .filter(edge -> edge.getOppositeVertex(fromVertex).equals(fromVertex))
//                .findFirst();
//
//        return resultEdge.map(Collections::singletonList).orElse(Collections.emptyList());
//    }

    private List<Edge<V>> getPath(V currentVertex, V toVertex, List<Edge<V>> previousPath) {
        List<Edge<V>> resultList = new ArrayList<>();
        Collection<Edge<V>> nextEdges = graphStructure.get(currentVertex);

        if (nextEdges.isEmpty()) {
            return Collections.emptyList();
        }

        for (Edge<V> edge : nextEdges) {
            if (previousPath.contains(edge)) {
                continue;
            } else if(edge.getOppositeVertex(currentVertex).equals(toVertex)){
                previousPath.add(edge);
                return previousPath;
            }
            List<Edge<V>> edgesList = new ArrayList<>(previousPath);
            edgesList.add(edge);
            resultList = getPath(edge.getOppositeVertex(currentVertex), toVertex, edgesList);
        }
        return resultList;
    }
}
