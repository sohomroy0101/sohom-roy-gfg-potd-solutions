// Problem: Trace Path
// geeksforgeeks problem of the day -> 24th October 2026
// JAVA CODE
class Solution {
    public boolean isPossible(int n, int m, String s) {
        int lmn = 0, rmn = 0, rmx = 0, lmx = 0;
        int x = 0, y = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'U':
                    x++;
                    lmx = Math.max(lmx, x);
                    break;
                case 'D':
                    x--;
                    lmn = Math.min(lmn, x);
                    break;
                case 'L':
                    y--;
                    rmn = Math.min(rmn, y);
                    break;
                case 'R':
                    y++;
                    rmx = Math.max(rmx, y);
                    break;
                default:
                    break;
            }
        }
        
        lmx -= lmn;
        rmx -= rmn;
        
        return lmx < n && rmx < m;
    }
}