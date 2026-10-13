// Problem: Adding Ones
// geeksforgeeks problem of the day -> 13th October 2026
// C++ CODE
class Solution {
  public:
    vector<int> update(int n, vector<int>& updates) {
        vector<int> arr(n, 0);
        for (int j : updates) {
            arr[j - 1]++;
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }
};