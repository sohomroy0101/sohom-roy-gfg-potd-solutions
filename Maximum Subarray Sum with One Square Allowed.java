// Problem: Maximum Subarray Sum with One Square Allowed
// geeksforgeeks problem of the day -> 1st November 2026
// JAVA CODE
class Solution {
    public int maximumSubarray(int[] arr) {
        int dp0 = arr[0];
        int dp1 = arr[0] * arr[0];
        int ans = Math.max(dp0, dp1);
        
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            
            // Maximum sum ending at i without any element squared
            int n0 = Math.max(x, dp0 + x);
            
            // Maximum sum ending at i with at most one element squared
            int sq = x * x;
            int n1 = Math.max(sq, Math.max(dp0 + sq, dp1 + x));
            
            dp0 = n0;
            dp1 = n1;
            
            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        
        return ans;
    }
}