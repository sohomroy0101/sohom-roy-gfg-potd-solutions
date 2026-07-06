//Problem: Check if an Array is Max Heap
//geeksforgeeks problem of the day -> 30th April 2026
//C++ CODE

class Solution {
  public:
    bool isMaxHeap(vector<int>& arr) {
        int n = arr.size();
        for (int i = 0; i <= (n/2) - 1; i++) {
            if (arr[i] < arr[2*i + 1])
                return false;
            if ((2*i + 2 < n) && arr[i] < arr[2*i + 2])
                return false;
        }
        return true;
    }
};