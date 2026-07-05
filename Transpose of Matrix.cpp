//Problem: Transpose of Matrix
//geeksforgeeks problem of the day -> 12th December 2025
// C++ CODE
class Solution {
  public:
    vector<vector<int>> transpose(vector<vector<int>>& mat) {
        int n = mat.size();
        for (uint i = 0; i < n; ++i) {
            for (uint j = i; j < n; ++j)
                swap(mat[i][j], mat[j][i]);
        }
        return mat;
    }
};