import java.util.*;

public abstract class AbstractGraph {

    Map<Vertex, Collection<Vertex>> graphDate = new HashMap<>();

    //addVertex - adds vertex to the graph
    public void addVertex(Vertex vertex) {
        if (!graphDate.containsKey(vertex)) {
            graphDate.put(vertex, new ArrayList<>());
        }
    }

    //addEdge - adds edge to the graph
    public abstract void addEdge(Edge edge);

    //getPath - returns a list of edges between 2 vertices (path doesn’t have to be optimal)
    public List<Vertex> getPath(Vertex fromVertex, Vertex toVertex) {

        if (fromVertex == null) {
            throw new RuntimeException("Input can't be NULL");
        }

        if (fromVertex.equals(toVertex)) {
            return Collections.singletonList(fromVertex);
        }

        Collection<Vertex> vertices = graphDate.get(fromVertex);
        if (vertices.isEmpty()) {
            throw new RuntimeException("Can't find the path");
        }

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(fromVertex);

        List<Vertex> resultList = getPath(fromVertex, toVertex, vertexList);
        if (resultList == null || resultList.isEmpty()) {
            throw new RuntimeException("Path between the vertices does not exist");
        }
        return resultList;
    }

    private List<Vertex> getPath(Vertex currentVertex, Vertex toVertex, List<Vertex> previousPath) {
        List<Vertex> resultList;
        Collection<Vertex> nextVertices = graphDate.get(currentVertex);

        if (nextVertices.isEmpty()) {
            return null;
        } else if (nextVertices.contains(toVertex)) {
            previousPath.add(toVertex);
            return previousPath;
        }
        for (Vertex vertex : nextVertices) {
            if(previousPath.contains(vertex)){
                continue;
            }
            List<Vertex> verticesList = new ArrayList<>(previousPath);
            verticesList.add(vertex);
            resultList = getPath(vertex, toVertex, verticesList);
            if (resultList != null) {
                return resultList;
            }
        }
        return null;
    }

}
