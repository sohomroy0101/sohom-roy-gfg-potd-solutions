//Problem: Duplicates in a Limited Range Array
//geeksforgeeks problem of the day -> 9th December 2025
// C++ CODE
class Solution {
public:
    vector<int> findDuplicates(vector<int>& arr) {
        vector<int> ans;

        for (int i = 0; i < arr.size(); i++) {
            int x = abs(arr[i]);

            if (arr[x - 1] < 0)
                ans.push_back(x);
            else
                arr[x - 1] = -arr[x - 1];
        }

        return ans;
    }
};