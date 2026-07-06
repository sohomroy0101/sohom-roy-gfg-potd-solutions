//Problem: Find Kth Rotation
//geeksforgeeks problem of the day -> 9th February 2026
//C++ CODE
class Solution {
  public:
    int findKRotation(vector<int> &arr) {
        int result=0,n=arr.size();
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                result=i+1;
                break;
            }
        }
        return result;
    }
};