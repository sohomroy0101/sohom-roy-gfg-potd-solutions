//Problem: Maximum Sum Problem
//geeksforgeeks problem of the day -> 18th May 2026
//C++ CODE
class Solution {
  public:
  int solve(int n){
      if(n==0) return 0;
      return max(n, solve(n/2)+solve(n/3)+solve(n/4));
  }
    int maxSum(int n) {
        // code here.
        return solve(n);
    }
};