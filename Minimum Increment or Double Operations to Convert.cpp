// Problem: Minimum Increment or Double Operations to Convert
// geeksforgeeks problem of the day -> 6th August 2026
// C++ CODE
class Solution {
  public:
    int countMinOperations(vector<int>& arr) {
        long long ops = 0;
        int mx = 0;
        for (int x : arr) {
            ops += __builtin_popcount((unsigned int)x);
            mx = max(mx, x);
        }
        if (mx == 0) return 0;
        int doublings = 0;
        long long p = 1;
        while ((p << 1) <= mx) {
            p <<= 1;
            doublings++;
        }
        ops += doublings;
        return (int)ops;
    }
};