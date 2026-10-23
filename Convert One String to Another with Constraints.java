// Problem: Convert One String to Another with Constraints
// geeksforgeeks problem of the day -> 17th October 2026
// JAVA CODE
class Solution {
    public boolean isItPossible(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int n = s1.length();
        int i = 0, j = 0;
        
        while (i < n && j < n) {
            // Skip '#' in s1
            while (i < n && s1.charAt(i) == '#') {
                i++;
            }
            // Skip '#' in s2
            while (j < n && s2.charAt(j) == '#') {
                j++;
            }
            
            // If one of the strings is exhausted
            if (i == n || j == n) {
                break;
            }
            
            // Characters must match
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            
            // 'A' can only move left (i >= j)
            if (s1.charAt(i) == 'A' && i < j) {
                return false;
            }
            
            // 'B' can only move right (i <= j)
            if (s1.charAt(i) == 'B' && i > j) {
                return false;
            }
            
            i++;
            j++;
        }
        
        // Skip remaining trailing '#' in s1
        while (i < n && s1.charAt(i) == '#') {
            i++;
        }
        // Skip remaining trailing '#' in s2
        while (j < n && s2.charAt(j) == '#') {
            j++;
        }
        
        return i == n && j == n;
    }
}