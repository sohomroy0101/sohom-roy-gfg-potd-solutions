// Problem: Maximum Reachable Index Difference
// geeksforgeeks problem of the day -> 21st July 2026
// JAVA CODE
import java.util.*;

class Solution {
    public int maxIndexDifference(String s) {
        ArrayList<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        if (pos[0].isEmpty()) {
            return -1;
        }

        int start = pos[0].get(0);
        int cur = start;
        int ans = 0;

        for (int ch = 1; ch < 26; ch++) {
            if (pos[ch].isEmpty()) {
                break;
            }

            int idx = lowerBound(pos[ch], cur);
            if (idx == pos[ch].size()) {
                break;
            }

            int last = pos[ch].get(pos[ch].size() - 1);
            ans = Math.max(ans, last - start);

            cur = pos[ch].get(idx);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}