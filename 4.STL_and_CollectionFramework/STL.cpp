//!#include<bits/stdc++.h>   // Add all the neccesary library, no need to add particular #include for all

//! C++ STL is divided into 4 parts 
//* 1. Algorithms
//* 2. Containers
//* 3. Functions
//* 4. Iterators


// #include<bits/stdc++.h>
// using namespace std;

//! Pairs :     --> #include<utility>
// #include<utility>
// #include<iostream>
// using namespace std;
// void explainPair(){
//     pair<int, int> p = {1,3};
//     cout << p.first << " " << p.second << endl;

//     pair<int, pair<int, int>> q = {1, {3, 4}};
//     cout << q.first << " " << q.second.second << " " << q.second.first << endl;

//     pair<int, int> arr[] = { {1,2}, {3,4}, {5,6}};
//     cout << arr[1].second << endl;
// }
// int main(){
//     explainPair();
//     return 0;
// }

//! Vectors :     --> #include<vector>
//* Vectors in STL are basically dynamic arrays that have the ability 
//* to change size whenever elements are added or deleted from them. 
//* Vector elements can be easily accessed and traversed using iterators. 
//* A vector stores elements in contiguous memory locations.

// #include<vector>
// #include<iostream>
// using namespace std;
// void explainVector(){
    // vector<int> v;       //? this create the empty vector
    // v.push_back(1);      //? this add 1 to the end of the vector
    // v.emplace_back(2);   //? this add 2 to the end of the vector (similar to the push_back)
    //* The difference between push_back and emplace_back matters only when you are working 
    //* with more complex types (like classes or structs).
    //* For simple types (like int, double, char), you can use either one—they work the same way.

    // vector<pair<int, int>> vec;
    // vec.push_back({1,2});     //? Creates a temporary pair<int, int> and then moves it into the vector
    // vec.emplace_back(1,2);    //? // Constructs the pair<int, int> directly in the vector
    //* push_back({1, 2});
    //* First, a temporary pair<int, int> is created using {1, 2}.
    //* Then, this temporary pair is moved (or copied) into the vector.

    //* emplace_back(3, 4);
    //* The two numbers 3 and 4 are given directly to the vector.
    //* The pair is constructed in-place inside the vector—no temporary object is made.

    // vector<int> v(5, 100);   //? v = {100, 100, 100, 100, 100}

    // vector<int> v(5);     //? v = {0,0,0,0,0} or garbage values

    // vector<int> v1(5,20);    //? v1 = {20, 20, 20, 20, 20}
    // vector<int> v2(v1);      //? v2 = v1 = {20, 20, 20, 20, 20}

    //? v = {20, 10, 15, 5, 7}
    //? v[2] = 15
    //? other way is iterator

    // vector<int> v = {20,10,15,5,7};
    // vector<int>::iterator it = v.begin();  //* Points to the first element (20) [Address]
    // cout << *(it) << " ";   //* --> 20
    // it++;
    // cout << *(it) << " ";   //* --> 10
    // it = it + 2;
    // cout << *(it) << " ";   //* --> 5
    //* v.end() --? it returns an iterator pointing to the element theoretically after the last element of the vector.
    // for(vector<int>::iterator it = v.begin(); it != v.end(); it++){
    //     cout << *(it) << " ";
    // }
    //* auto --> vector<int>::iterator
    // for(auto it = v.begin(); it != v.end(); it++){
    //     cout << *(it) << " ";
    // }
    // for(auto it:v){
    //     cout << it << " ";
    // }

    //* vector<int>::iterator it = v.end();  --> v.end() returns an iterator pointing just past the last element of the vector (not to the last element itself).
    //* vector<int>::iterator it = v.rend();  --> v.rend() returns a reverse iterator pointing just before the first element of the vector. [basically understand as reverse vector end()]
    //* vector<int>::iterator it = v.rbegin();  --> v.rbegin() returns a reverse iterator pointing to the last element of the vector. [basically understand as reverse vector begin()]

    // cout << v.back() << " ";  //* prints the last element of the vector v

    //* erase --> .erase(iterator) --> delete
    // v.erase(v.begin()+1);    //? Delete 1 index element --> 10 delete/erase from v

    // v.erase(v.begin()+2, v.begin()+4);  //* .erase(start,end) --> [start,end) --> [start is included and end is not included] <-- erase elements from start to end but end is not included.

    //* Insert function   --> .insert(address/iterator, value) --> address/position where you want to insert the value/values.
    // vector<int> v(2,100);   //? v = {100,100}
    // v.insert(v.begin(),300);   //? v = {300,100,100}
    // v.insert(v.begin()+1,2,10);  //? v = {300, 10, 10, 100, 100}

    // vector<int> copy(2,50);   //? copy = {50,50}
    // v.insert(v.begin(), copy.begin(), copy.end());  //? v = {50, 50, 300, 10, 10, 100, 100}

    //* Size of vector 
    // cout << v.size();

    //? {10,20}
    // v.pop_back();  //? 10

    //? v1 --> {10,20}
    //? v2 --> {30,40}
    // v1.swap(v2);    //? v1 --> {30,40}    v2 --> {10,20}

    // v.clear();   //? erases the entire vector

    // cout << v.empty();   //? returns true or 1 --> vector v contains no elements. return false or 0 --> vector v has one or more elements.


