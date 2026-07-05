//Problem: Sort in specific order
//geeksforgeeks problem of the day -> 18th December 2025
// C++ CODE
class Solution {
  public:
    static bool cmp(int &a, int &b){
        if(a%2!=0 and b%2!=0){
            return a>b;
        }
        if(a%2!=0 and b%2==0){
            return true;
        }
        if(a%2==0 and b%2!=0){
            return false;
        }
        return a<b;
    }
    void sortIt(vector<int>& arr) {
        sort(arr.begin(), arr.end(), cmp);
    }
};