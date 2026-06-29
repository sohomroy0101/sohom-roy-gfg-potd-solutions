//Problem: Counting elements in two arrays
//geeksforgeeks problem of the day -> 28th June 2025

//C++ code
class Solution {
  public:
    vector<int> countLessEq(vector<int>& a, vector<int>& b) {
        sort(b.begin(), b.end());
        vector<int> ans;
        for (int x : a) {
            int k = upper_bound(b.begin(), b.end(), x) - b.begin();
            ans.push_back(k);
        }
        return ans;
    }
};