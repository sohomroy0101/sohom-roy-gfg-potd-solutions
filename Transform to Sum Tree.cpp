//Problem: Transform to Sum Tree
//geeksforgeeks problem of the day -> 23rd May 2026
//C++ CODE
class Solution {
public:
    int sum = 0;
    int solve(Node* node){
        if(node == NULL){
            return 0;
        }
        int a = solve(node->left);
        int b = solve(node->right);
        int c = node->data;
        node->data = a+b;
        return a+b+c;
    }
    void toSumTree(Node *node){
        solve(node);
    }
};