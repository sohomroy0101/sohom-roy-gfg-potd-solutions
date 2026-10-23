// Problem: Palindrome with Replacement
// geeksforgeeks problem of the day -> 21st October 2026
// C++ CODE
class Solution {
  public:
    int minSubarraySum(vector<int> &arr) {
        // code here
        int ans=INT_MAX;
        int sum=0;
        for(auto it:arr)
        {
            sum+=it;
            ans=min(ans,sum);
            sum=min(0,sum);
        }
        return ans;
    }
};