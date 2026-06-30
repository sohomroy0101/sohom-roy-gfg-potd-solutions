//Problem: Last Moment Before All Ants Fall Out
//geeksforgeeks problem of the day -> 24th July 2025
//C++ CODE
class Solution {
  public:
    virtual int getLastMoment(int n, vector<int>& left, vector<int>& right){
      int ans=0;
      for(int &x: left) ans=max(ans, x-0);
      for(int &x: right) ans=max(ans, n-x);
      return ans;
    }
};