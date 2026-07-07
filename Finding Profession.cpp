//Problem: Finding Profession
//geeksforgeeks problem of the day -> 7th June 2026
//C++ CODE
class Solution {
  public:
    string profession(int level, int pos) {
        int flips = __builtin_popcount(pos - 1);
        return (flips & 1) ? "Doctor" : "Engineer";
    }
};