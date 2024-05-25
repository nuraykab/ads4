import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vertex<String> v0 = new Vertex<>("v0");
        Vertex<String> v1 = new Vertex<>("v1");
        Vertex<String> v2 = new Vertex<>("v2");
        Vertex<String> v3 = new Vertex<>("v3");
        Vertex<String> v4 = new Vertex<>("v4");
        Vertex<String> v5 = new Vertex<>("v5");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(v0, v1, 2);
        graph.addEdge(v0, v2, 1);
        graph.addEdge(v1, v3, 2);
        graph.addEdge(v1, v4, 3);
        graph.addEdge(v2, v5, 4);
        graph.addEdge(v3, v5, 5);
        graph.addEdge(v4, v5, 6);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        bfs.search(graph, v0);
        System.out.println("BFS Path to v5: " + bfs.pathTo(v5));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        dijkstra.search(graph, v0);
        System.out.println("Dijkstra Path to v5: " + dijkstra.pathTo(v5));
    }
}