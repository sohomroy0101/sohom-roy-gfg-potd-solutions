// Problem: Subsets with Products of Distinct Primes
// geeksforgeeks problem of the day -> 31st July 2026
// JAVA CODE
class Solution {
    static final int MOD = 1000000007;

    public int countSubsets(int[] arr) {

        int[] cnt = new int[31];
        for (int x : arr) cnt[x]++;

        int[] primes = {2,3,5,7,11,13,17,19,23,29};
        int[] mask = new int[31];

        for (int x = 2; x <= 30; x++) {
            int cur = x;
            int bits = 0;
            boolean ok = true;

            for (int i = 0; i < 10; i++) {
                int c = 0;
                while (cur % primes[i] == 0) {
                    cur /= primes[i];
                    c++;
                }
                if (c > 1) {
                    ok = false;
                    break;
                }
                if (c == 1) bits |= (1 << i);
            }

            mask[x] = ok ? bits : -1;
        }

        long[] dp = new long[1024];
        dp[0] = 1;

        for (int val = 2; val <= 30; val++) {

            if (cnt[val] == 0 || mask[val] == -1) continue;

            int curMask = mask[val];

            for (int state = 1023; state >= 0; state--) {
                if (dp[state] == 0) continue;
                if ((state & curMask) != 0) continue;

                dp[state | curMask] =
                    (dp[state | curMask] + dp[state] * cnt[val]) % MOD;
            }
        }

        long ans = 0;
        for (long x : dp)
            ans = (ans + x) % MOD;

        ans = (ans - 1 + MOD) % MOD;

        long pow = 1;
        for (int i = 0; i < cnt[1]; i++)
            pow = (pow * 2) % MOD;

        return (int)((ans * pow) % MOD);
    }
}