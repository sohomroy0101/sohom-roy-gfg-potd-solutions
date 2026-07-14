// Problem: Smallest Non-Zero Number
// geeksforgeeks problem of the day -> 14th July 2026
// JAVA CODE
class Solution {
    public int find(int[] arr) {
      long need = 0; 
      for(int i=arr.length-1;i>=0;i--){
          need = (need + arr[i] + 1)/2;
      }
      return (int)need;
    }
}