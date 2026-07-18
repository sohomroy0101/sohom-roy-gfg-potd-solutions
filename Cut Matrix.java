// Problem: Cut Matrix
// geeksforgeeks problem of the day -> 18th July 2026
// JAVA CODE

class Solution {
    static final int MOD = 1000000007;

    public int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] suf = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                suf[i][j] = matrix[i][j] + suf[i + 1][j] + suf[i][j + 1] - suf[i + 1][j + 1];
            }
        }

        int[][] prev = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                prev[i][j] = (suf[i][j] > 0) ? 1 : 0;
            }
        }

        for (int cut = 2; cut <= k; cut++) {

            int[][] curr = new int[n][m];
            int[][] down = new int[n][m];
            int[][] right = new int[n][m];

            for (int j = 0; j < m; j++) {
                down[n - 1][j] = prev[n - 1][j];
                for (int i = n - 2; i >= 0; i--) {
                    down[i][j] = (down[i + 1][j] + prev[i][j]) % MOD;
                }
            }

            for (int i = 0; i < n; i++) {
                right[i][m - 1] = prev[i][m - 1];
                for (int j = m - 2; j >= 0; j--) {
                    right[i][j] = (right[i][j + 1] + prev[i][j]) % MOD;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {

                    if (suf[i][j] == 0)
                        continue;

                    long ways = 0;

                    int r = i + 1;
                    while (r < n && suf[r][j] == suf[i][j])
                        r++;
                    if (r < n)
                        ways += down[r][j];

                    int c = j + 1;
                    while (c < m && suf[i][c] == suf[i][j])
                        c++;
                    if (c < m)
                        ways += right[i][c];

                    curr[i][j] = (int) (ways % MOD);
                }
            }

            prev = curr;
        }

        return prev[0][0];
    }
}