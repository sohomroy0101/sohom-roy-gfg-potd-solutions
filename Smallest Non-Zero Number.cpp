// Problem: Smallest Non-Zero Number
// geeksforgeeks problem of the day -> 14th July 2026
// C++ CODE
class Solution {
  public:   
    int find(vector<int>& arr) {
       int curr = 0;
       for(int i = arr.size()-1 ; i>=0 ; i--){
           curr+= arr[i];
           curr = (curr+1)/2;
       }
       return curr;
    }
};