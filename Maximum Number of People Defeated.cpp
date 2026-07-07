//Problem: Maximum Number of People Defeated
//geeksforgeeks problem of the day -> 23rd June 2026
//C++ CODE
class Solution {
  public:
    int maxPeopleDefeated(int p) {
        int low=1;
        int high=1000;
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            long long x=(mid*(mid+1)*(2*mid+1))/6;
            if(x>p)
            high=mid-1;
            else
            {
                ans=mid;
                low=mid+1;
            }
        }
        return ans;
    }
};