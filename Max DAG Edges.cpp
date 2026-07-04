//Problem: Max DAG Edges
//geeksforgeeks problem of the day -> 2nd November 2025
// C++ CODE
class Solution {
  public:
    virtual int maxEdgesToAdd(int V, vector<vector<int>> &edges){
      int maxEdges = (V*(V-1))/2;
      return ((maxEdges) - (edges.size()));
    }
};