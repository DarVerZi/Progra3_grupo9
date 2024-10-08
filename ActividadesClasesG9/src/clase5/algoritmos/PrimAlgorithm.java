package clase5.algoritmos;

import java.util.*;

public class PrimAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int numVertices, List<List<int[]>> graph) {
        int[] key = new int[numVertices];  // Array to store the minimum weight edge to include in MST
        int[] parent = new int[numVertices];  // Array to store the resultant MST
        boolean[] inMST = new boolean[numVertices];  // Array to track vertices included in MST

        Arrays.fill(key, INF);  // Initialize key values as infinite
        key[0] = 0;  // Start from the first vertex
        parent[0] = -1;  // First node is always the root of the MST

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(numVertices, key, inMST);  // Pick the minimum key vertex not yet included in MST
            inMST[u] = true;  // Include u in MST

            // Update key and parent index of the adjacent vertices of the picked vertex
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Update the key only if v is not in MST and weight of (u, v) is smaller than current key of v
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                }
            }
        }

        printMST(parent, numVertices, graph);
    }

    private static int minKey(int numVertices, int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printMST(int[] parent, int numVertices, List<List<int[]>> graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < numVertices; i++) {
            for (int[] neighbor : graph.get(i)) {
                if (neighbor[0] == parent[i]) {
                    System.out.println(parent[i] + " - " + i + "\t" + neighbor[1]);
                }
            }
        }
    }
}