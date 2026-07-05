//Problem: Sort 0s, 1s and 2s
//geeksforgeeks problem of the day -> 2nd January 2026
// C++ CODE
class Solution {
  public:
    virtual void sort012(vector<int>& arr){
      int count[3];
      memset(count, 0, sizeof(count));
      for(int &x: arr) count[x]++;
      int l=0;
      for(int i=0; i<3; i++){
        while(count[i] > 0) {arr[l] = i; l++; count[i]--;}     
      }
      return;
    }
};