// Problem: Minimum Deletions to Make Sorted
// geeksforgeeks problem of the day -> 22nd July 2026
// C++ CODE

class Solution {
  public:
    int minDeletions(vector<int>& arr) {
        vector<int> sorted;
        for (int x : arr) {
            auto it = lower_bound(begin(sorted), end(sorted), x);
            if (it == sorted.end()) {
                sorted.push_back(x);
            } else {
                *it = x;
            }
        }
        return arr.size() - sorted.size();
    }
};