// }
// int main(){
//     explainVector();
//     return 0;
// }

//! List   -->  #include<list>
// #include<iostream>
// #include<list>
// using namespace std;
// void explainList(){
//     list<int> ls;

//     ls.push_back(2);  //? {2}
//     ls.emplace_back(4);  //? {2,4}

//     ls.push_front(5);  //? {5,2,4}
//     ls.emplace_front();  //? {0,5,2,4}   

//     //* rest functions same as vector 
//     //* begin, end, rbegin, rend, clear, insert, size, swap

//     //? Bidirectional Traversal: You can iterate both forward and backward through a list
//     //?  You cannot access elements by index (e.g., numbers[2] is invalid)
//     //? Non-contiguous Storage: Elements are stored in nodes scattered throughout memory, each with pointers to the next and previous nodes.

// }
// int main(){
//     explainList();
//     return 0;
// }

//! Deque   --> #include<deque>
// #include<iostream>
// #include<deque>
// using namespace std;
// void explainDeque(){
//     deque<int> dq;
//     dq.push_back(1);   //? {1}
//     dq.emplace_back(2);  //? {1,2}
//     dq.push_front(4);    //? {4,1,2}
//     dq.emplace_front(3);   //? {3,4,1,2}

//     dq.pop_back();   //? {3,4,1}
//     dq.pop_front();  //? {4,1}

//     dq.back();
//     dq.front();

    // * rest functions same as vector 
    // * begin, end, rbegin, rend, clear, insert, size, swap

    // ? Access by index (like vector)
    // ? Not guaranteed to be stored in contiguous memory
    // ? Fast insertions/deletions at both ends 
// }
// int main(){
//     explainDeque();
//     return 0;
// }

//! Stack   -->    #include<stack>
//? A stack is a linear data structure that follows the Last-In, First-Out (LIFO) principle: 
//? the last element added is the first one removed

// #include<iostream>
// #include<stack>
// void explainStack(){
//     stack<int> st;
//     st.push(1);  //? {1}
//     st.push(2);  //? {2,1}
//     st.push(3);  //? {3,2,1}
//     st.push(3);  //? {3,3,2,1}
//     st.emplace(5);  //? {5,3,3,2,1}

//     cout << st.top();   //? prints 5   "** st[2] is invalid **"

//     st.pop();  //? st looks like {3,3,2,1}

//     cout << st.top();  //? 3

//     cout << st.size();  //? 4

//     cout << st.empty();

//     stack<int> st2;
//     st1.swap(st2);

// }
// using namespace std;
// int main(){
//     explainStack();
//     return 0;
// }


//!  Queue   --> #include<queue>
//? A queue is a linear data structure that operates on the First-In, First-Out (FIFO) principle: 
//? the first element added is the first one removed

