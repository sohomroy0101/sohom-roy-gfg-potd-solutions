// Problem: Palindrome with Replacement
// geeksforgeeks problem of the day -> 22nd October 2026
// JAVA CODE
class Solution {
    public int minimumSum(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        // Pass 1: Ensure palindrome symmetry and fill known mirror characters
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != '?' && arr[n - 1 - i] != '?' && arr[i] != arr[n - 1 - i]) {
                return -1;
            }
            if (arr[i] == '?' && arr[n - 1 - i] != '?') {
                arr[i] = arr[n - 1 - i];
            } else if (arr[i] != '?' && arr[n - 1 - i] == '?') {
                arr[n - 1 - i] = arr[i];
            }
        }
        
        // Find the first non-'?' character
        int i = 0;
        while (i < n && arr[i] == '?') {
            i++;
        }
        
        // If all characters are '?'
        if (i == n) {
            return 0;
        }
        
        char prev = arr[i];
        int ans = 0;
        
        // Pass 2: Fill remaining '?' greedily and calculate minimum adjacent ASCII difference sum
        for (int j = i + 1; j < n; j++) {
            if (arr[j] == '?') {
                arr[j] = prev;
            }
            ans += Math.abs(arr[j] - prev);
            prev = arr[j];
        }
        
        return ans;
    }
}