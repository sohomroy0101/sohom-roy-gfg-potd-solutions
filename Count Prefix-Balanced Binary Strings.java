// Problem: Count Prefix-Balanced Binary Strings
// geeksforgeeks problem of the day -> 24th August 2026
// JAVA CODE
class Solution {

    static final long MOD = 1000000007L;

    // Fast exponentiation
    long power(long base, long exp, long mod) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    int prefixStrings(int n) {

        long factN = 1;
        long fact2N = 1;

        // Calculate n! and (2n)!
        for (int i = 1; i <= 2 * n; i++) {
            fact2N = (fact2N * i) % MOD;

            if (i <= n) {
                factN = (factN * i) % MOD;
            }
        }

        // Modular inverse of n!
        long inverseFactN = power(factN, MOD - 2, MOD);

        // Modular inverse of (n + 1)
        long inverseNPlusOne = power(n + 1, MOD - 2, MOD);

        // Catalan number:
        // (2n)! / (n! * n! * (n + 1))
        long answer = fact2N;

        answer = (answer * inverseFactN) % MOD;
        answer = (answer * inverseFactN) % MOD;
        answer = (answer * inverseNPlusOne) % MOD;

        return (int) answer;
    }
}