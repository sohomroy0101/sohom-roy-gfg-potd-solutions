// Problem: Pairs with Less Than K Diff
// geeksforgeeks problem of the day -> 4th August 2026
// C++ CODE

class Solution {
  public:
    int countPairs(vector<int>& arr, int k) {
        int cnt=0;
        int i=0,j=1;
        sort(arr.begin(),arr.end());
        while(j<arr.size()){
            while(arr[j]-arr[i]>=k){
                i++;
            }
            if(arr[j]-arr[i]<k){
                cnt+=(j-i);
            }
            j++;
        }
        return cnt;
    }
};