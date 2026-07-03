//Problem: Postorder Traversal 
//geeksforgeeks problem of the day -> 9th October 2025
// C++ CODE
class Solution {
  public:
    void fun(Node* root, vector<int> &ans){
        if(!root)
          return;
        fun(root->left, ans);  
        fun(root->right, ans);
        ans.push_back(root->data);
        return;
    }
    vector<int> postOrder(Node* root) {
        vector<int> ans;
        fun(root, ans);
        return ans;
    }
};