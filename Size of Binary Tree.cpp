//Problem: Size of Binary Tree
//geeksforgeeks problem of the day -> 6th May 2026
//C++ CODE
class Solution {
  public:
    virtual int getSize(Node* root){
      if(!root) return 0;
      return 1+getSize(root->left)+getSize(root->right);
    }
};