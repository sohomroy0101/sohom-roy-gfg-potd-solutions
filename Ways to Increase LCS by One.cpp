//Problem: Ways to Increase LCS by One
//geeksforgeeks problem of the day -> 3rd July 2026
//C++ CODE
class Solution {
public:
    int waysToIncreaseLCSBy1(string s1, string s2) {
        int n = s1.length();
        int m = s2.length();

        vector<vector<int>> lcsl(n + 2, vector<int>(m + 2, 0));
        vector<vector<int>> lcsr(n + 2, vector<int>(m + 2, 0));

        // Prefix LCS DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1])
                    lcsl[i][j] = lcsl[i - 1][j - 1] + 1;
                else
                    lcsl[i][j] = max(lcsl[i - 1][j], lcsl[i][j - 1]);
            }
        }

        // Suffix LCS DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1[i] == s2[j])
                    lcsr[i][j] = lcsr[i + 1][j + 1] + 1;
                else
                    lcsr[i][j] = max(lcsr[i + 1][j], lcsr[i][j + 1]);
            }
        }

        int lcs = lcsl[n][m];
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            for (char c = 'a'; c <= 'z'; c++) {

                for (int j = 0; j < m; j++) {
                    if (s2[j] != c)
                        continue;

                    if (lcsl[i][j] + lcsr[i][j + 1] == lcs) {
                        ans++;
                        break;
                    }
                }
            }
        }

        return ans;
    }
};