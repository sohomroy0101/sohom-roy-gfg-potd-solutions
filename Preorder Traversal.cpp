// Problem: Preorder Traversal
// geeksforgeeks problem of the day -> 23rd July 2026
// C++ CODE
class Solution {
public:
    vector<int> ans;

    void dfs(Node* root) {
        if (root == nullptr) {
            return;
        }

        ans.push_back(root->data);
        dfs(root->left);
        dfs(root->right);
    }

    vector<int> preOrder(Node* root) {
        ans.clear();
        dfs(root);
        return ans;
    }
};