// #include<iostream>
// #include<queue>
// using namespace std;
// void explainQueue() {
//     queue<int> q;
//     q.push(1);   //? {1}
//     q.push(2);   //? {1,2}
//     q.emplace(4);  //? {1,2,4}

//     q.back() += 5;

//     cout << q.back();  //? prints 9

//     //? Q is {1,2,9}
//     cout << q.front();  //? prints 1

//     q.pop();  //? {2,9}

//     cout << q.front();  //? prints 2

//     //* Size, Swap, empty same as stack
// }
// int main(){
//     explainQueue();
//     return 0;
// }

//! Priority Queue   --> #include<queue>
//? A priority queue is a specialized data structure where each element has a priority,
//? and elements are served based on their priority rather than their insertion order.

// #include<iostream>
// #include<queue>
// using namespace std;
// void explainPQ(){
    //* Maximum Heap
    // priority_queue<int> pq;
    // pq.push(5);  //? {5}
    // pq.push(2);  //? {5,2}
    // pq.push(8);  //? {8,5,2}
    // pq.emplace(10);  //? {10,8,5,2}

    // cout << pq.top();  //? prints 10

    // pq.pop();   //? {8,5,2}

    // cout << pq.top();  //? prints 8

    //* size, swap, empty function same as other

    //* Minimum Heap
    // priority_queue<int, vector<int>, greater<int>> pq;
    // pq.push(5);  //? {5}
    // pq.push(2);  //? {2,5}
    // pq.push(8);  //? {2,5,8}
    // pq.push(10);  //? {2,5,8,10}

    // cout << pq.top();  //? prints 2
// }
// int main(){
//     explainPQ();
//     return 0;
// }

//* Time complexity :
//* push --> logN
//* top --> o(1)
//* pop --> logN


//! Set   --> #include<set>
//? A set in C++ is a Standard Template Library (STL) container that 
//? stores unique elements in a sorted order. Sets are particularly useful 
//? when you need to maintain a collection of distinct items and require fast lookups, insertions, and deletions

// #include<iostream>
// #include<set>
// using namespace std;
// void explainSet(){
    // set<int> st;
    // st.insert(1);    //? {1}
    // st.emplace(2);   //? {1,2}
    // st.insert(2);    //? {1,2}
    // st.insert(4);    //? {1,2,4}
    // st.insert(3);    //? {1,2,3,4}

    //? Functionality of insert in vector
    //? can be used also, that only increases efficiency 

    //? begin(), end(), rbegin(), rend(), size(), empty(), and 
    //? swap() are same as those of above

    //* {1,2,3,4,5}
    // auto it = st.find(3);   //? --> returns iterator which points to the 3
    
    //* {1,2,3,4,5}
    // auto it = st.find(6);   //? --> if the element is not in the set, always returns the st.end()

    //* {1,4,5}
    // st.erase(5);    //? erases 5   // takes logarithmic time

    // int cnt = st.count(1);   //? we know that set has unique elements and in sorted order. So if element exits return 1 or not then return 0. 
                                //? As distinct elements only come 1 time in set if prsent.

    // auto it = st.find(3);
    // st.erase(it);   //* erase can take both element or iterator   // it takes constant time

    //* {1,2,3,4,5}
    // auto it1 = st.find(2);
    // auto it2 = st.find(4);
    // st.erase(it1, it2);     //? after erase {1,4,5}   <-- erase[start, end)

    //? lower_bound() and upper_bound() function works in the same way
    //? as in vector it does.

    //? This is the synatx
    // auto it = st.lower_bound(2);

    // auto it = st.upper_bound(3);

    //* std::lower_bound(first, last, val)
    //* Returns an iterator to the first element in [first, last) that is not less than val (i.e., >= val).
    //* Example: For {1, 2, 2, 3, 4}, lower_bound(2) points to the first 2.

    //* std::upper_bound(first, last, val)
    //* Returns an iterator to the first element in [first, last) that is greater than val.
    //* Example: For {1, 2, 2, 3, 4}, upper_bound(2) points to 3.

    //? Function	         Behavior	         Example for {1, 2, 2, 3, 4}
    //? lower_bound(2)	  First element >= 2	 Points to first 2 (index 1)
    //? upper_bound(2)	  First element > 2	     Points to 3 (index 3)
