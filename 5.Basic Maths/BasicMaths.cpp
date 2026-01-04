//? Basic Maths :

//! Digits :

//* Extraction of Digits
//? N = 7789 % 10 --> 9 
//? N = N/10
//? N = 778 % 10 --> 8
//? N = N/10;
//? N = 77 % 10 --> 7
//? N = N/10
//? N = 7 % 10 --> 7
//? N = N/10
//? N = 0
//* Code
// #include<iostream>
// using namespace std;
// void extractionDigits(int num){
//     while(num>0){
//         int digit = num%10;
//         cout << digit << endl;
//         num /= 10;
//     }
// }
// int main(){
//     int num = 7789;
//     extractionDigits(num);
//     return 0;
// }


//? Count Digits : 
// #include<iostream>
// #include<math.h>
// using namespace std;
//! Brute :
// void CountDigits(int num){
//     int cnt = 0;
//     while(num>0){
//         cnt++;
//         num /= 10;
//     }
//     cout << cnt;
// }
//* Optimal : 
// void CountDigits(int num){
//     int cnt = (int)(log10(num) + 1);
//     //? num = 7789
//     //? log10(7789)  --> 3.81 --> 3.81 + 1 = 4.81 --> (int)4.81 --> 4 <-- Number of digits
//     cout << cnt;
// }
// int main(){
//     int num;
//     cin >> num;
//     CountDigits(num);
//     return 0;
// }
//! Time Complexity : 
//! TC --> O( log10(N) )
//* Tip / point :
//* whenever there is division like N/10 , N/5, N/2
//* TC --> O(log10(N)), O(log5(N)), O(log2(N))


//? Reverse a Number 
// #include<iostream>
// using namespace std;
//* Only Optimal Approach : 
// void ReverseNumber(int num){
//     int resNum = 0;
//     while(num>0){
//         int digit = num%10;
//         resNum = resNum*10 + digit;
//         num /= 10;
//     }
//     cout << resNum;
// }
// int main(){
//     int num;
//     cin >> num;
//     ReverseNumber(num);
//     return 0;
// }


//? Palindrome Number 
// #include<iostream>
// using namespace std;
// //* Already Optimal way to do
// void PalindromeNumber(int num){
//     int orig = num;
//     int revNum = 0;
//     while(num>0){
//         revNum = revNum*10 + num%10;
//         num /= 10;
//     }
//     if(revNum == orig) cout << "true";
//     else cout << "false";
// }
// int main(){
//     int num;
//     cin >> num;
//     PalindromeNumber(num);
//     return 0;
// }


//? Armstrong Number 
// #include<iostream>
// #include<math.h>
// using namespace std;
// int power(int base, int exp){
//     int result = 1;
//     while(exp--){
//         result *= base;
//     }
//     return result;
// }
// void ArmstrongNumber(int num){
//     if(num < 0){
//         cout << "false";
//         return;
//     }
//     if(num==0){          //? log10(0) is undefined
//         cout << "true";
//         return;
//     }
//     int temp = num;
//     int digit = (int)(log10(num) + 1);
//     int sum = 0;
//     while(temp>0){
//         sum += power(temp%10, digit);
//         temp /= 10;
//     }
//     if(sum==num) cout << "true";
//     else cout << "false";
// }
// int main(){
//     int num;
//     cin >> num;
//     ArmstrongNumber(num);
//     return 0;
// }
//* Time complexity : O((log10N)^2)


//! Print all divisors 
//? Eg :- 36 --> 1,2,3,4,6,9,12,18,36

// #include<iostream>
// #include<math.h>
// #include<vector>
// #include<algorithm>
// using namespace std;
// void PrintAllDivisors(int num){
//     for(int i=1; i<=num; i++){
//         if(num%i==0){
//             cout << i << " ";
//         }
//     }
// }
//* Time Complexity : O(N)

//! Optimal
//? Concept : 
//? for num = 36
//? loop start from 1
//? and we observe that
//?   1 x 36
//?   2 x 18
//?   3 x 12
//?   4 x 9
//* -------------
//?   6 x 6
//* -------------
//?   9 x 4
//?   12 x 3
//?   18 x 2
//?   36 x 1 
//?    ↑   ↑
//?    i   num/i
//* we can see that the bottom portion is nothing but repeative part of upper one 
//* it starting repeating from 6 i.e, sqrt(36)

// void PrintAllDivisors(int num){
//     vector<int> v;      //? <-- here we use vector bcz if we directly prints then we get like 1,36,2,18,3,12,4,9,6 not in the sorted way and we don't know the size so use vector as the container
//     for(int i=1;i<=sqrt(num); i++){   //* or use i*i <= num so it avoids calling sqrt again and again !
//         if(num%i==0){
//             v.push_back(i);
//             if(num/i != i){        //? from here we get num/i values like 36,18,12... and use num/i != i so that 6 don't gets prints two times 
//                 v.push_back(num/i);
//             }
//         }
//     }
//     sort(v.begin(), v.end());
//     for(auto it:v){
//         cout << it << " ";
//     }
// }
// int main(){
//     int num;
//     cin >> num;
//     PrintAllDivisors(num);
//     return 0;
// }
//* Time Complexity :
//* O(√N) for finding divisors
//* O(k log k) for sorting (where k is the number of divisors, which is at most 2√N)


