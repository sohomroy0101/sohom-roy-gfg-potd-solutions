//Problem: Shop in Candy Store
//geeksforgeeks problem of the day -> 12th August 2025
// C++ CODE
class Solution {
  public:
    vector<int> minMaxCandy(vector<int>& prices, int k) {
        int mn=0, mx=0;
        sort(prices.begin(), prices.end());
        int l=0, r=prices.size()-1;
        while(l<=r){
            mn+=prices[l];
            r-=k;
            l++;
        }
        l=0, r=prices.size()-1;
        while(l<=r){
            mx+=prices[r];
            l+=k;
            r--;
        }
        return {mn, mx};
    }
};