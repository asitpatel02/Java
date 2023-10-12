// This program implements an algorithm to find the number of strongly connected components in a directed graph.

import java.io.*;
import java.util.*;

public class Components {
    public static void main(String[] args) throws IOException {
// Check if the correct number of command line arguments is provided
        if (args.length != 2) {
            System.err.println("Usage: java Components <input file> <output file>");
            System.exit(1);
        }

        // Open input and output files
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        PrintWriter out = new PrintWriter(new FileWriter(args[1]));

        // Read the number of test cases
        int N = Integer.parseInt(in.readLine());

        // Process each test case
        for (int i = 0; i < N; i++) {
            // Read the graph for the current test case
            String[] line = in.readLine().split(" ");
            int M = Integer.parseInt(line[0]);
            List<Integer>[] adj = new List[M];
            for (int j = 0; j < M; j++) {
                adj[j] = new ArrayList<>();
                String[] edges = in.readLine().split(" ");
                for (int k = 1; k < edges.length; k++) {
                    adj[j].add(Integer.parseInt(edges[k]) - 1);
                }
            }

            // Compute the number of strongly connected components for the current test case
            int sccCount = stronglyConnectedComponents(adj);

            // Write the result to the output file
            out.println(sccCount);
        }

        // Close input and output files
        in.close();
        out.close();
    }

    // Function to compute the number of strongly connected components in a directed graph
    public static int stronglyConnectedComponents(List<Integer>[] adj) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Run depth-first search on the original graph and add vertices to the stack in order of finish time
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }

        // Compute the transpose of the graph
        List<Integer>[] adjT = transpose(adj);

        // Run depth-first search on the transpose graph in order of decreasing finish time
        Arrays.fill(visited, false);
        int sccCount = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                dfs(adjT, u, visited);
                sccCount++;
            }
        }

        // Return the number of strongly connected components
        return sccCount;
    }

    // This method performs a depth-first search on the graph starting from vertex u
    // and pushes visited vertices onto a stack in post-order
    public static void dfs(List<Integer>[] adj, int u, boolean[] visited, Stack<Integer> stack) {
        // Mark the current vertex as visited
        visited[u] = true;
        // Iterate over each neighbor of the current vertex
        for (int v : adj[u]) {
            // If the neighbor has not been visited yet, recursively call the dfs function on it
            if (!visited[v]) {
                dfs(adj, v, visited, stack);
            }
        }
        // Push the current vertex onto the stack after all its neighbors have been visited
        stack.push(u);
    }

    // This method performs a depth-first search on the graph starting from vertex u
    public static void dfs(List<Integer>[] adj, int u, boolean[] visited) {
        // Mark the current vertex as visited
        visited[u] = true;
        // Iterate over each neighbor of the current vertex
        for (int v : adj[u]) {
            // If the neighbor has not been visited yet, recursively call the dfs function on it
            if (!visited[v]) {
                dfs(adj, v, visited);
            }
        }
    }

    // This method takes an adjacency list and returns its transpose
    public static List<Integer>[] transpose(List<Integer>[] adj) {
        // Get the number of vertices in the graph
        int n = adj.length;
        // Create a new array to hold the transposed adjacency list
        List<Integer>[] adjT = new List[n];
        // Initialize each element of the new array to an empty list
        for (int i = 0; i < n; i++) {
            adjT[i] = new ArrayList<>();
        }
        // Iterate over each vertex in the input list
        for (int u = 0; u < n; u++) {
            // Iterate over each neighbor of the current vertex
            for (int v : adj[u]) {
                // Add the current vertex to the adjacency list for the neighbor
                adjT[v].add(u);
            }
        }
        // Return the transposed adjacency list
        return adjT;
    }
}