//Problem: Smallest window containing 0, 1 and 2
//geeksforgeeks problem of the day -> 27th April 2026
//C++ CODE
class Solution {
  public:
    int smallestSubstring(string s) {
        int n=s.size();
        int i=0, j=0, count=INT_MAX;
        unordered_map<char,int> m;
        while(j < n){
            m[s[j]]++;
            while(m.size()==3){
                count = min(count, j-i+1);
                m[s[i]]--;
                if( m[s[i]]==0 ) m.erase(s[i]);
                
                i++;
            }
            j++;
        }
        return count==INT_MAX ? -1 : count;
    }
};