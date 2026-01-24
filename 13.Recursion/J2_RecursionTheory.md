# Understanding Recursion in Data Structures and Algorithms

## Function Overview

A function is a reusable block of code designed to perform a specific task. It can take input (parameters) and may return a result. Functions allow us to break down complex problems into smaller, manageable pieces.

## Recursion

Recursion occurs when a function calls itself directly or indirectly to solve a problem. It is an elegant approach to handle problems that can be broken down into smaller, similar subproblems. \n **Infinite Recursion:** Infinite recursion happens when a function does not have a base condition to stop the recursive calls. This leads to the function calling itself indefinitely, eventually causing a stack overflow.

Java

```java
```

```java
// Example: Infinite Recursion in Java
class Main {
    static void infiniteRecursion() {
        System.out.println("Calling function");
        infiniteRecursion();
    }

    public static void main(String[] args) {
        // Uncommenting this will cause infinite recursion
        // infiniteRecursion();
    }
}
```

## Base Case/Condition

The base case is a stopping condition in recursive functions that prevents infinite recursion. It defines the simplest instance of the problem that can be solved without further recursion. \n  \n **Note:** Writing effective recursion involves defining a base case or condition that ensures the recursion terminates. Without a base case, recursion will continue indefinitely, leading to stack overflow.

## Recursive Stack Space

Each time a function calls itself, a new frame is added to the function call stack. The stack keeps track of the current function execution. When a base condition is met, the stack starts unwinding, returning the results in reverse order.

## Program Flow in Recursion

When a recursive function is called, a new instance of that function is created and the control is passed to it until it hits the base case. Each recursive call adds a new frame to the stack. Once the base case is reached, the stack starts unwinding, returning the results step by step.

## Types of Recursion:

#### 1. Head Recursion

In head recursion, the recursive call occurs before any other processing in the function. The function waits for the recursive call to return before proceeding with any operation.

**Example:** The following code prints number from 1 to 5 using head recursion.

```javascript
```

```javascript
// Java Example of Head Recursion
class Main {
    static void headRecursion(int n) {
        if (n > 0) {
            headRecursion(n - 1);  // Recursive call before processing
            System.out.print(n + " ");  // Processing after recursion
        }
    }

    public static void main(String[] args) {
        headRecursion(5);
    }
}
```

#### 2. Tail Recursion

In tail recursion, the recursive call is the last operation in the function. Once the function calls itself, there is no need to retain the current function's state, allowing the compiler to optimize tail recursion.

**Example:** The following code prints number from 5 to 1 using tail recursion.

```javascript
```

```javascript
// Java Example of Tail Recursion
class Main {
    static void tailRecursion(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");  // Processing before recursion
        tailRecursion(n - 1);  // Recursive call is the last action
    }

    public static void main(String[] args) {
        tailRecursion(5);
    }
}
```

## Stack Overflow

Any local machine has a limited resources. Stack overflow occurs when too many recursive calls are made without a base case, or the recursion depth exceeds the system's call stack limit. This causes the program to crash as the system runs out of stack space.

## Recursion Tree

A recursion tree is a visual representation that helps understand the flow of recursive calls. It shows how the problem is divided into smaller subproblems at each recursive step.


1\. Recursion Tree for Head Recursion

In head recursion, the tree grows downward as the function waits for each recursive call to complete before executing the remaining operations.


2\. Recursion Tree for Tail Recursion

In tail recursion, the recursion tree is simpler since each recursive call is the last operation, leading to more straightforward unwinding of the stack.

## Time Complexity

The time complexity of a recursive function is generally based on the number of recursive calls made. If a function makes one recursive call, the time complexity is O(n), where n is the depth of the recursion.


## Space Complexity

The space complexity of a recursive function is determined by the maximum depth of the recursive call stack. If the function reaches a maximum recursion depth of n, the space complexity is O(n).