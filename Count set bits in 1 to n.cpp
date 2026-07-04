//Problem: Count set bits in 1 to n
//geeksforgeeks problem of the day -> 29th November 2025
// C++ CODE
class Solution {
public:
    int countSetBits(int n) {
        if (n == 0)
            return 0;

        int x = 0;
        while ((1 << (x + 1)) <= n)
            x++;

        int bitsTill2x = 0;
        if (x > 0)
            bitsTill2x = x * (1 << (x - 1));

        int msbBits = n - (1 << x) + 1;
        int remaining = n - (1 << x);

        return bitsTill2x + msbBits + countSetBits(remaining);
    }
};