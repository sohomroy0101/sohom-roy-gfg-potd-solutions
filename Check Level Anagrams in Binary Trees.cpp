// Problem: Check Level Anagrams in Binary Trees
// geeksforgeeks problem of the day -> 21st September 2026
// C++ CODE
class Solution {
  public:
    bool areAnagrams(Node* root1, Node* root2) {
        unordered_map<int, int> xorMap;
        function<void(Node*, int)> dfs = [&](Node* node, int level){
            if(!node) return;
            xorMap[level] ^= node->data;
            dfs(node->left, level + 1);
            dfs(node->right, level + 1);
        };
        dfs(root1, 0);
        dfs(root2, 0);
        for(auto& pr : xorMap){
            if(pr.second != 0) return false;
        }
        return true;
    }
};