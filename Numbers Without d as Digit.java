// Problem: Numbers Without d as Digit
// geeksforgeeks problem of the day -> 15th August 2026

// HAPPY 80th INDEPENDENCE DAY.....JAI HIND...JAI BHARAT....VANDE MATARAM....BHARAT MATA KI JAI....JAI SHRI RAM....JAI SHRI KRISHNA....JAI SHRI HANUMAN....HAR HAR MAHADEV....JAI SHRI RAM....JAI SHRI KRISHNA....JAI SHRI HANUMAN....HAR HAR MAHADEV....JAI HIND...JAI BHARAT....VANDE MATARAM....BHARAT MATA KI JAI....JAI SHRI RAM....JAI SHRI KRISHNA....JAI SHRI HANUMAN....HAR HAR MAHADEV....JAI SHRI RAM....JAI SHRI KRISHNA....JAI SHRI HANUMAN....HAR HAR MAHADEV....

// JAVA CODE
class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) {
            return 0;
        }

        String s = String.valueOf(n);
        int len = s.length();

        // dp[pos][tight][started]
        long[][][] dp = new long[len + 1][2][2];

        dp[0][1][0] = 1;

        for (int pos = 0; pos < len; pos++) {
            int currentDigit = s.charAt(pos) - '0';

            for (int tight = 0; tight <= 1; tight++) {
                for (int started = 0; started <= 1; started++) {

                    long ways = dp[pos][tight][started];

                    if (ways == 0) {
                        continue;
                    }

                    int limit = (tight == 1) ? currentDigit : 9;

                    for (int digit = 0; digit <= limit; digit++) {

                        /*
                         * Reject digit d if it is an actual digit
                         * of the number.
                         *
                         * Leading zero is NOT an actual digit.
                         */
                        if (digit == d && (started == 1 || digit != 0)) {
                            continue;
                        }

                        int nextStarted =
                                (started == 1 || digit != 0) ? 1 : 0;

                        int nextTight =
                                (tight == 1 && digit == currentDigit) ? 1 : 0;

                        dp[pos + 1][nextTight][nextStarted] += ways;
                    }
                }
            }
        }

        // Exclude 0 by requiring started == 1
        return (int) (dp[len][0][1] + dp[len][1][1]);
    }
}