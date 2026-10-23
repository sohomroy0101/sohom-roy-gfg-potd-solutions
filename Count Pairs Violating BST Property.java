// Problem: Count Pairs Violating BST Property
// geeksforgeeks problem of the day -> 23rd October 2026
// JAVA CODE
import java.util.ArrayList;
import java.util.List;

/*
Definition for binary tree node:
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
    private void inorder(Node root, List<Integer> vals) {
        if (root == null) return;
        inorder(root.left, vals);
        vals.add(root.data);
        inorder(root.right, vals);
    }
    
    private long merge(List<Integer> arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int i = low, j = mid + 1;
        long inv = 0;
        
        while (i <= mid && j <= high) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i++));
            } else {
                inv += (mid - i + 1);
                temp.add(arr.get(j++));
            }
        }
        
        while (i <= mid) {
            temp.add(arr.get(i++));
        }
        while (j <= high) {
            temp.add(arr.get(j++));
        }
        
        for (int k = low; k <= high; k++) {
            arr.set(k, temp.get(k - low));
        }
        
        return inv;
    }
    
    private long mergeSort(List<Integer> arr, int low, int high) {
        long inv = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            inv += mergeSort(arr, low, mid);
            inv += mergeSort(arr, mid + 1, high);
            inv += merge(arr, low, mid, high);
        }
        return inv;
    }
    
    public int pairsViolatingBST(Node root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        return (int) mergeSort(vals, 0, vals.size() - 1);
    }
}