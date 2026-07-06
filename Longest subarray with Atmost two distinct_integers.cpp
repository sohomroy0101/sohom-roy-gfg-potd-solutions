//Problem: Longest subarray with Atmost two distinct integers
//geeksforgeeks problem of the day -> 3rd March 2026
//C++ CODE
class Solution {
  public:
    int totalElements(vector<int> &arr) {
        int n=arr.size();
        int maxi=0;
        int i=0,j=0;
        map<int,int>mp;
        while(j<n){
            mp[arr[j]]++;
            while(mp.size()>2){
                mp[arr[i]]--;
                if(mp[arr[i]]==0) mp.erase(arr[i]);
                i++;
            }
            if(mp.size()<=2){
                maxi=max(maxi,j-i+1);
            }
            j++;
        }
        return maxi;
    }
};