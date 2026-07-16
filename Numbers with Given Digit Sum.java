//Problem: Numbers with Given Digit Sum
//geeksforgeeks problem of the day -> 16th July 2026
// JAVA CODE
class Solution {
    public int countWays(int n, int sum) {
        if (sum > 9 * n || sum < 1)
            return -1;

        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;

        for (int pos = 1; pos <= n; pos++) {
            for (int s = 0; s <= sum; s++) {
                int start = (pos == 1) ? 1 : 0;

                for (int digit = start; digit <= 9; digit++) {
                    if (s >= digit) {
                        dp[pos][s] += dp[pos - 1][s - digit];
                    }
                }
            }
        }

        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
}