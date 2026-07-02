//Problem: The Celebrity Problem
//geeksforgeeks problem of the day -> 30th August 2025
// C++ CODE
class Solution {
  public:
    int celebrity(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        for(int i=0;i<n;i++){
        bool flag = true;
        for(int j=0;j<n;j++){
            if (i==j) continue;
            if ( (mat[i][j]==1 ||  mat[j][i]==0) ){
                flag =false;
                break;
            }
        }
        if (flag ) return i;
        }       
        return -1;
    }
};