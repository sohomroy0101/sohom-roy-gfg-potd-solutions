//Problem: Anagram Palindrome
//geeksforgeeks problem of the day -> 17th April 2026
//C++ CODE
class Solution {
  public:
    bool canFormPalindrome(string &s) {
        vector<int> freq(26,0);
        for(char c : s)
            freq[c - 'a']++;
        int oddcount = 0;
        for(auto it : freq)
            if(it%2!= 0)
                oddcount++;
        return (oddcount<=1);
    }
};