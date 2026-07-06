//Problem: Subarrays with First Element Minimum
//geeksforgeeks problem of the day -> 10th March 2026
//C++ CODE
class Solution {
  public:
    int countSubarrays(vector<int> &arr) {
         int ans=0;
        stack<int>stk;
        for(int i=0;i<arr.size();i++){
            while(!stk.empty() and stk.top()>arr[i])stk.pop();
            stk.push(arr[i]);
            ans+=stk.size();
        }
        return ans;
    }
};