//Problem: Buildings with Sunlight
//geeksforgeeks problem of the day -> 24th April 2026
//C++ CODE
class Solution {
  public:
    int visibleBuildings(vector<int>& arr) {
        int result=1;
        int val=arr[0];
        for(int i=1;i<arr.size();i++){
            if(arr[i]>=val){
                result++;
                val=arr[i];
            }
        }
        return result;
    }
};