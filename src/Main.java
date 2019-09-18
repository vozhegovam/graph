import graph.DirectedGraph;
import graph.Graph;
import graph.simple_entries.Edge;
import path_finder.DfsPathFinder;

import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Graph<Integer> directedGraph = new DirectedGraph<>();
        List<Edge<Integer>> path = directedGraph.addVertex(1)
                .addVertex(2)
                .addVertex(3)
                .addVertex(4)
                .addEdge(new Edge<>(1, 2))
                .addEdge(new Edge<>(3, 2))
                .addEdge(new Edge<>(3, 4))
                .getPath(new DfsPathFinder<>(), 1, 4);

        printAll(path);
    }

    private static void printAll(Collection<Edge<Integer>> vertices){
        System.out.println("");
        for (Edge<Integer> vertex: vertices ) {
            System.out.print(vertex.getVertexA() + " " + vertex.getVertexB() + "||");
        }
    }
}
