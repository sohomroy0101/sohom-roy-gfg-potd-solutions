//Problem: Count Pairs Divisible By K
//geeksforgeeks problem of the day -> 9th July 2026
//JAVA CODE
class Solution {
    public int countKdivPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int num : arr) {
            int rem = num % k;
            ans += map.getOrDefault(rem, 0);
            map.put((k - rem) % k, map.getOrDefault((k - rem) % k, 0) + 1);
        }

        return ans;
    }
}