// Problem: Optimal File Merge
// geeksforgeeks problem of the day -> 29th October 2026
// JAVA CODE
import java.util.PriorityQueue;

class Solution {
    public int minComputation(int[] files) {
        int ans = 0;
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        
        for (int x : files) {
            minH.add(x);
        }
        
        while (minH.size() > 1) {
            int t1 = minH.poll();
            int t2 = minH.poll();
            ans += (t1 + t2);
            minH.add(t1 + t2);
        }
        
        return ans;
    }
}