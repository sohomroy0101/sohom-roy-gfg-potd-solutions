// Problem: Subset Sum on Generated Sequence
// geeksforgeeks problem of the day -> 14th August 2026
// JAVA CODE
class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) {
            return true;
        }

        int n = arr.length;

        // Generate only those numbers that are <= x.
        long[] seq = new long[n + 1];
        int size = 0;

        long sum = s;

        // Initial number
        if (sum <= x) {
            seq[size++] = sum;
        }

        for (int i = 0; i < n; i++) {
            long next = sum + arr[i];

            // All future numbers will be even larger.
            if (next > x) {
                break;
            }

            seq[size++] = next;
            sum += next;
        }

        // Greedily form x from the largest number.
        long target = x;

        for (int i = size - 1; i >= 0; i--) {
            if (seq[i] <= target) {
                target -= seq[i];

                if (target == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}