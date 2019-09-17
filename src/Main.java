import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Edge e1= new Edge(v1, v2);
        Edge e2= new Edge(v2, v3);
        Edge e3= new Edge(v3, v4);
        Edge e4= new Edge(v4, v5);

        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addVertex(v1);
        directedGraph.addVertex(v2);
        directedGraph.addVertex(v3);
        directedGraph.addVertex(v4);
        directedGraph.addVertex(v5);
        directedGraph.addEdge(e1);
        directedGraph.addEdge(e2);
        directedGraph.addEdge(e3);
        directedGraph.addEdge(e4);

        List<Vertex> vertexList = directedGraph.getPath(v1, v5);
        printAll(vertexList);
    }

    private static void printAll(Collection<Vertex> vertices){
        System.out.println("");
        for (Vertex vertex: vertices ) {
            System.out.print(vertex.getVertexName() + " ");
        }
    }
}
