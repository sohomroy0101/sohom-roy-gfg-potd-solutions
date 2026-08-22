// Problem: Number of Turns in Binary Tree
// geeksforgeeks problem of the day -> 22nd August 2026
// JAVA CODE

class Solution {

    static Node findLCA(Node root, int p, int q) {
        if (root == null) {
            return null;
        }

        if (root.data == p || root.data == q) {
            return root;
        }

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    static boolean findPath(Node root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        // Try left
        path.append('L');

        if (findPath(root.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        // Try right
        path.append('R');

        if (findPath(root.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        return false;
    }

    // GFG expects this exact method name
    public int numberOfTurns(Node root, int first, int second) {

        if (root == null || first == second) {
            return -1;
        }

        Node lca = findLCA(root, first, second);

        if (lca == null) {
            return -1;
        }

        StringBuilder pathFirst = new StringBuilder();
        StringBuilder pathSecond = new StringBuilder();

        if (!findPath(lca, first, pathFirst) ||
            !findPath(lca, second, pathSecond)) {
            return -1;
        }

        // Travel from first -> LCA
        pathFirst.reverse();

        // Complete direction path: first -> LCA -> second
        String path = pathFirst.toString() + pathSecond.toString();

        int turns = 0;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != path.charAt(i - 1)) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }
}