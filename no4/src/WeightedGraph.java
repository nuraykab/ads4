import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, Map<Vertex<V>, Double>> graph = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        graph.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);
        addVertex(source);
        addVertex(destination);
        graph.get(source).put(destination, weight);
    }

    public Map<Vertex<V>, Map<Vertex<V>, Double>> getGraph() {
        return graph;
    }
}