//Problem: Assign Mice Holes
//geeksforgeeks problem of the day -> 9th September 2025
// C++ CODE
class Solution {
  public:
    int assignHole(vector<int>& mices, vector<int>& holes) {
        int ans = INT_MIN;
        sort(mices.begin(), mices.end());
        sort(holes.begin(), holes.end());
        int n = mices.size();
        for(int i=0;i<n;i++){
            ans = max(ans, abs(holes[i]-mices[i]));
        }
        return ans;
    }
};