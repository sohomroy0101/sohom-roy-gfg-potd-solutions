// Problem: Count Tree Paths With Limited Max Edge Weight
// geeksforgeeks problem of the day -> 3rd November 2026
// JAVA CODE
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    private int[] parent;
    private int[] sz;

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        int q = queries.length;
        // Pair to store query value and its original index
        int[][] sortedQ = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQ[i][0] = queries[i];
            sortedQ[i][1] = i;
        }
        
        // Sort queries by query value
        Arrays.sort(sortedQ, (a, b) -> Integer.compare(a[0], b[0]));
        
        parent = new int[n + 1];
        sz = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
        
        long paths = 0;
        int[] ansArr = new int[q];
        int j = 0;
        
        for (int i = 0; i < q; i++) {
            int x = sortedQ[i][0];
            int idx = sortedQ[i][1];
            
            // Add all edges with weight <= x
            while (j < edges.length && edges[j][2] <= x) {
                int u = edges[j][0];
                int v = edges[j][1];
                int pu = find(u);
                int pv = find(v);
                
                if (pu != pv) {
                    paths += (long) sz[pu] * sz[pv];
                    if (sz[pu] < sz[pv]) {
                        int temp = pu;
                        pu = pv;
                        pv = temp;
                    }
                    parent[pv] = pu;
                    sz[pu] += sz[pv];
                }
                j++;
            }
            ansArr[idx] = (int) paths;
        }
        
        // Convert the result array into an ArrayList<Integer>
        ArrayList<Integer> ans = new ArrayList<>(q);
        for (int val : ansArr) {
            ans.add(val);
        }
        
        return ans;
    }
}