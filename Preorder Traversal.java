// Problem: Preorder Traversal
// geeksforgeeks problem of the day -> 23rd July 2026
// JAVA CODE
class Solution {

    ArrayList<Integer> ans = new ArrayList<>();

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        ans.add(root.data);
        dfs(root.left);
        dfs(root.right);
    }

    public ArrayList<Integer> preOrder(Node root) {
        ans.clear();
        dfs(root);
        return ans;
    }
}