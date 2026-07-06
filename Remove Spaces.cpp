//Problem: Remove Spaces
//geeksforgeeks problem of the day -> 14th April 2026
//C++ CODE
class Solution {
  public:
    string removeSpaces(string s) {
        string result;
        result.reserve(s.size());
        for(char ch : s) {
            if(ch != ' ') {
                result += ch;
            }
        }
        return result;
    }
};