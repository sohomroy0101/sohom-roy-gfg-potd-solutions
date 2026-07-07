//Problem: Ways to Tile the Floor
//geeksforgeeks problem of the day -> 27th June 2026
//C++ CODE
class Solution {
  public:
    virtual int svc(int i, int n, int m, vector<int> &dp){
      if(i<m) return dp[i]=1;
      if(i==m) return dp[i]=2;
      if(dp[i]!=-1) return dp[i];
      return dp[i]=(svc(i-1, n, m, dp) + svc(i-m, n, m, dp))%(1000000007);
    }
    virtual int countWays(int n, int m){
      vector<int> dp(n+1, -1);
      return svc(n, n, m, dp);
    }
};