// Problem: Maximum Packages within Time
// geeksforgeeks problem of the day -> 31st October 2026
// JAVA CODE
class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        if (n == 0 || totalTime <= 0) return 0;
        
        int k = Math.min(n, totalTime);
        int currentSum = 0;
        
        // Sum of the first window of size k
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        
        int maxSum = currentSum;
        
        // Slide the window across the array
        for (int i = k; i < n; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}