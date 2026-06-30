//Problem: Divisible by 13
//geeksforgeeks problem of the day -> 15th July 2025
//C++ CODE
class Solution {
  public:
    bool divby13(string &s) {
        int num = (int)(s[0]-'0');
        for(int i = 1;i<s.size();i++)
        num = ((num*10) + (int)(s[i]-'0'))%13;
        return !(num);
    }
};