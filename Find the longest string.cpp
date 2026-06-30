//Problem: Find the longest string
//geeksforgeeks problem of the day -> 10th July 2025
//C++ CODE
class Solution {
  public:
    string longestString(vector<string> &arr) {
        unordered_set<string> s = {""};
        string ans = "";
        sort(arr.begin(),arr.end());
        for(auto str : arr){
            if(s.count(str.substr(0,str.length()-1))){
                if(str.length()>ans.length()) ans = str;
                s.insert(str);
            }
        }
        return ans;
    }
};