//Problem: Check if All Bits Set
//geeksforgeeks problem of the day -> 21st May 2026
//C++ CODE
class Solution {
  public:
    bool isBitSet(int n) {
        // code here
        if(n==0) return false;
        
        int x=n+1;
        
        return (x & (x - 1)) == 0;
    }
};