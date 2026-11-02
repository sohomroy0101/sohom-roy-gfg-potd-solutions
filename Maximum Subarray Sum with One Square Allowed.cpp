// Problem: Maximum Subarray Sum with One Square Allowed
// geeksforgeeks problem of the day -> 1st November 2026
// C++ CODE
class Solution {
  public:
    int maximumSubarray(vector<int>& arr) {
        int dp0 = arr[0];
        int dp1 = arr[0] * arr[0];
        int ans = max(dp0, dp1);
        for (int i = 1; i < arr.size(); i++) {
            int x = arr[i];
            int n0 = max(x, dp0 + x);
            int n1 = max({x*x, dp0 + x*x, dp1 + x});
            dp0 = n0;
            dp1 = n1;
            ans = max({ans, dp0, dp1});
        }
        return ans;
    }
};