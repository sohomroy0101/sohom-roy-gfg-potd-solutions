// Problem: Minimum Operations to Reach n
// geeksforgeeks problem of the day -> 9th October 2026
// C++ CODE
class Solution {
  public:
    int minOperation(int n) {
        int ans = 0;
        while(n){
            if(n & 1) n -= 1;
            else n /= 2;
            ans++;
        }
        return ans;
    }
};