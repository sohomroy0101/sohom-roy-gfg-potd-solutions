//Problem: Segregate 0s and 1s
//geeksforgeeks problem of the day -> 8th April 2026
//C++ CODE
class Solution {
  public:
    void segregate0and1(vector<int> &arr) {
        vector<int>ans;
        for(int i=0;i<arr.size();i++)
        {
            if(arr[i]==0)
            {
                ans.push_back(arr[i]);
            }
        }
        for(int i=0;i<arr.size();i++)
        {
            if(arr[i]==1)
            {
                ans.push_back(arr[i]);
            }
        }
        for(int i=0;i<ans.size();i++)
        {
            arr[i]=ans[i];
        }
    }
};