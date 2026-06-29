//Problem: Max Score from Subarray Mins
//geeksforgeeks problem of the day -> 5th July 2025
//C++ CODE
class Solution {
  public:
    int maxSum(vector<int> &arr) {
        //CodeGenius
        int ans=0;
        for(int i =1;i<arr.size();i++)
            ans=max(ans,arr[i]+arr[i-1]);
        return ans;
    }
};