//Problem: Remove BST keys outside given range
//geeksforgeeks problem of the day -> 16th October 2025
// C++ CODE
class Solution {
  public:
    Node* removekeys(Node* root, int l, int r) {
      if(!root)
        return NULL;
      root->left = removekeys(root->left, l, r);
      root->right = removekeys(root->right, l, r);
      int data = root->data;
      if(data < l)
        return root->right;
      if(data > r)
        return root->left;
      return root;          
    }
};