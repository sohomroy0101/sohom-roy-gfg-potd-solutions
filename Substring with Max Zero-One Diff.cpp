//Problem: Substring with Max Zero-One Diff
//geeksforgeeks problem of the day -> 4th June 2026
//C++ CODE
class Solution {
public:
    int maxSubstring(string S) {
        int currSum = 0;
        int maxSum = -1;

        for (char ch : S) {
            int val = (ch == '0') ? 1 : -1;

            currSum = max(val, currSum + val);
            maxSum = max(maxSum, currSum);
        }

        return maxSum;
    }
};