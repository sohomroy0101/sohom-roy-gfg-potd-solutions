//Problem: BST with Dead End
//geeksforgeeks problem of the day -> 9th June 2025

//C++ code
class Solution {
  public:
    bool fun(Node* root, int mini, int maxi){
        if(!root)
            return false;
        if((root->data == mini) && (mini == maxi))
            return true;
        int rd = root->data;
        return (fun(root->left, mini, rd-1) || fun(root->right, rd+1, maxi));
    }
    bool isDeadEnd(Node *root) {
        return fun(root, 1, 1000000);
    }
};