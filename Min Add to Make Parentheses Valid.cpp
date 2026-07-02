//Problem: Min Add to Make Parentheses Valid
//geeksforgeeks problem of the day -> 19th September 2025
// C++ CODE
class Solution {
  public:
    int minParentheses(string& s) {
        int res = 0, st = 0;
        for(auto it : s)
        {
            if(it=='(')
            st++;
            else if(st)
            st--;
            else
            res++;
        }
        return res+st;
    }
};