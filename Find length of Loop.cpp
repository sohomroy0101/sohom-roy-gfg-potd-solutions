//Problem: Find length of Loop
//geeksforgeeks problem of the day -> 6th September 2025
// C++ CODE
class Solution {
  public:
    int lengthOfLoop(Node *head) {
        unordered_map<Node*,int>mp;
        Node* c=head;
        int i=1;
        while(c){
            if(mp.find(c->next)!=mp.end()){
                return i-mp[c->next]+1;
            }
            else{
                mp[c]=i;
            }
            c=c->next;
            i++;
        }
        return 0;
    }
};