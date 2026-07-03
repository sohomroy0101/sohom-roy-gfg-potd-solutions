//Problem: BST to greater sum tree
//geeksforgeeks problem of the day -> 17th October 2025
// C++ CODE
class Solution {
  public:
    int sum = 0;
    void transformTree(struct Node *root) {
        if(!root){
            return;
        }
        transformTree(root->right);
        int rootData = root->data;
        root->data = sum;
        sum += rootData;
        transformTree(root->left);
    }
};