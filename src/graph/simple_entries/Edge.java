package graph.simple_entries;

public class Edge<V> {

    private V vertexA;
    private V vertexB;
    private int weight;

    public Edge(V vertexA, V vertexB, int weight) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
    }

    public Edge(V vertexA, V vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public V getVertexA() {
        return vertexA;
    }

    public V getVertexB() {
        return vertexB;
    }

    public int getWeight() {
        return weight;
    }

    public V getOppositeVertex(V vertex){
        return vertex.equals(vertexA) ? vertexB : vertexA;
    }

}
