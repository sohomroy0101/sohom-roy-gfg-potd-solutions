// Problem: Minimum Absolute Difference In BST
// geeksforgeeks problem of the day -> 18th September 2026
// JAVA CODE
/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int minDiff;
    private Integer prev;

    public int absDiff(Node root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        
        inorder(root);
        
        return minDiff;
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        // Process left subtree
        inorder(node.left);

        // Process current node
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.data - prev));
        }
        prev = node.data;

        // Process right subtree
        inorder(node.right);
    }
}