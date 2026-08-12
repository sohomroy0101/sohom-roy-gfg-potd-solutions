// Problem: Adventure in a Maze
// geeksforgeeks problem of the day -> 12th August 2026
// JAVA CODE
class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {

        int n = grid.length;

        // ways[i][j] = number of ways to reach (i, j)
        int[][] ways = new int[n][n];

        // adv[i][j] = maximum adventure to reach (i, j)
        int[][] adv = new int[n][n];

        int MOD = 1_000_000_007;

        // Starting cell
        ways[0][0] = 1;
        adv[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Ignore cells that cannot be reached
                if (ways[i][j] == 0) continue;

                // Move Right: allowed for 1 or 3
                if ((grid[i][j] == 1 || grid[i][j] == 3) && j + 1 < n) {

                    ways[i][j + 1] =
                        (ways[i][j + 1] + ways[i][j]) % MOD;

                    adv[i][j + 1] = Math.max(
                        adv[i][j + 1],
                        adv[i][j] + grid[i][j + 1]
                    );
                }

                // Move Down: allowed for 2 or 3
                if ((grid[i][j] == 2 || grid[i][j] == 3) && i + 1 < n) {

                    ways[i + 1][j] =
                        (ways[i + 1][j] + ways[i][j]) % MOD;

                    adv[i + 1][j] = Math.max(
                        adv[i + 1][j],
                        adv[i][j] + grid[i + 1][j]
                    );
                }
            }
        }

        // Return total paths and maximum adventure
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(ways[n - 1][n - 1]);
        ans.add(adv[n - 1][n - 1]);

        return ans;
    }
}

// Time  : O(n²)
// Space : O(n²)
