// Problem: Balanced Binary Tree Counter
// geeksforgeeks problem of the day -> 6th November 2026
// JAVA CODE
class Solution {
    public long countBT(int h) {
        long mod = 1000000007;
        
        // Base cases for height 0 and height 1
        if (h == 1) return 1;
        
        long a = 1; // Corresponds to height 1 (dp[1])
        long b = 1; // Corresponds to height 1 as base, but we will iterate up
        long c = 1;
        
        for (int i = 2; i <= h; i++) {
            // c = dp[i-1] * (2 * dp[i-2] + dp[i-1])
            c = (b * ((2 * a + b) % mod)) % mod;
            a = b;
            b = c;
        }
        
        return c;
    }
}