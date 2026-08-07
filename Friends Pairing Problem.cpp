// Problem: Friends Pairing Problem
// geeksforgeeks problem of the day -> 7th August 2026
// C++ CODE
class Solution {
public:
    int countFriendsPairings(int n) {
        if (n <= 2)
            return n;
        long long prev2 = 1;
        long long prev1 = 2; 
        for (int i = 3; i <= n; i++) {
            long long curr = prev1 + (i - 1) * prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
};