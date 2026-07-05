//Problem: Swap diagonals
//geeksforgeeks problem of the day -> 13th December 2025
// C++ CODE
class Solution {
  public:
    void swapDiagonal(vector<vector<int>> &mat) {
        int n=mat.size();
        for(int i=0;i<n;i++){
            swap(mat[i][i],mat[i][n-1-i]);
        }
    }
};