import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Double> dist;
    private Map<Vertex<V>, Vertex<V>> edgeTo;

    @Override
    public boolean hasPathTo(Vertex<V> vertex) {
        return dist.containsKey(vertex);
    }

    @Override
    public Iterable<Vertex<V>> pathTo(Vertex<V> vertex) {
        if (!hasPathTo(vertex)) {
            return Collections.emptyList();
        }
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> v = vertex; v != null; v = edgeTo.get(v)) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }

    public void search(WeightedGraph<V> graph, Vertex<V> source) {
        dist = new HashMap<>();
        edgeTo = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>((v1, v2) -> Double.compare(dist.get(v1), dist.get(v2)));
        dist.put(source, 0.0);
        queue.offer(source);
        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                double oldDist = dist.getOrDefault(w, Double.POSITIVE_INFINITY);
                double newDist = dist.get(v) + graph.getGraph().get(v).get(w);
                if (newDist < oldDist) {
                    dist.put(w, newDist);
                    edgeTo.put(w, v);
                    queue.offer(w);
                }
            }
        }
    }
}