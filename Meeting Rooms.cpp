//Problem: Meeting Rooms
//geeksforgeeks problem of the day -> 16th February 2026
//C++ CODE
class Solution {
  public:
    bool canAttend(vector<vector<int>> &arr) {
        sort(arr.begin(),arr.end(),[](vector<int>&a,vector<int>&b){
            return a[1]<b[1];
        });
        for(int i=0;i<arr.size()-1;i++){
            if(arr[i][1]>arr[i+1][0]){
                return false;
            }
        }
        return true;
    }
};