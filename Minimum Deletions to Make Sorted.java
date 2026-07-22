// Problem: Minimum Deletions to Make Sorted
// geeksforgeeks problem of the day -> 22nd July 2026
// JAVA CODE
import java.util.*;

class Solution {
    public int minDeletions(int[] arr) {
        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : arr) {
            int idx = lowerBound(lis, x);

            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }

        return arr.length - lis.size();
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}