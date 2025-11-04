//? What is LinedList ? 
//* ~ LinkedList is an Data Structure
//* ~ Unlike Arrays, Linked List doesn't store elements in contigous order in the memory.
//* ~ LinkedList can increase or decrease it's size by adding or removing element
//*   due to its not contigous memory location of the elements.
//* ~ Inshort, LinkedList is dynamic in nature [add or remove elemets]
//* ~ Like Arrays, LinkedList can be int, double, list, float, char, string etc.

//? how elements are store in LinkedList : 
//? element      memory location
//?   1                m1   (1 --> head)
//?   3                m2
//?   2                m3
//?   5                m4   (5 --> tail)

//*      1           3            2               5
//*  next = m2    next = m3     next = m4    next = null_ptr (null in java)

//* haed = m1
//* tail = m4

//* In LinedList, elements are store with next. next is the memory location of the next element in the LinedList
//* If we know the head (head = m1) then we can easily move in the LinedList
//* As they form an hypotheically link between the element as element store with next, which gives the memory element of the next elment
//? To Add element in LinkedList : 
//* Add 8 at randomly in heap memory with location m5, and we 
//* iupdate the tail to m5. Change the next = m5 for elemet 5 and for element 8 next = null_ptr or null
//* That's how the LinkedList size changes (increases).
//? Similar Thinking for remove element in LinkedList as well ! 


//? Where is it used ? 
//* Stack / Oueue
//* Real Life use : Browser tab


//? Struct and Class in C++/java !!
//* As in LinkedList, we are storing data and next together.
//* data can be of any type int, float, double, char, etc
//* next will the pointer(int*, float*, etc) that stores the memory location of next element (IN C++)
//* So they together is not any data type. so in order to define data-type to
//* LinkedList. we create our own data-type using struct or class.

// #include<iostream>
// #include<bits/stdc++.h>
// using namespace std;
// // struct Node{
// //     public:
// //         int data;
// //         Node* next;
    
// //     public:
// //         Node(int data1, Node* next1){
// //             data = data1;
// //             next = next1;
// //         }
    
// //     public:
// //         Node(int data1){
// //             data = data1;
// //             next = nullptr;
// //         }
// // };
// class Node{
//     public:
//         int data;
//         Node* next;
    
//     public:
//         Node(int data1, Node* next1){
//             data = data1;
//             next = next1;
//         }
    
//     public:
//         Node(int data1){
//             data = data1;
//             next = nullptr;
//         }
// };
// int main(){
//     vector<int> arr = {2, 5, 8, 7};
//     Node* y = new Node(arr[0], nullptr);
//     cout << y << endl;
//     cout << y->data;
//     return 0;
// }


//? Array to LinkedList : 
//? arr[] = [2, 1, 3, 8]

#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class Node {
    public:
    int data;
    Node* next;

    public:
    Node(int data1, Node* next1){
        data = data1;
        next = next1;
    }

    public:
    Node(int data1){
        data = data1;
        next = nullptr;
    }
};
Node* convertArr2LL(vector<int>& arr){
    Node* head = new Node(arr[0]);
    Node* mover = head;
    for(int i=1; i<arr.size(); i++){
        Node* temp = new Node(arr[i]);
        mover->next = temp;
        mover = temp;
    }
    return head;
}
int main(){
    vector<int> arr = {2, 5, 8, 7};
    Node* head = convertArr2LL(arr);
    cout << head->data;
    return 0;
}
