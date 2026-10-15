// Problem: Maximum Without 3 Consecutive Set Bits
// geeksforgeeks problem of the day -> 15th October 2026
// C++ CODE
class Solution {
  public:
    int maxValue(int n) {
        int res = 0;
        int consec = 0;
        for (int i = 30; i >= 0; i--) {
            if (n & (1 << i)) {
                if (consec < 2) {
                    res |= (1 << i);
                    consec++;
                } else {
                    consec = 0;
                }
            } else {
                consec = 0;
            }
        }
        return res;
    }
};