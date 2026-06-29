//Problem: Lexicographically Largest String After K Deletions
//geeksforgeeks problem of the day -> 24th June 2025

//JAVA CODE
class Solution {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int toRemove = k;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (res.length() > 0 && toRemove > 0 &&
                   res.charAt(res.length() - 1) < s.charAt(i)) {
                res.deleteCharAt(res.length() - 1);
                toRemove--;
            }
            res.append(s.charAt(i));
        }
        return res.substring(0, n - k);
    }
}