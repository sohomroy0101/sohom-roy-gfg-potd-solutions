// Problem: Longest Subsequence with Adjacent Diff as 1
// geeksforgeeks problem of the day -> 5th September 2026
// JAVA CODE
class Solution {
    public int longestSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int x: arr){
            int best = Math.max(
                map.getOrDefault(x-1, 0),
                map.getOrDefault(x+1, 0)
                );
            map.put(x, best+1);
            
            ans = Math.max(ans, map.get(x));
        }
        return ans;
    }
}