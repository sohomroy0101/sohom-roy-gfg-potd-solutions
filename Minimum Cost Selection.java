// Problem: Minimum Cost Selection
// geeksforgeeks problem of the day -> 28th August 2026
// JAVA CODE
class Solution {

    private int minCostSvc(int i, int[][] mat, int prev, int[][] dp) {

        // All rows are processed
        if (i == mat.length) {
            return 0;
        }

        // Already calculated
        if (dp[i][prev] != -1) {
            return dp[i][prev];
        }

        int ans = Integer.MAX_VALUE;

        // Try all choices
        for (int j = 0; j < mat[0].length; j++) {

            // Cannot select the same choice as previous row
            if (j != prev) {

                ans = Math.min(
                    ans,
                    mat[i][j] + minCostSvc(i + 1, mat, j, dp)
                );
            }
        }

        return dp[i][prev] = ans;
    }

    public int minCost(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n + 1][m + 1];

        // Initialize DP table with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        // m represents "no previous choice"
        return minCostSvc(0, mat, m, dp);
    }
}