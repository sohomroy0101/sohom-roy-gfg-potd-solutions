//Problem: URLify a given string
//geeksforgeeks problem of the day -> 15th April 2026
//C++ CODE
class Solution {
 public:
   string URLify(string &s) {
     string ans="";
   for(int i = 0; i<s.length(); i++){
       if(s[i] == ' '){
     ans+="%20";
       }
       else {
     ans+=s[i];
 }    
  }
  return ans;
   }
};