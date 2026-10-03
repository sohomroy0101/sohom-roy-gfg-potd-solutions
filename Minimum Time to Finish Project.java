// Problem: Minimum Time to Finish Project
// geeksforgeeks problem of the day -> 1st October 2026
// JAVA CODE
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;

        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int[] dep : dependencies) {
            int u = dep[0];
            int v = dep[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        // finishTime[i] stores the earliest completion time of module i
        long[] finishTime = new long[n];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            finishTime[i] = duration[i];
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedCount = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processedCount++;

            for (int v : adj.get(u)) {
                // Earliest completion time for v is updated based on its dependency u
                finishTime[v] = Math.max(finishTime[v], finishTime[u] + duration[v]);

                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // If not all nodes were processed, a cycle exists
        if (processedCount < n) {
            return -1;
        }

        long maxTime = 0;
        for (long t : finishTime) {
            maxTime = Math.max(maxTime, t);
        }

        return (int) maxTime;
    }
}