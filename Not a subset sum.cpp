//Problem: Not a subset sum
//geeksforgeeks problem of the day -> 16th May 2026
//C++ CODE
class Solution {
  public:
    int findSmallest(vector<int> &arr) {
        // code here.
        sort(arr.begin(), arr.end());
        int ans = 1;
        for (int it : arr) {
            if (it > ans)
            {
                break;
            }
            ans += it;
        }
    
        return ans;
    }
};