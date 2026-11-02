// Problem: Largest Sum Cycle
// geeksforgeeks problem of the day -> 2nd November 2026
// JAVA CODE
class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] vis = new int[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            path[i] = -1;
        }
        
        int ans = -1;
        
        for (int i = 0; i < n; i++) {
            if (vis[i] == 1) {
                continue;
            }
            
            int node = i;
            int step = 0;
            
            while (node != -1 && vis[node] == 0) {
                vis[node] = 1;
                path[node] = step++;
                node = edge[node];
            }
            
            // If we hit a node already in the current path, a cycle is found
            if (node != -1 && path[node] != -1) {
                int sum = 0;
                int curr = node;
                do {
                    sum += curr;
                    curr = edge[curr];
                } while (curr != node);
                
                ans = Math.max(ans, sum);
            }
            
            // Backtrack and clear the current path markers
            node = i;
            while (node != -1 && path[node] != -1) {
                int next = edge[node];
                path[node] = -1;
                node = next;
            }
        }
        
        return ans;
    }
}