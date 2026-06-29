//Problem: Case-specific Sorting of Strings
//geeksforgeeks problem of the day -> 19th June 2025

//C++ code
class Solution {
  public:
    string caseSort(string& s) {
        vector<char>uppercase;
        vector<char>lowercase;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(int(s[i])>=65 && int(s[i])<=90){
                uppercase.push_back(s[i]);
            }
            else{
                lowercase.push_back(s[i]);
            }
        }
        sort(uppercase.begin(),uppercase.end());
        sort(lowercase.begin(),lowercase.end());
        int t=0,u=0;
        string ans;
        for(int i=0;i<n;i++){
            if(int(s[i])>=65 && int(s[i])<=90){
                ans+=uppercase[t];
                t++;
            }
            else{
                ans+=lowercase[u];
                u++;
            }
        }
        return ans;
    }
};