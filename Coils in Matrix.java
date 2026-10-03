// Problem: Coils in Matrix
// geeksforgeeks problem of the day -> 3rd October 2026
// JAVA CODE
import java.util.ArrayList;

class Solution {

    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int m = 8 * n * n;
        int total = 16 * n * n;

        int[] base = new int[m];
        base[0] = 8 * n * n + 2 * n;

        int curr = base[0];
        int flag = 1;
        int step = 2;
        int idx = 1;

        while (idx < m) {
            // Move vertically
            for (int i = 0; i < step && idx < m; i++) {
                curr -= 4 * n * flag;
                base[idx++] = curr;
            }
            if (idx >= m) break;

            // Move horizontally
            for (int i = 0; i < step && idx < m; i++) {
                curr += flag;
                base[idx++] = curr;
            }

            flag = -flag;
            step += 2;
        }

        // Coil 2 is the reversed base coil
        ArrayList<Integer> coil2 = new ArrayList<>(m);
        for (int i = m - 1; i >= 0; i--) {
            coil2.add(base[i]);
        }

        // Coil 1 elements are symmetric: total + 1 - coil2[i]
        ArrayList<Integer> coil1 = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            coil1.add(total + 1 - coil2.get(i));
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(coil1);
        res.add(coil2);

        return res;
    }
}