// }
// int main(){
//     explainSet();
//     return 0;
// }


//! MultiSet    --> #include<set>
//* Everything is same as set
//* only stores duplicate elements also

// #include<iostream>
// #include<set>
// using namespace std;
// void explainMultiSet(){
//     multiset<int> ms;
    // ms.insert(1);    //? {1}
    // ms.insert(1);    //? {1,1}
    // ms.insert(1);    //? {1,1,1}

    // ms.erase(1);    //* all 1's erased

    // int cnt = ms.count(1);   //* gives the count of 1's in the multiset

    //* only a single one erased
    // ms.erase(ms.find(1));
    
    //* rest all functions same as set
// }
// int main(){
//     explainMultiSet();
//     return 0;
// }


//! unordered set   --> #include<unordered_set>
//? An unordered set in C++ is an associative container provided by the Standard Template Library (STL) 
//? that stores unique elements, but does not keep them sorted. Instead, it uses a hash table 
//? for fast average-case operations.

// #include<iostream>
// #include<unordered_set>
// using namespace std;
// void explainUSet(){
//     unordered_set<int> st;
//     //? lower_bound and upper_bound function does not works
//     //? rest all functions are same as above
//     //? it does not stores in any particular oder 
//     //? it has a better complexity than set in most cases, except some when collision happens
//     //* Time complexity --> all the operations are generally in O(1) - constant time and rarely worst case ever happen has O(N)
// }
// int main(){
//     explainUSet();
//     return 0;
// }

//! Map   -->  #include<map>
//? A map in C++ is an associative container from the Standard Template Library (STL) 
//? that stores elements as key-value pairs. Each key in a map is unique, 
//? and values are accessed using these keys rather than by index

//? Unique Keys: Each key in a map is unique—no duplicates allowed.
//? Key-Value Pairs: Each element is stored as a pair: (key, value).
//? Sorted Order: Elements are automatically sorted by their keys in ascending order by default.

// #include<iostream>
// #include<map>
// using namespace std;
// void explainMap(){
//     map<int, int> mpp;

    // map<int, pair<int, int>> mpp;

    // map< pair<int, int>, int> mpp;

    // mpp[1] = 2;   //? {1,2} for key 1 --< value 2
    // mpp.emplace(3,1);
    // mpp.insert({2,4});

    // mpp[{2,3}] = 10;  //? this is for map declaration like --> map< pair<int, int>, int> mpp;

    //? mpp = [ {1,2}, {2,4}, {3,1} ]
    // for(auto it : mpp){
    //     cout << it.first << " " << it.second << endl;   //? for loop in mpp, their are like pairs also use mpp.first and mpp.second, also can use like for loop starts with begin() and then it++ just like vectors
    // }

    // cout << mpp[1];   //? print 2
    // cout << mpp[5];   //? print 0 as there is no 5 in map

    // auto it = mpp.find(3);  //? --> {3,1}
    // cout << (*it).second;

    // auto it = mpp.find(5);  //? 5 key and key value pair not exists, so return mpp.end()

    //? This is the syntax
    // auto it = mpp.lower_bound(2);

    // auto it = mpp.upper_bound(3);

    //? erase, swap, size, empty, are same as above
// }
// int main(){
//     explainMap();
//     return 0;
// }


//! Multimap   -->  #include<map>
//? A multimap in C++ is an associative container from the Standard Template Library (STL) 
//? that stores key-value pairs, allowing multiple values for the same key. 
//? This distinguishes it from std::map, which only allows unique keys

//? Duplicate Keys Allowed: Multiple entries can have the same key.
//? Sorted Order: Keys are always kept sorted (ascending by default).

// #include<iostream>
// #include<map>
// using namespace std;
// void explainMultimap(){
//     //* everything same as map, only it can store multiple keys
//     //* ony mpp[key] cannot be used here
// }
// int main(){
//     explainMultimap();
//     return 0;
// }

