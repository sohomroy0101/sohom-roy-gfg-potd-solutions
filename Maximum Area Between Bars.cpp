//Problem: Maximum Area Between Bars
//geeksforgeeks problem of the day -> 22nd June 2026
//C++ CODE
class Solution {
public:
    int maxArea(vector<int> &height) {
        int n = height.size();
        int i = 0, j = n - 1;
        long long ans = 0;
        while (i < j) {
            long long width = j - i - 1;
            long long area = 1LL * min(height[i], height[j]) * width;
            ans = max(ans, area);
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return (int)ans;
    }
};