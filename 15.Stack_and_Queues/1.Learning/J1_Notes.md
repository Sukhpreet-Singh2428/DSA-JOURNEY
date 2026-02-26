## Stack vs Queue in Java (Theory Notes)

### 🔹 Stack

* A **Stack** is a linear data structure that follows **LIFO (Last In First Out)**.
* The element inserted last is removed first.
* Example analogy: Stack of plates.

#### Operations

* `push(x)` → insert element on top
* `pop()` → remove top element
* `peek()` → view top element
* `size()` → number of elements

#### Java Implementation

* `Stack` is a **class** in `java.util`

```java
Stack<Integer> st = new Stack<>();
```

#### Preferred Modern Implementation

* `Stack` is considered legacy.
* Use `Deque` with `ArrayDeque` instead:

```java
Deque<Integer> st = new ArrayDeque<>();
```

#### Why prefer ArrayDeque?

* Faster than Stack
* No synchronization overhead
* Better memory usage
* Industry & interview preferred


---

### 🔹 Queue

* A **Queue** is a linear data structure that follows **FIFO (First In First Out)**.
* The first inserted element is removed first.
* Example analogy: People standing in a line.

#### Operations

* `offer(x)` → insert element
* `poll()` → remove front element
* `peek()` → view front element
* `size()` → number of elements

#### Important Java Concept

* `Queue` is an **interface**, not a class.
* It cannot be instantiated directly.

❌ Invalid

```java
Queue<Integer> q = new Queue<>();
```

✔ Valid Implementations

```java
Queue<Integer> q = new LinkedList<>();
Queue<Integer> q = new ArrayDeque<>();
```

#### Preferred Implementation

```java
Queue<Integer> q = new ArrayDeque<>();
```

#### Why use offer/poll instead of add/remove?

* `offer()` returns `false` if insertion fails
* `poll()` returns `null` if empty
* `add()` / `remove()` throw exceptions
* Safer and standard for DSA/interviews


---

### 🔹 Stack vs Queue Summary

| Feature | Stack | Queue |
|----|----|----|
| Principle | LIFO | FIFO |
| Insert | push() | offer() |
| Remove | pop() | poll() |
| Access | Top | Front |
| Java Nature | Class | Interface |
| Best Implementation | ArrayDeque | ArrayDeque |


---

### 🔹 Interview Best Practice

```java
// Stack
Deque<Integer> st = new ArrayDeque<>();

// Queue
Queue<Integer> q = new ArrayDeque<>();
```

This shows strong Java collections understanding.


## **Java Implementation Theory — Stack vs Queue**

### 🔹 Stack Implementation in Java

* `Stack` is a **concrete class** present in `java.util`.
* Since it is a class, we can directly create its object.

```java
Stack<Integer> st = new Stack<>();
```

* It provides built-in methods like:
  * `push()`
  * `pop()`
  * `peek()`

#### Important Note

* `Stack` is part of Java’s **legacy collection classes**.
* It is synchronized → slower.
* Modern Java practice prefers using `Deque` (`ArrayDeque`) as a stack:

```java
Deque<Integer> st = new ArrayDeque<>();
```

This is faster and preferred in interviews.


---

### 🔹 Queue Implementation in Java

* `Queue` is an **interface**, not a class.
* Interfaces cannot be instantiated directly.

❌ Invalid

```java
Queue<Integer> q = new Queue<>();
```

* Therefore we must create objects of classes that **implement Queue**, such as:

```java
Queue<Integer> q = new LinkedList<>();
Queue<Integer> q = new ArrayDeque<>();
```

* Common queue methods:
  * `offer()` — insert
  * `poll()` — remove
  * `peek()` — view front

#### Why offer/poll instead of add/remove?

* `offer()` / `poll()` handle failure safely
* `add()` / `remove()` throw exceptions
* Hence preferred in DSA/interviews


---

### 🔹 Core Difference to Remember

| Stack | Queue |
|----|----|
| Implemented as a **class** | Defined as an **interface** |
| Can instantiate directly | Must use implementing class |
| `new Stack<>()` | `new LinkedList<>()` / `new ArrayDeque<>()` |
| Legacy class | Modern interface-based design |


---

### 🧠 Memory Trick

> **Stack → Direct object (Class)**
> **Queue → Choose implementation (Interface)**


