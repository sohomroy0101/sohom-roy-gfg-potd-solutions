//Problem:  Palindrome Binary
//geeksforgeeks problem of the day -> 4th May 2026
//JAVA CODE
class Solution {
    static long isPalindrome(long N){
        long original=N;
        long rev=0;
        while(N>0){
            rev=(rev<<1)|(N&1);
            N=N>>1;
        }
        return (rev==original)?1:0;
    }
}