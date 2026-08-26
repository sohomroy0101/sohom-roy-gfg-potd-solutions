// Problem: Negative Weight Cycle
// geeksforgeeks problem of the day -> 26th August 2026
// JAVA CODE
class Solution {
    public boolean isNegativeWeightCycle(int n, int[][] edges) {

        int[] dist = new int[n];

        // Initialize all distances to 0
        // This allows detection of negative cycles
        // in disconnected components as well.
        for (int i = 0; i < n; i++) {
            dist[i] = 0;
        }

        int m = edges.length;

        // Relax all edges n - 1 times
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < m; j++) {

                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // One more relaxation
        // If possible, a negative cycle exists.
        for (int j = 0; j < m; j++) {

            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];

            if (dist[u] + wt < dist[v]) {
                return true;
            }
        }

        return false;
    }
}