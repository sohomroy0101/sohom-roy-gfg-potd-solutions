//Problem: Queue Reversal
//geeksforgeeks problem of the day -> 23rd September 2025
// C++ CODE
class Solution {
  public:
    void reverseQueue(queue<int> &q) {
        stack<int>st;
        while(!q.empty()){
            st.push(q.front());
            q.pop();
        }
        while(!st.empty()){
            q.push(st.top());
            st.pop();
        }
    }
};