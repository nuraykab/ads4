import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Boolean> marked;
    private Map<Vertex<V>, Vertex<V>> edgeTo;

    @Override
    public boolean hasPathTo(Vertex<V> vertex) {
        return marked.containsKey(vertex);
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
        marked = new HashMap<>();
        edgeTo = new HashMap<>();
        Queue<Vertex<V>> queue = new LinkedBlockingQueue<>();
        marked.put(source, true);
        queue.offer(source);
        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                if (!marked.containsKey(w)) {
                    edgeTo.put(w, v);
                    marked.put(w, true);
                    queue.offer(w);
                }
            }
        }
    }
}