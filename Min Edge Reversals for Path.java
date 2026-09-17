// Problem: Min Edge Reversals for Path
// geeksforgeeks problem of the day -> 17th September 2026
// JAVA CODE
import java.util.*;

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // Build adjacency list storing pair (neighbor, edgeWeight)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new int[]{v, 0}); // Original edge -> weight 0
            adj.get(v).add(new int[]{u, 1}); // Reversed edge -> weight 1
        }

        // Distance array initialized to infinity
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 0-1 BFS using Deque
        Deque<Integer> deque = new ArrayDeque<>();
        dist[src] = 0;
        deque.offer(src);

        while (!deque.isEmpty()) {
            int u = deque.poll();

            if (u == dst) {
                return dist[dst];
            }

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    // Push weight 0 edges to front, weight 1 edges to back
                    if (weight == 0) {
                        deque.offerFirst(v);
                    } else {
                        deque.offerLast(v);
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}