//! unordered map   --> #include<unordered_map>
//? An unordered map in C++ is an associative container that stores key-value pairs, 
//? where each key is unique. Unlike std::map, the elements in an unordered map 
//? are not stored in any particular order.

// #include<iostream>
// #include<unordered_map>
// using namespace std;
// void explainUnorderedMap(){
//     //* same as set and unordered_set difference.
// }
// int main(){
//     explainUnorderedMap();
//     return 0;
// }

//* Map --> logN  and unordered_map --> O(1) - constant time and in worst even (rarely ever will be happen) O(N)


//! Algorithms   --> #include<algorithm>

#include<algorithm>  //? <-- sort
#include<iostream>
#include<vector>
#include<utility>
#include<string>
using namespace std;
bool comp(pair<int, int> p1, pair<int, int> p2){  //* Function of Sort it in my owm way !!
    if(p1.second < p2.second) return true;
    if(p1.second > p2.second)  return false;
    //? they are same

    if(p1.first > p2.first) return true;
    return false;
}
void explainExtra(){
    //* Array
    // int a[] = {1,5,3,2};
    // sort(a, a+4);       //* sort(a, a+n) <-- Array  --> sort[start, end)
    // for(int i=0; i<4; i++){
    //     cout << a[i] << " ";
    // }
    // sort(a+2, a+4);        //* sort(a+2, a+4)  <-- Particular part sort
    // for(int i=0; i<4; i++){
    //     cout << a[i] << " ";
    // }
    // sort(a, a+4, greater<int>());  //* sort(a, a+n, greater<int>());  <-- This will sort the array in descending order.
    // for(int i=0; i<4; i++){
    //     cout << a[i] << " ";
    // }

    //* Vector
    // vector<int> v = {1,5,3,2};
    // sort(v.begin(), v.end());   //*  sort(v.begin(), v.end())
    // for(auto it : v){
    //     cout << it << " ";
    // }
    // sort(v.begin()+2, v.end());  //*  sort(v.begin()+2, v.end());  <-- Particular part sort
    // for(auto it : v){
    //     cout << it << " ";
    // }
    // sort(v.begin(), v.end(), greater<int>());  //* sort(v.begin(), v.end(), greater<int>());  <-- Sorts vector in descending order
    // for(auto it : v){
    //     cout << it << " ";
    // }

    //* sorting will be in ascending or descending order
    //* what if i want to sort in my way !! Sort in my own way other than ascending or descending.

    // pair<int, int> a[] = {{1,2}, {2,1}, {4,1}};

    //? sort it according to second element   --> {{2,1}, {4,1}, {1,2}}  sorted according to second elements in ascending 
    //? if second element is same, then sort  --> now we can see that there are same second elements 1 and 1
    //? it according to first element but in descending  --> {{4,1}, {2,1}, {1,2}} sorted in descending according to first elements

    // sort(a, a+3, comp);  //* sort(a, a+n, comp)   comp --> function
    // for(int i=0; i<3; i++){
    //     cout << a[i].first << " " << a[i].second << endl;  //* -->  {{4,1}, {2,1}, {1,2}}
    // }


    // int num = 7;
    // int cnt = __builtin_popcount(num);  //* it returns the how many 1's are there in binary of num
    // cout << cnt;
    
    // long long num = 165786578687;
    // int cnt = __builtin_popcountll(num);   //* for long long number
    // cout << cnt;


    // string s = "123";
    // sort(s.begin(), s.end());  //* for next_permutation, string should be sorted
    // do{
    //     cout << s << endl;
    // } while(next_permutation(s.begin(), s.end()));


    //* In Array
    // int arr[] = {1,10,5,6};
    // int maxi = *max_element(arr, arr+4);  //* for Maximum element in array
    // cout << maxi << endl;
    // int mini = *min_element(arr, arr+4);  //* for Minimum element in array
    // cout << mini << endl;

    //* In Vector
    vector<int> v = {1,10,5,6};
    int maxi = *max_element(v.begin(), v.end());
    cout << maxi << endl;
    int mini = *min_element(v.begin(), v.end());
    cout << mini << endl;
}
int main(){
    explainExtra();
    return 0;
}