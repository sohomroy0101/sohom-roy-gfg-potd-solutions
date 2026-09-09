// Problem: Max Digit Sum Number in 1 to n
// geeksforgeeks problem of the day -> 9th September 2026
// JAVA CODE
class Solution {
    public int findMax(int n) {
        long maxCandidate = n;
        long maxSum = getDigitSum(n);
        
        long multiplier = 1;
        long temp = n;
        
        // Traverse each digit from right to left
        while (temp > 0) {
            // Form a candidate by reducing the current digit area and appending '9's
            long currentCandidate = (temp - 1) * multiplier + (multiplier - 1);
            
            if (currentCandidate > 0) {
                long currentSum = getDigitSum(currentCandidate);
                
                // Prefer strictly greater digit sum, or larger candidate if sum is equal
                if (currentSum > maxSum || (currentSum == maxSum && currentCandidate > maxCandidate)) {
                    maxSum = currentSum;
                    maxCandidate = currentCandidate;
                }
            }
            
            temp /= 10;
            multiplier *= 10;
        }
        
        return (int) maxCandidate;
    }
    
    private long getDigitSum(long num) {
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}