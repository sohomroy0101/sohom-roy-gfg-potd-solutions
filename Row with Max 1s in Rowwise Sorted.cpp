//Problem: Row with Max 1s in Rowwise Sorted 
//geeksforgeeks problem of the day -> 22nd December 2025
// C++ CODE
class Solution {
  public:
    int rowWithMax1s(vector<vector<int>> &arr) {
        // code here
        int i=0,j=arr[0].size()-1,ans=-1;
        while(i<arr.size() and j>=0){
            if(!arr[i][j]){
                i++;
            }
            else{
                ans=i;
                j--;
            }
        }
        return ans;
    }
};