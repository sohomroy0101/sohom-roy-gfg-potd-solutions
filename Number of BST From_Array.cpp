//Problem: Number of BST From Array
//geeksforgeeks problem of the day -> 21st March 2026
//C++ CODE
class Solution {
public:
    vector<int> countBSTs(vector<int>& arr) {
        int n = arr.size();
        const long long MOD = 1e9 + 7;
        vector<long long> dp(n + 1, 0);
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] = (dp[i] + dp[k - 1] * dp[i - k]) % MOD;
            }
        }
        unordered_map<int,int>mp;
        vector<int>temp=arr;
        sort(arr.begin(),arr.end());
        for(int i=0;i<n;i++){
            mp[arr[i]]=i;
        }
        vector<int> ans(n);
        for (int i = 0; i < n; i++) {
            int e=temp[i];
            int left = mp[e];          
            int right = n - mp[e] - 1;  
            ans[i] = (dp[left] * dp[right]) % MOD;
        }
        return ans;
    }
};