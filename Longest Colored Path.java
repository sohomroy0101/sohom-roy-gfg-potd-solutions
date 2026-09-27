// Problem: Longest Colored Path
// geeksforgeeks problem of the day -> 27th September 2026
// JAVA CODE

import java.util.*;

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            g[u].add(v);
            g[v].add(u);
        }

        int[] c = new int[n];
        for (int i = 0; i < n; ++i) {
            c[i] = (s.charAt(i) == 'B') ? 1 : 0;
        }

        int[] par = new int[n];
        Arrays.fill(par, -1);
        List<Integer> order = new ArrayList<>(n);

        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(0);
        par[0] = -2;

        while (!st.isEmpty()) {
            int u = st.pop();
            order.add(u);
            for (int v : g[u]) {
                if (v != par[u]) {
                    par[v] = u;
                    st.push(v);
                }
            }
        }

        int[] down = new int[n];
        int[] up = new int[n];
        Arrays.fill(down, 1);
        Arrays.fill(up, 1);

        int ans = 1;

        // Bottom-up pass
        for (int i = n - 1; i >= 0; --i) {
            int u = order.get(i);
            int t1 = 0, t2 = 0;
            for (int v : g[u]) {
                if (par[v] == u && c[v] == c[u]) {
                    if (down[v] > t1) {
                        t2 = t1;
                        t1 = down[v];
                    } else if (down[v] > t2) {
                        t2 = down[v];
                    }
                }
            }
            down[u] = t1 + 1;
            ans = Math.max(ans, down[u]);
            if (t2 > 0) {
                ans = Math.max(ans, t1 + t2 + 1);
            }
        }

        // Top-down pass
        for (int u : order) {
            int t1 = 0, t2 = 0, id = -1;
            for (int v : g[u]) {
                if (par[v] == u && c[v] == c[u]) {
                    if (down[v] > t1) {
                        t2 = t1;
                        t1 = down[v];
                        id = v;
                    } else if (down[v] > t2) {
                        t2 = down[v];
                    }
                }
            }
            for (int v : g[u]) {
                if (par[v] == u) {
                    if (c[v] != c[u]) {
                        up[v] = 1;
                    } else {
                        up[v] = 1 + Math.max(up[u], 1 + (v == id ? t2 : t1));
                    }
                }
            }
        }

        // Combine paths across mismatched color edges
        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            if (c[u] != c[v]) {
                int pathU = Math.max(down[u], up[u]);
                int pathV = Math.max(down[v], up[v]);
                ans = Math.max(ans, pathU + pathV);
            }
        }

        return ans;
    }
}