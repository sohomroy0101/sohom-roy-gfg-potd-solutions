// Problem: Subsets with MEX in Range
// geeksforgeeks problem of the day -> 30th October 2026
// JAVA CODE
class Solution {
    private long modpow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }

    public int cntSubsets(int[] arr, int l, int r) {
        long MOD = 1000000007;
        int n = arr.length;
        
        int[] freq = new int[n + 1];
        for (int x : arr) {
            if (x <= n) {
                freq[x]++;
            }
        }
        
        long[] p2 = new long[n + 1];
        p2[0] = 1;
        for (int i = 1; i <= n; i++) {
            p2[i] = p2[i - 1] * 2 % MOD;
        }
        
        long ans = 0, curProd = 1, cum = 0;
        for (int k = 0; k <= r; k++) {
            if (k > 0) {
                if (freq[k - 1] == 0) {
                    curProd = 0;
                } else {
                    curProd = curProd * (p2[freq[k - 1]] - 1 + MOD) % MOD;
                }
            }
            
            cum += freq[k];
            
            if (curProd != 0) {
                long free = p2[n] * modpow(p2[(int) cum], MOD - 2, MOD) % MOD;
                long ways = curProd * free % MOD;
                if (k >= l) {
                    ans = (ans + ways) % MOD;
                }
            }
        }
        
        return (int) ans;
    }
}