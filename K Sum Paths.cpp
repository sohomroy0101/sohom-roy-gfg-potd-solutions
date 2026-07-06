//Problem: K Sum Paths
//geeksforgeeks problem of the day -> 16th March 2026
//C++ CODE
class Solution {
  public:
    void solve(Node *root, int k,int currSum,int &count,unordered_map<int,int>&mp){
        if(!root) return ;
        currSum+=root->data;
        if(currSum==k) count ++;
        if(mp.find(currSum-k) != mp.end()) count+=mp[currSum-k];
        mp[currSum]++;
        solve(root->left,k,currSum,count,mp);
        solve(root->right,k,currSum,count,mp);
        mp[currSum]--;
    }
    int sumK(Node *root, int k) {
        //CodeGenius
        unordered_map<int,int>mp;
        int count=0;
        solve(root,k,0,count,mp);
        return count;
    }
};