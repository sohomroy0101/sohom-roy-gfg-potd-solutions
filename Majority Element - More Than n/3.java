//Problem: Majority Element - More Than n/3
//geeksforgeeks problem of the day -> 26th July 2025
//JAVA CODE
import java.util.*;

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int candidate1 = 0, candidate2 = 1;
        int count1 = 0, count2 = 0;

        // Find potential candidates
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify the candidates
        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int limit = arr.length / 3;

        if (count1 > limit)
            ans.add(candidate1);

        if (count2 > limit)
            ans.add(candidate2);

        Collections.sort(ans);
        return ans;
    }
}