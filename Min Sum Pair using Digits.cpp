//Problem: Min Sum Pair using Digits
//geeksforgeeks problem of the day -> 23rd June 2025

//C++ code
class Solution {
public:
    string addStrings(string &a, string &b) {
        int i = a.size() - 1;
        int j = b.size() - 1;
        int carry = 0;
        string res = "";

        while (i >= 0 || j >= 0 || carry) {
            int sum = carry;

            if (i >= 0) sum += a[i--] - '0';
            if (j >= 0) sum += b[j--] - '0';

            res.push_back((sum % 10) + '0');
            carry = sum / 10;
        }

        reverse(res.begin(), res.end());

        int k = 0;
        while (k < res.size() - 1 && res[k] == '0')
            k++;

        return res.substr(k);
    }

    string minSum(vector<int> &arr) {
        sort(arr.begin(), arr.end());

        string num1 = "", num2 = "";

        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0)
                num1.push_back(arr[i] + '0');
            else
                num2.push_back(arr[i] + '0');
        }

        return addStrings(num1, num2);
    }
};