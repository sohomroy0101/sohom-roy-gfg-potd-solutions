//Problem: Expression contains redundant bracket or not
//geeksforgeeks problem of the day -> 17th January 2026
// C++ CODE
class Solution {
  public:
    bool checkRedundancy(string &s) {
        stack<char>st;
        for(char c:s) {
            if(c!=')') st.push(c);
            else {
                int x=0;
                while(st.top()!='(') {
                    st.pop();
                    x++;
                }
                st.pop();
                if(x<2) return 1;
            }
        }
        return 0;
    }
};