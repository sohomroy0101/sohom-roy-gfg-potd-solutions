//Problem: AND In Range
//geeksforgeeks problem of the day -> 26th November 2025
// C++ CODE
class Solution {
  public:
    virtual int andInRange(int l, int r) {
      int c=0;
      while(l != r){
        c++;
        l>>=1;
        r>>=1;
      }
      return (l<<c);
    }
};