// Problem: Sequences where Adjacent Divide
// geeksforgeeks problem of the day -> 2nd August 2026
// JAVA CODE
class Solution {

    private int solve(int n, int m, int prev, int[][] dp) {
        if (n == 0) {
            return 1;
        }

        if (dp[n][prev + 1] != -1) {
            return dp[n][prev + 1];
        }

        int result = 0;

        for (int i = 1; i <= m; i++) {
            if (prev == -1) {
                result += solve(n - 1, m, i, dp);
            } else if (prev % i == 0 || i % prev == 0) {
                result += solve(n - 1, m, i, dp);
            }
        }

        dp[n][prev + 1] = result;
        return result;
    }

    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 2];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n, m, -1, dp);
    }
}