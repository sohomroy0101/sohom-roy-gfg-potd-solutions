//Problem: Max Sum Pairing with Diff Less than K
//geeksforgeeks problem of the day -> 2nd June 2026
//JAVA CODE
class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int ans=0;
        for(int i=arr.length-1;i>0;)
        {
            if(arr[i]-arr[i-1]<k){
                ans=ans+arr[i]+arr[i-1];
                i=i-2;
            }
            else{
                i=i-1;
            }
        }
        return ans;
    }
}