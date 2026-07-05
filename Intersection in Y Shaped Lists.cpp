//Problem: Intersection in Y Shaped Lists
//geeksforgeeks problem of the day -> 1st January 2026
//First day of the year 2026

// C++ CODE
class Solution {
  public:
    Node* intersectPoint(Node* head1, Node* head2) {
        Node *tempA = head1; 
        Node *tempB = head2; 
        while(tempA != tempB){
            if(tempA == nullptr){
                tempA = head1; 
            }
            else tempA = tempA->next; 
            if(tempB == nullptr){
                tempB = head2; 
            }
            else tempB = tempB->next;
        }
        return tempA;  
    }
};