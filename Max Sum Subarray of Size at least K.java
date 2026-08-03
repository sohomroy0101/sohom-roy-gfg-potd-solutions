// Problem: Max Sum Subarray of Size at least K
// geeksforgeeks problem of the day -> 3rd August 2026
// JAVA CODE
class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        int[] pre = new int[n];
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i];
            pre[i] = sum1;
        }

        int[] suffixMax = new int[n];
        int maxPrefix = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            maxPrefix = Math.max(maxPrefix, pre[i]);
            suffixMax[i] = maxPrefix;
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;

        if (k < n) {
            ans = Math.max(ans, windowSum + suffixMax[k] - pre[k - 1]);
        }

        int left = 0;
        for (int right = k; right < n; right++) {
            windowSum -= arr[left];
            windowSum += arr[right];

            ans = Math.max(ans, windowSum);

            if (right + 1 < n) {
                ans = Math.max(ans,
                        windowSum + suffixMax[right + 1] - pre[right]);
            }

            left++;
        }

        return ans;
    }
}