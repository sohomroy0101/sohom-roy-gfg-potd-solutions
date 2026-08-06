// Problem: Minimum Increment or Double Operations to Convert
// geeksforgeeks problem of the day -> 6th August 2026
// JAVA CODE
class Solution {
    public int countMinOperations(int arr[]) {
        int decrementCount = 0;
        int maxDivideCount = 0;
        
        for(int num:arr){
            int divideCount = 0;
            
            while(num > 0){
                if(num % 2 == 1){
                    decrementCount++;
                    num--;
                }else{
                    divideCount++;
                    num/= 2;
                }
            }
            maxDivideCount = Math.max(maxDivideCount, divideCount);
        }
        return decrementCount + maxDivideCount;
    }
}