//Problem: Longest Substring with K Uniques
//geeksforgeeks problem of the day -> 5th March 2026
//C++ CODE
class Solution {
  public:
    int longestKSubstr(string &s, int k) {
        vector<int> freq(26,0);
        int distinct=0, maxLen=-1, l=0;
        for(int r=0; r<s.length(); r++){
            if(freq[s[r]-'a']==0) distinct++;
            freq[s[r]-'a']++;
            while(distinct>k){
                if(freq[s[l]-'a']==1) distinct--;
                freq[s[l]-'a']--;
                l++;
            }
            if(distinct==k) maxLen=max(maxLen, r-l+1);
        }
        return maxLen;
    }
};