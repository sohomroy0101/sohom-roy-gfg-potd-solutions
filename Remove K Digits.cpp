//Problem: Remove K Digits
//geeksforgeeks problem of the day -> 19th January 2026
// C++ CODE
class Solution {
  public:
    string removeKdig(string &s, int k) {
        //CodeGenius
        stack<char>st;
        for(char c : s){
            while(!st.empty() && k && c<st.top()){
                st.pop();
                k--;
            }
            if(!st.empty() || c!='0')
            st.push(c);
        }
        while(!st.empty() && k){
            st.pop();
            k--;
        }
        if(st.empty()) return "0";
        string num;
        while(!st.empty()){
            num.push_back(st.top());
            st.pop();
        }
        reverse(num.begin(),num.end());
        return num;
        
    }
};