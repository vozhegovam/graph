public class UndirectedGraphImpl extends AbstractGraph {

    @Override
    public void addEdge(Edge edge) {
        if (!graphDate.containsKey(edge.getVertexA()) || !graphDate.containsKey(edge.getVertexB())) {
            throw new RuntimeException("Can't add edge without vertex");
        }
        graphDate.get(edge.getVertexA()).add(edge.getVertexB());
    }

}
