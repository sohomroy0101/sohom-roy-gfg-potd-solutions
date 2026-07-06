//Problem: Check for Power
//geeksforgeeks problem of the day -> 19th April 2026
//C++ CODE
class Solution {
  public:
    virtual bool check(int l, int r, int x, int y){
      if(l>r) return false;
      int m=l+(r-l)/2;
      int pxm=pow(x, m);
      if(pxm == y) return true;
      if(pxm>=0 && pxm<y) return check(m+1, r, x, y);
      return check(l, m-1, x, y);
    }
    virtual bool isPower(int x, int y){
      return check(0, 32, x, y);    
    }
};