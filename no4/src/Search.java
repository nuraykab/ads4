public interface Search<V> {
    boolean hasPathTo(Vertex<V> vertex);

    Iterable<Vertex<V>> pathTo(Vertex<V> vertex);
}