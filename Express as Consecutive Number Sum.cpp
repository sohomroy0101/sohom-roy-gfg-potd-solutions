//Problem: Express as Consecutive Number Sum 
//geeksforgeeks problem of the day -> 31st May 2026
//C++ CODE
class Solution {
  public:
    bool isSumOfConsecutive(int n) {
        return (n&(n-1)) != 0;
    }
};