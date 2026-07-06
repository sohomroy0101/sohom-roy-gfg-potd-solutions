//Problem: Josephus problem
//geeksforgeeks problem of the day -> 24th January 2026
//C++ CODE
class Solution {
  public:
    int josephus(int n, int k) {
        queue<int>q;
        for(int i=1;i<=n;i++){
            q.push(i);
        }
        int size=k,front;
        while(q.size()>1){
            while(size>1){
                front=q.front();
                q.pop();
                q.push(front);
                size--;
            }
            size=k;
            q.pop();
        }
        return q.front();
    }
};