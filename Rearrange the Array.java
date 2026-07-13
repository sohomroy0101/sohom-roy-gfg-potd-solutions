//Problem: Rearrange the Array
//geeksforgeeks problem of the day -> 13th May 2026
// JAVA CODE
class Solution {
    static final long MOD = 1000000007L;

    public int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n];
        long ans = 1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int len = 0;
                int curr = i;

                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = b[curr] - 1;
                    len++;
                }

                ans = lcm(ans, len);
            }
        }

        return (int)(ans % MOD);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return ((a / gcd(a, b)) % MOD * (b % MOD)) % MOD;
    }
}