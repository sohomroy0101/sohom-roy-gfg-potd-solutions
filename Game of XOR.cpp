//Problem: Game of XOR
//geeksforgeeks problem of the day -> 25th November 2025
// C++ CODE
class Solution {
  public:
    int subarrayXor(vector<int>& a) {
        int ans=a[0];
        if(a.size()%2==0)return 0;
        for(int i=2;i<a.size();i+=2){
        ans^=a[i];
        }
        return ans;
    }
};