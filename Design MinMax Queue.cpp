//Problem: Design MinMax Queue
//geeksforgeeks problem of the day -> 24th September 2025
// C++ CODE
class SpecialQueue {
  public:
         queue<int>q;
          multiset<int> s; 
    void enqueue(int x) {
       q.push(x);
        s.insert(x);
    }
    void dequeue() {
        if (!q.empty()) {
            int y = q.front();
            q.pop();
            s.erase(s.find(y)); 
        }
    }
    int getFront() {
       if (!q.empty())
            return q.front();
        return -1;
    }
    int getMin() {
        if (!s.empty())
            return *s.begin();
        return -1;
    }
    int getMax() {
       if (!s.empty())
            return *s.rbegin();
        return -1;
    }
};