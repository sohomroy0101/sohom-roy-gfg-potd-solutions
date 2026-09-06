// Problem: Sum of Pairwise ANDs 
// geeksforgeeks problem of the day -> 6th September 2026
// C++ CODE
class Solution {
  public:
    virtual long long nc2(int n){
      return (1LL*n*(n-1))/2LL;    
    }
    virtual long long pairAndSum(vector<int> &arr){
      long long ans=0LL;
      for(int i=0; i<32; i++){
        int count=0;
        for(int x: arr){
          if((x>>i)&1) count++;       
        }
        if(count>1) ans+=((1<<i)*nc2(count));
      }
      return ans;
    }
};