// Problem: Check Preorder of BST
// geeksforgeeks problem of the day -> 23rd July 2026
// C++ CODE
class Solution {
  public:
    bool canRepresentBST(vector<int> &arr) {
        stack<int> st;
        int lowerBound = INT_MIN;
        for (int value : arr) {
            if (value < lowerBound)
                return false;
            while (!st.empty() && value > st.top()) {
                lowerBound = st.top();
                st.pop();
            }
            st.push(value);
        }
        return true;
    }
};