//! Prime Number Check
//* --> A number that has exactly 2 factors 1 & itself

// #include<iostream>
// using namespace std;
//! Brute : 
// void PrimeNumberCheck(int num){
//     int cnt = 0;
//     for(int i=1;i<=num;i++){
//         if(num%i==0) cnt++;
//     }
//     if(cnt==2) cout << "true";
//     else cout << "false";
// }
//* Time complexity : O(N)

//! Optimal :
//? Using Concept like the above i.e, print all divisor 
//? As we see, we can get all the factors within sqrt(num) so why go till num in the loop
// void PrimeNumberCheck(int num){
//     int cnt = 0;
//     for(int i=1; i*i<=num; i++){   //? or can use sqrt(num) but i*i<=num is more better !
//         if(num%i==0){
//             cnt++;
//             if(num/i != i) cnt++;
//         }
//     }
//     if(cnt==2) cout << "true";
//     else cout << "false";
// }
//* Time Complexity : O(sqrt(N))
// int main(){
//     int num;
//     cin >> num;
//     PrimeNumberCheck(num);
//     return 0;
// }


//! GCD / HCF 
//? eg : n1 = 9   n2 = 12
//? n1 factors --> 1,3,9
//? n2 factors --> 1,2,3,4,6,12
//? GCD of n1 and n2 --> 3

//? eg : n1 = 11  n2 = 13
//? n1 factors --> 1,11
//? n2 factors --> 1,13
//? GCD of n1 and n2 --> 1
//* So there is always an GCD between 2 numbers and smallest GCD possible between 2 numbers is 1

// #include<iostream>
// using namespace std;
//! Brute : 
//? (1)
// void GCD(int n1, int n2){
//     int gcd = 1;
//     for(int i=1; i<=min(n1,n2); i++){
//         if(n1%i==0 && n2%i==0){
//             gcd = i;
//         }
//     }
//     cout << gcd;
// }
//* Time Complexity : O(min(n1,n2))

//? (2)
// void GCD(int n1, int n2){
//     for(int i=min(n1,n2); i>=1; i--){
//         if(n1%i==0 && n2%i==0){
//             cout << i;
//             break;
//         }
//     }
// }
//? This will be better way/approach for many cases, BUT
//* Time complexity still remains O(min(n1,n2))
//* As TC measure in worst case 
//? eg : 11 and 13 
//? In this, it goes from 11 to 1 so TC : O(min(n1,n2)) 
// int main(){
//     int n1,n2;
//     cin >> n1 >> n2;
//     GCD(n1,n2);
//     return 0;
// }

//* OPTIMAL WAY TO FIND GCD : 
//! Euclidean Algorithm  --> gcd(a,b) = gcd(a%b, b)     a>b

//? for two numbers N1 and N2
//? gcd(N1,N2) = gcd(N1-N2,N2)     N1>N2 
//? gcd(a,b)  =  gcd(a-b, b)        a>b

//? eg :-  gcd(20,15)  =  gcd(5,15)
//* As 20 > 15 and gcd(20,15) --> 5 and gcd(20-15, 15) --> gcd(5,15) --> 5
//? Again applying euclidean Algo
//? gcd(5,15)  --> gcd(15,5)

//? gcd(20,15)  =  gcd(5,15)
//? gcd(15,5)   =  gcd(10,5)
//? gcd(10,5)   =  gcd(5,5)
//? gcd(5,5)    =  gcd(0,5)
//* The moment one number become zero, the other number is the gcd 
//? Therefore, gcd = 5

//? Eg :- 
//? gcd(52,10) --> gcd(42,10) --> gcd(32,10) --> gcd(22,10) --> gcd(12,10)
//? --> gcd(2,10) --> gcd(10,2) --> gcd(8,2) --> gcd(4,2) --> gcd(2,2) --> gcd(0,2)
//? gcd = 2
//? but it is an long process ( not in terms of complexity ) in terms of calculation 
//* so we can apply a simple maths here 
//* DO gcd(52%10, 10) instead of gcd(52-10, 10)
//* gcd(52%10, 10) --> gcd(2,10) --> gcd(10%2, 2) --> gcd(0,2)
//* so get gcd = 2 and calculation also gets short !

//! do the algothrithm in better sense is : 
//* gcd(a,b)  =  gcd(a%b, b)     a>b

//! Euclidean Algorithm --> gcd(a,b) = gcd(a%b, b)     a>b

#include<iostream>
using namespace std;
void EuclideanAlgo(int a, int b){
    while(a>0 && b>0){
        if(a>b) a = a % b;
        else b = b % a;
    }
    if(a==0) cout << b;
    else cout << a;
}
int main(){
    int a,b;
    cin >> a >> b;
    EuclideanAlgo(a,b);
    return 0;
}
//* Time Complexity : O( log Φ(min(a,b)) )
