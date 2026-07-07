//Problem: Last Digit of a^b
//geeksforgeeks problem of the day -> 20th June 2026
//C++ CODE
class Solution {
  public:
    int getLastDigit(string& a, string& b) {
        if (b == "0") {
            return 1;
        }
        int base = a.back() - '0';
        int exp_mod_4 = 0;
        for (char c : b) {
            exp_mod_4 = (exp_mod_4 * 10 + (c - '0')) % 4;
        }
        if (exp_mod_4 == 0) {
            exp_mod_4 = 4;
        }
        int result = 1;
        for (int i = 0; i < exp_mod_4; i++) {
            result = (result * base) % 10;
        }
        return result;
    }
};