//Problem: Longest Possible Route in a Matrix with Hurdles
//geeksforgeeks problem of the day -> 11th July 2026
//C++ code
class Solution {
  public:
    int longestPath(vector<vector<int>> matrix, int xs, int ys, int xd, int yd)
    {
        // code here
        
        if(matrix[xs][ys]==0 || matrix[xd][yd]==0)return -1;
        int ans = -1;
        findLongestPath(matrix,xs,ys,xd,yd,0,ans);
        return ans;
        
    }
    
    void findLongestPath(vector<vector<int>> &matrix,int x,int y,int xd,int yd,int pathlength,int &ans)
     {
         if(x == xd && y == yd)
         {  if(pathlength>ans)ans = pathlength; return; }
         
         matrix[x][y]  = 2; 
         
         vector<pair<int,int>>neighbours = {{0,1}, {0,-1}, {1,0} ,{-1,0}};
         
         for(pair<int,int>neighbour : neighbours) {
             int newx = neighbour.first+x , newy = neighbour.second+y;
         if(newx>=0 && newy>=0 && newx<matrix.size() && newy<matrix[0].size() && matrix[newx][newy]==1)
             findLongestPath(matrix,newx,newy,xd,yd,pathlength+1,ans); }
         
         matrix[x][y] =1;
     }
};