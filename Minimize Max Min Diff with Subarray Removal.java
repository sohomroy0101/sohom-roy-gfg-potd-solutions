// Problem: Minimize Max Min Diff with Subarray Removal
// geeksforgeeks problem of the day -> 26th October 2026
// JAVA CODE
class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;
        if (n == k) {
            return 0;
        }
        
        int[] prefMax = new int[n];
        int[] prefMin = new int[n];
        int[] suffMax = new int[n];
        int[] suffMin = new int[n];
        
        prefMax[0] = arr[0];
        prefMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], arr[i]);
            prefMin[i] = Math.min(prefMin[i - 1], arr[i]);
        }
        
        suffMax[n - 1] = arr[n - 1];
        suffMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMax[i] = Math.max(suffMax[i + 1], arr[i]);
            suffMin[i] = Math.min(suffMin[i + 1], arr[i]);
        }
        
        // Case 1: Remove prefix of size k or suffix of size k
        int ans = Math.min(suffMax[k] - suffMin[k], prefMax[n - k - 1] - prefMin[n - k - 1]);
        
        // Case 2: Remove a subarray somewhere in the middle
        for (int i = 0; i < n - k - 1; i++) {
            int currentMax = Math.max(prefMax[i], suffMax[i + k + 1]);
            int currentMin = Math.min(prefMin[i], suffMin[i + k + 1]);
            ans = Math.min(ans, currentMax - currentMin);
        }
        
        return ans;
    }
}