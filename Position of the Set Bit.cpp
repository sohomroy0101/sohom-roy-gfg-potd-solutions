//Problem:  Position of the Set Bit
//geeksforgeeks problem of the day -> 2nd May 2026
//C++ CODE
class Solution {
public:
    int findPosition(int n) {
        int res = -1;
        for (int i = 1; n; i++, n >>= 1)
            if (n & 1) {
                if (res == -1)
                    res = i;
                else
                    return -1;
            }
        return res;
    }
};