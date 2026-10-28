// Problem: Nth in Concatenated Decimal String
// geeksforgeeks problem of the day -> 28th October 2026
// JAVA CODE
class Solution {
    public char nthCharacter(int n) {
        long length = 1;
        long count = 9;
        long start = 1;
        
        while ((long) n > length * count) {
            n -= (int) (length * count);
            length++;
            count *= 10;
            start *= 10;
        }
        
        long targetNumber = start + (n - 1) / length;
        String numberStr = Long.toString(targetNumber);
        int digitIndex = (int) ((n - 1) % length);
        
        return numberStr.charAt(digitIndex);
    }
}