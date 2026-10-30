//package week4;

import java.util.*;

public class W4D1_GraphDFS {
    private Map<String, List<String>> adjacencyList = new HashMap<>();

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1); // For undirected graph
    }

    public void dfs(String startVertex) {
        Set<String> visited = new HashSet<>();
        System.out.println("DFS Traversal starting from " + startVertex + ":");
        dfsRecursive(startVertex, visited);
        System.out.println("\nEnd");
    }

    private void dfsRecursive(String current, Set<String> visited) {
        // TODO: Implement the dfs recursive logic.
    }

    // Helper method to display graph structure
    public void printGraph() {
        System.out.println("Graph structure:");
        for (String vertex : adjacencyList.keySet()) {
            List<String> neighbors = adjacencyList.get(vertex);
            if (neighbors.isEmpty()) {
                System.out.println(vertex + " has no neighbors");
            } else {
                System.out.println(vertex + "'s neighbors are: " + String.join(", ", neighbors));
            }
        }
        System.out.println();
    }

    // Main method to test the DFS
    public static void main(String[] args) {
        W4D1_GraphDFS graph = new W4D1_GraphDFS();
        String[] authors = {"Orwell", "Huxley", "Tolkien", "Lewis", "Asimov", "Clarke"};
        
        // Add all vertices first
        for (String author : authors) {
            graph.addVertex(author);
        }

        // Add edges to create connections
        graph.addEdge("Orwell", "Huxley");
        graph.addEdge("Tolkien", "Lewis");
        graph.addEdge("Asimov", "Clarke");
        graph.addEdge("Huxley", "Asimov"); // Connecting the groups

        // Display the graph structure
        graph.printGraph();

        // Perform DFS from different starting points
        graph.dfs("Orwell");
        System.out.println();
        
        // Test DFS from a different starting point
        graph.dfs("Tolkien");
        System.out.println();
        
        // Test DFS from an isolated component (if any)
        // Let's add an isolated vertex
        graph.addVertex("Isolated");
        graph.dfs("Isolated");
    }
}