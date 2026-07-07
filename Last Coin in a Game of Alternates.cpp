//Problem: Last Coin in a Game of Alternates
//geeksforgeeks problem of the day -> 24th May 2026
//C++ CODE
class Solution {
  public:
    int coin(vector<int>& arr) {
        int s=0,e=arr.size()-1;
        while(s<e){
            if(arr[s]>arr[e]) s++;
            else e--;
        }
        return arr[s];
    }
};