import java.util.ArrayList;
import java.util.List;

class WeightedGraph<T> {
    private List<T> vertices;
    private int[][] matrix;

    public WeightedGraph(int size) {
        vertices = new ArrayList<>();
        matrix = new int[size][size];

        // -1 means no route exists
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -1;
            }
        }
    }

    // Add a delivery hub
    public void addVertex(T vertex) {
        if (vertices.size() < matrix.length) {
            vertices.add(vertex);
        }
    }

    // Add a weighted route
    public void addEdge(T start, T end, int weight) {
        int startIndex = vertices.indexOf(start);
        int endIndex = vertices.indexOf(end);

        if (startIndex != -1 && endIndex != -1) {
            matrix[startIndex][endIndex] = weight;
            matrix[endIndex][startIndex] = weight;
        }
    }

    // Display the network
    public void displayGraph() {
        System.out.println("Delivery Network:");

        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + ": ");

            for (int j = 0; j < vertices.size(); j++) {
                if (matrix[i][j] != -1) {
                    System.out.print(vertices.get(j) +
                        " (Cost: " + matrix[i][j] + ") ");
                }
            }

            System.out.println();
        }

        public boolean bfs(T start, T end) {
    int startIndex = vertices.indexOf(start);
    int endIndex = vertices.indexOf(end);

    if (startIndex == -1 || endIndex == -1) {
        return false;
    }

    boolean[] visited = new boolean[vertices.size()];
    java.util.Queue<Integer> queue = new java.util.LinkedList<>();

    queue.add(startIndex);
    visited[startIndex] = true;

    while (!queue.isEmpty()) {
        int current = queue.remove();

        if (current == endIndex) {
            return true;
        }

        for (int i = 0; i < vertices.size(); i++) {
            if (matrix[current][i] != -1 && !visited[i]) {
                visited[i] = true;
                queue.add(i);
            }
        }
    }

    return false;


    }
    }



public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(6);

        // Add six cities
        graph.addVertex("New York");
        graph.addVertex("Chicago");
        graph.addVertex("Denver");
        graph.addVertex("Los Angeles");
        graph.addVertex("Seattle");
        graph.addVertex("Miami");

        // Add weighted routes
        graph.addEdge("New York", "Chicago", 790);
        graph.addEdge("New York", "Miami", 1280);
graph.addEdge("Chicago", "Denver", 920);

        graph.addEdge("Denver", "Los Angeles", 830);

        graph.addEdge("Denver", "Seattle", 1300);

        graph.addEdge("Los Angeles", "Seattle", 1135);

        graph.displayGraph();

    }

}
