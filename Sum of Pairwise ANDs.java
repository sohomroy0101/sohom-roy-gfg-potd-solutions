// Problem: Sum of Pairwise ANDs 
// geeksforgeeks problem of the day -> 6th September 2026
// JAVA CODE
class Solution {
    public long pairAndSum(int[] arr) {
        long ans = 0;
        
        for(int bit=0;bit<=30;bit++){
            long count = 0;
            long bitValue = 1L << bit;
            
            for(int num:arr){
                if((bitValue & num) != 0){
                    count++;
                }
            }
            long pairCount = count*(count-1)/2;
            ans = ans + pairCount * bitValue;
        }
        return ans;
    }
}