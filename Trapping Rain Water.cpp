//Problem: Trapping Rain Water
//geeksforgeeks problem of the day -> 2nd March 2026
//C++ CODE
class Solution {
  public:
    int maxWater(vector<int> &arr) {
        int totalWater=0;
        int lmax=0,rmax=0;
        int i=0,j=arr.size()-1;
        while(i<j){
            lmax=max(lmax,arr[i]);
            rmax=max(rmax,arr[j]);
            if(arr[i]<=arr[j]){
                totalWater+=lmax-arr[i];
                i++;
            }
            else{
                totalWater+=rmax-arr[j];
                j--;
            }
        }
        return totalWater;
    }
};