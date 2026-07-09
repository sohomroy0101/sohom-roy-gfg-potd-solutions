//Problem: Count Pairs Divisible By K
//geeksforgeeks problem of the day -> 9th July 2026
//C++ CODE
class Solution {
  public:
    int countKdivPairs(vector<int>& arr, int k) {
        //CodeGenius
        unordered_map<int , int> mp;
        int ans=0;
        for(int i : arr){
            int rem = i%k;
            ans+=mp[rem];
            mp[(k-rem)%k]++;
        }
        return ans;
    }
};