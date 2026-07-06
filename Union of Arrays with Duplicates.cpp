//Problem: Union of Arrays with Duplicates
//geeksforgeeks problem of the day -> 23rd February 2026
//C++ CODE
class Solution {
  public:
    vector<int> findUnion(vector<int>& a, vector<int>& b) {
        unordered_set<int>st(a.begin(),a.end());
        st.insert(b.begin(),b.end());
        return vector<int>(st.begin(),st.end());
    }
};