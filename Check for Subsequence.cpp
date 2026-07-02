//Problem: Check for Subsequence
//geeksforgeeks problem of the day -> 26th August 2025
// C++ CODE
class Solution {
  public:
    bool isSubSeq(string& s1, string& s2) {
        int i1=0, i2=0;
        int n1=s1.size(), n2=s2.size();
        while(i1<n1 && i2<n2){
            if(s1[i1] == s2[i2]){
                i1++;
                i2++;
            }else{
                i2++;
            }
        }
        return i1==n1;
    }
};