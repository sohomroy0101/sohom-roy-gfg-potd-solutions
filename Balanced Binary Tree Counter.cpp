// Problem: Balanced Binary Tree Counter
// geeksforgeeks problem of the day -> 6th November 2026
// C++ CODE
class Solution {
  public:
    long long int countBT(int h) {
      long long int mod=1000000007;
            long long int a=1;
            long long int b=1;
            long long int c;
            for(int i=2;i<=h;i++){
                c =b*((2*a)+b)%mod;
                a=b;
                b=c;
            }
        return c;
    }
};