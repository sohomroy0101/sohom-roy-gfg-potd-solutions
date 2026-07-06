//Problem: Interleave the First Half of the Queue with Second Half
//geeksforgeeks problem of the day -> 30th January 2026
//C++ CODE
class Solution {
  public:
    void rearrangeQueue(queue<int> &q) {
        queue<int>temp;
        int n = q.size();
        int count = n/2;
        while(count--){
            temp.push(q.front());
            q.pop();
        }        
        while(!temp.empty()){
            q.push(temp.front());
            temp.pop();
            q.push(q.front());
            q.pop();
        }
    }
};