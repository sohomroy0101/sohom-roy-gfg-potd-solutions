//Problem: Sum of Subarrays
//geeksforgeeks problem of the day -> 23rd July 2025
//C++ CODE
class Solution {
  public:
    int subarraySum(vector<int>& arr) {
        int sum = 0,n = arr.size();
        for(int i = 0;i<n;i++){
            sum+=(i+1)*(n-i)*arr[i];
        }
        return sum;
    }
};