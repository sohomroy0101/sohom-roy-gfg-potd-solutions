//Problem: Count Increasing Subarrays
//geeksforgeeks problem of the day -> 11th April 2026
//C++ CODE
class Solution {
  public:
    int countIncreasing(vector<int>& arr) {
        int ans=0;
        int first=0,second=0;
        while(second<arr.size()-1)
        {
            if(arr[second]>=arr[second+1])
            {
                first=second+1;
                second=second+1;
            }
            else{
                second++;
                ans+=second-first;
            }
        }
        return ans;
    }
};