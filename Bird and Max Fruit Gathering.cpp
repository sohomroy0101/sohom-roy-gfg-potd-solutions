// Problem: Bird and Max Fruit Gathering
// geeksforgeeks problem of the day -> 4th September 2026
// C++ CODE
class Solution {
  public:
    int maxFruits(vector<int>& arr, int m) {
        int ans = 0, n = arr.size();
        int temp = 0;
        for(int i=0; i<(n+m); i++) {
            if(i < m) {
                ans += arr[i];
                temp = ans;
            } else {
                temp += arr[i % n];
                temp -= arr[(i-m) % n];
                ans = max(ans, temp);
            }
        }
        return ans;
    }
};