// Problem: Minimum Squares with Full Cuts
// geeksforgeeks problem of the day -> 12th October 2026
// C++ CODE

class Solution {
  public:
    int minSquares(int n, int m){
      if(n>m) return minSquares(m, n);
      if(n==0) return 0;
      int case1=m/n;
      int rem=m%n;
      return case1+(rem? minSquares(n, rem): 0);
    }
};