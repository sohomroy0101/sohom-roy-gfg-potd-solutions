// Problem: Sort Two Parts Sorted
// geeksforgeeks problem of the day -> 11th October 2026
// JAVA CODE
class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int breakPoint = -1;
        
        // Find the break point where the sorted order is violated
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                breakPoint = i;
                break;
            }
        }
        
        // If no break point is found, the array is already sorted
        if (breakPoint == -1) {
            return;
        }
        
        // Merge the two sorted parts: arr[0 ... breakPoint] and arr[breakPoint + 1 ... n - 1]
        int[] temp = new int[n];
        int i = 0;                      // Pointer for the first part
        int j = breakPoint + 1;         // Pointer for the second part
        int k = 0;                      // Pointer for the temp array
        
        while (i <= breakPoint && j < n) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        // Copy remaining elements from the first part, if any
        while (i <= breakPoint) {
            temp[k++] = arr[i++];
        }
        
        // Copy remaining elements from the second part, if any
        while (j < n) {
            temp[k++] = arr[j++];
        }
        
        // Copy elements back to the original array
        System.arraycopy(temp, 0, arr, 0, n);
    }
}