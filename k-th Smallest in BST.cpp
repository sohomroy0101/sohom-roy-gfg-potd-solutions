//Problem: k-th Smallest in BST 
//geeksforgeeks problem of the day -> 15th October 2025
// C++ CODE
class Solution {
  public:
    void inorder(Node*root,vector<int>&ans){
        if(!root)return;
        ans.push_back(root->data);
        if(root->left)inorder(root->left,ans);
        if(root->right)inorder(root->right,ans);
    }
    int kthSmallest(Node *root, int k) {
        vector<int>ans;
        inorder(root,ans);
        sort(ans.begin(),ans.end());
        if(ans.size()<k)return -1;
        int i=0;
        int num;
        while(k--){
            num=ans[i];
            i++;
        }
        return  num;
    }
};