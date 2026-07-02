//Problem: Reverse a Doubly Linked List
//geeksforgeeks problem of the day -> 3rd September 2025
// C++ CODE
class Solution {
  public:
   Node* revLogic(Node* head){
       Node* p = NULL;
       Node* c = head;
       Node* n = head;
       while(n){
           n = n->next;
           c->next = p;
           c->prev = n;
           p = c;
           c = n;
       }
       return p;
   }
    Node *reverse(Node *head) {
        return revLogic(head);
    }
};