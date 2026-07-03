//Problem: Distribute Candies 
//geeksforgeeks problem of the day -> 12th October 2025
// C++ CODE
class Solution {
  public:
    
    int solve(Node* root,int &ans)
    {
        if(root==NULL)
        {
            return 0;
        }
        int left=solve(root->left,ans);
        int right=solve(root->right,ans);
        ans+=abs(left)+abs(right);
        return (left+right+root->data)-1;
    }
    
    int distCandy(Node* root) {
        // code here
        int ans=0;
        solve(root,ans);
        return ans;
    }
};