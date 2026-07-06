//Problem: Mother Vertex
//geeksforgeeks problem of the day -> 13th May 2026
//C++ CODE
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
    void dfs(int u, vector<vector<int>>& adj, vector<bool>& visited, int& count) {
        visited[u] = true;
        count++;
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v, adj, visited, count);
            }
        }
    }

    void findLastFinished(int u, vector<vector<int>>& adj, vector<bool>& visited, int& last) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                findLastFinished(v, adj, visited, last);
            }
        }
        last = u;
    }

public:
    int findMotherVertex(int V, vector<vector<int>>& edges) {
        vector<vector<int>> adj(V);
        for (auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
        }

        vector<bool> visited(V, false);
        int candidate = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                findLastFinished(i, adj, visited, candidate);
            }
        }

        fill(visited.begin(), visited.end(), false);
        int reach_count = 0;
        dfs(candidate, adj, visited, reach_count);

        if (reach_count != V) return -1;

        int smallest_mother = candidate;
        
        vector<int> in_degree(V, 0);
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj[i]) {
                in_degree[neighbor]++;
            }
        }

        for (int i = 0; i < candidate; i++) {
            fill(visited.begin(), visited.end(), false);
            int count = 0;
            dfs(i, adj, visited, count);
            if (count == V) return i;
        }

        return candidate;
    }
};