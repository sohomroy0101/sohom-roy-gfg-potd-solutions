// Problem: Construct a Full Binary Tree
// geeksforgeeks problem of the day -> 27th July 2026
// JAVA CODE

/*class Node
{
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}*/

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int index = 0;

    Node build(int[] pre, int left, int right) {
        if (left > right) {
            return null;
        }

        int val = pre[index++];
        Node root = new Node(val);

        if (left == right) {
            return root;
        }

        int pos = map.get(pre[index]);

        root.left = build(pre, pos, right);
        root.right = build(pre, left + 1, pos - 1);

        return root;
    }

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, 0, pre.length - 1);
    }
}