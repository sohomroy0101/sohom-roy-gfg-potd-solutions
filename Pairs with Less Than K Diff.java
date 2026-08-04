// Problem: Pairs with Less Than K Diff
// geeksforgeeks problem of the day -> 4th August 2026
// JAVA CODE
class Solution {
    public static int countPairs(int arr[], int k) {
        if(k == 0){
            return 0;
        }
        Arrays.sort(arr);
        
        int n = arr.length;
        int left = 0, right = 1;
        int count = 0;
        
        while(left < n){
            if(right == left){
                right = left+1;
            }
            
            while(right < n && arr[right] - arr[left] < k){
                right++;
            }
            
            count+= (right - left-1);
            left++;
        }
        return count;
    }
}