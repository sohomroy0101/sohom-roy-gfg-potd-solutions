//Problem: Max Circular Subarray Sum
//geeksforgeeks problem of the day -> 25th July 2025
//C++ CODE
class Solution {
  public:
    int maxCircularSum(vector<int> &arr) {
        int totalSum = 0;
        int curMax = 0;
        int curMin = 0;
        int maxSum = INT_MIN;
        int minSum = INT_MAX;
        for(int i =0; i< arr.size(); i++) {
            totalSum += arr[i];
            curMin = min(curMin + arr[i], arr[i]);
            curMax = max(curMax + arr[i], arr[i]);
            maxSum = max(maxSum, curMax);
            minSum = min(minSum, curMin);
        }
        return (maxSum > 0) ? max(maxSum, (totalSum - minSum)) : maxSum;
    }
};