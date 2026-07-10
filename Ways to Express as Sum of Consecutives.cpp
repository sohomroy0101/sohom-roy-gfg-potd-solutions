//Problem: Ways to Express as Sum of Consecutives
//geeksforgeeks problem of the day -> 10th July 2026
// C++ CODE
class Solution {
public:
    int getCount(int n) {
        int j=0;
        int k=0,i=1;
        while(n>0){
            n=n-i;
            if(n%i==0) k++;
            i++;
        }
        return k-1;
    }
};