//Problem: Largest Unblocked Submatrix
//geeksforgeeks problem of the day -> 7th July 2026
//C++ CODE
class Solution {
public:
    int largestArea(int n, int m, vector<vector<int>>& arr) {

        vector<int> rows, cols;

        for (auto &x : arr) {
            rows.push_back(x[0]);
            cols.push_back(x[1]);
        }

        sort(rows.begin(), rows.end());
        sort(cols.begin(), cols.end());

        int maxRow = 0, prev = 0;

        for (int x : rows) {
            maxRow = max(maxRow, x - prev - 1);
            prev = x;
        }

        maxRow = max(maxRow, n - prev);

        int maxCol = 0;
        prev = 0;

        for (int x : cols) {
            maxCol = max(maxCol, x - prev - 1);
            prev = x;
        }

        maxCol = max(maxCol, m - prev);

        return maxRow * maxCol;
    }
};