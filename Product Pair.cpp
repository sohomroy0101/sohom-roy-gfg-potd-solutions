//Problem: Product Pair
//geeksforgeeks problem of the day -> 20th May 2026
//C++ CODE
class Solution {
  public:
    bool isProduct(vector<int>& arr, long long target) {
        unordered_set<int> st;
        for(auto it : arr)
        {
            if((it && target%abs(it)==0 && st.find(target/it)!=st.end()) || (!it && !target))
            return true;
            st.insert(it);
        }
        return false;
    }
};