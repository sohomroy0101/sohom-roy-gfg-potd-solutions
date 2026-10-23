// Problem: Palindrome with Replacement
// geeksforgeeks problem of the day -> 21st October 2026
// JAVA CODE
class Solution {
    public int minSubarraySum(int[] arr) {
        int previousSum = 0;
        int minSum = Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            int temp = Math.min(arr[i], previousSum+arr[i]);
            minSum = Math.min(minSum, temp);
            previousSum = temp;
        }
        return minSum;
    }
}