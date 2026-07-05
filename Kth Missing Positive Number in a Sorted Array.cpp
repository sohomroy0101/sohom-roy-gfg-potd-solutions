//Problem: Kth Missing Positive Number in a Sorted Array
//geeksforgeeks problem of the day -> 26th December 2025
// C++ CODE

class Solution {
  public:
    int kthMissing(vector<int> &arr, int k) {
        vector<int>ans;
        int i = 1;
        int id =0;
        while(i<=arr[arr.size()-1]){
            if(i < arr[id]) {
                ans.push_back(i);
                i++;
            }
            else {
                i++, id++;
            }
        }
        if(ans.size()<k) return arr[arr.size()-1] + k-ans.size();
        return ans[k-1];
    }
};