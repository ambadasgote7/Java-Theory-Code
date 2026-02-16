# Java Collection Framework – Introduction

## 1. What is Java Collection Framework?

The Java Collection Framework is a unified architecture introduced in JDK 1.2 that provides a set of interfaces and classes to store, manage, and manipulate groups of objects dynamically.

It provides ready-made data structures such as:
- List
- Set
- Queue
- Map

It also provides built-in algorithms for:
- Sorting
- Searching
- Shuffling
- Synchronization

---

## 2. Why Collections Are Needed?

### Problems with Arrays:
- Fixed size
- No built-in utility methods
- Difficult to manage dynamic data
- No advanced data structures like Map, Set, Queue
- Cannot easily store heterogeneous objects

### How Collections Solve These Problems:
- Dynamic resizing
- Built-in methods (add, remove, contains, etc.)
- Powerful utility class (Collections)
- Thread-safe implementations available
- Support for Java 8 features like Streams and Lambda

---

## 3. Difference Between Collection and Collections

| Collection | Collections |
|------------|------------|
| Interface  | Utility Class |
| Part of hierarchy | Contains static helper methods |
| Example: List, Set | Example: sort(), reverse() |

Important:
Collection is an interface.
Collections is a utility class.

---

## 4. Java Collection Hierarchy

### Iterable (Root Interface)
- Provides iterator()
- Enables enhanced for-loop

### Collection (Extends Iterable)
Common methods:
- add()
- remove()
- size()
- clear()
- contains()

---

### List (Ordered, Allows Duplicates, Index Based)
- ArrayList
- LinkedList
- Vector
  - Stack

---

### Set (No Duplicates)
- HashSet
- LinkedHashSet
- TreeSet

---

### Queue (FIFO Structure)
- PriorityQueue
- Deque
  - ArrayDeque

---

### Map (Separate Hierarchy – Not Part of Collection Interface)

- HashMap
- LinkedHashMap
- TreeMap
- Hashtable
- ConcurrentHashMap

Important:
Map is part of the Collections Framework but does NOT extend the Collection interface.

---

## 5. Basic Example

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("A");

        System.out.println(list); // [A, B, A]
    }
}
```

Explanation:
- Dynamic size
- Allows duplicates
- Maintains insertion order

---

## 6. Interview Definition (Strong Answer)

Java Collection Framework is a unified architecture that provides interfaces and classes to store and manipulate groups of objects dynamically. It includes List, Set, Queue, and Map implementations and provides algorithms for sorting, searching, and synchronization.

---

# Java ArrayList – Complete Guide (Interview Preparation)

---

## 1. What is ArrayList?

ArrayList is a resizable array implementation of the List interface.

It:
- Maintains insertion order
- Allows duplicate elements
- Is index-based
- Is not thread-safe
- Provides fast random access

Package:
```java
import java.util.ArrayList;
```

---

## 2. Internal Working of ArrayList

ArrayList internally uses a dynamic array.

### Default Capacity
- Default initial capacity = 10

### Resizing Mechanism
When capacity is full:
```
newCapacity = oldCapacity + (oldCapacity / 2)
```

Example growth:
```
10 → 15 → 22 → 33 → 49 ...
```

Resizing involves:
- Creating new array
- Copying old elements
- Replacing reference

This is why insertion can sometimes be expensive.

---

## 3. Time Complexity

| Operation | Time Complexity |
|------------|----------------|
| get(index) | O(1) |
| set(index) | O(1) |
| add(element at end) | O(1) (amortized) |
| add(index) | O(n) |
| remove(index) | O(n) |
| search | O(n) |

---

## 4. Declaring ArrayList (Best Practice)

### Recommended Way
```java
List<String> list = new ArrayList<>();
```

Reason:
- Programming to interface
- Flexible design
- Loose coupling

### Direct Implementation (Not Recommended for Design)
```java
ArrayList<String> list = new ArrayList<>();
```

---

## 5. Ways to Create List

---

### 5.1 Using new ArrayList<>()

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
```

✔ Mutable  
✔ Resizable  
✔ Can add/remove  

---

### 5.2 Using Arrays.asList()

```java
import java.util.Arrays;

List<String> list = Arrays.asList("A", "B", "C");
```

Properties:
- Fixed size
- Backed by array
- Cannot add or remove
- Can modify elements using set()

Example:
```java
list.set(0, "X");  // Allowed
list.add("D");     // Throws UnsupportedOperationException
```

Important:
Arrays.asList() does NOT return java.util.ArrayList.

---

### 5.3 Using List.of() (Java 9+)

```java
List<String> list = List.of("A", "B", "C");
```

Properties:
- Completely immutable
- Cannot add
- Cannot remove
- Cannot modify

Example:
```java
list.set(0, "X");  // Throws UnsupportedOperationException
```

---

## 6. Comparison Table

| Method | Add/Remove | Modify | Resizable | Java Version |
|--------|------------|--------|-----------|--------------|
| new ArrayList<>() | Yes | Yes | Yes | Java 1.2 |
| Arrays.asList() | No | Yes | No | Java 1.2 |
| List.of() | No | No | No | Java 9 |

---

## 7. Converting Fixed List to Resizable

```java
List<String> list = new ArrayList<>(Arrays.asList("A", "B"));
```

Now:
- add() works
- remove() works

---

## 8. Primitive Array Trap

Incorrect:
```java
int arr[] = {1,2,3};
List<int[]> list = Arrays.asList(arr);
```

This creates:
- List containing one element (the entire array)

Correct:
```java
Integer arr[] = {1,2,3};
List<Integer> list = Arrays.asList(arr);
```

Reason:
Collections work with Objects, not primitive types.

---

## 9. Capacity vs Size

```java
ArrayList<String> list = new ArrayList<>(100);
```

- size() = number of elements present
- capacity = internal array length

Initial capacity helps avoid resizing cost.

---

## 10. Copying ArrayList

```java
List<String> list2 = new ArrayList<>(list1);
```

Creates a shallow copy.

---

## 11. Commonly Used Methods

```java
add(E e)
add(int index, E e)
remove(int index)
remove(Object o)
get(int index)
set(int index, E e)
contains(Object o)
size()
isEmpty()
clear()
```

---

## 12. When to Use ArrayList

Use when:
- Need fast random access
- Mostly inserting at end
- Duplicates allowed
- Order matters

---

## 13. When NOT to Use

Avoid when:
- Frequent insertions/deletions in middle
- Need thread safety
- Implementing queue behavior

---

## 14. Interview-Level Definition

ArrayList is a resizable array implementation of the List interface that allows duplicates and maintains insertion order. It provides O(1) random access but has O(n) insertion and deletion cost in the middle due to element shifting.

---

# Java Comparable and Comparator – Complete Interview Guide

---

# 1️⃣ Why Do We Need Comparable and Comparator?

When sorting primitive data (int, String), Java knows how to compare.

But for custom objects like:

```java
class Student {
    String name;
    int age;
}
```

Java does NOT know:
- Sort by age?
- Sort by name?
- Ascending or descending?

So we must define sorting logic.

There are two ways:
- Comparable → Natural ordering
- Comparator → Custom ordering

---

# 2️⃣ Comparable (Natural Ordering)

Package:
```
java.lang.Comparable
```

Used when the class itself defines its default sorting logic.

### Method:
```java
int compareTo(T o);
```

### Return Rules:
- Negative → this < other
- Zero → equal
- Positive → this > other

---

## Example: Comparable (Sort by Age, then Name)

```java
import java.util.*;

class Student implements Comparable<Student> {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {

        int ageCompare = Integer.compare(this.age, s.age);

        if (ageCompare != 0) {
            return ageCompare;
        }

        return this.name.compareTo(s.name);
    }

    public String toString() {
        return name + " " + age;
    }
}

public class Test {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Rahul", 21));
        students.add(new Student("Babusha", 22));
        students.add(new Student("Ambadas", 21));

        Collections.sort(students);

        System.out.println(students);
    }
}
```

### Output:
```
Ambadas 21
Rahul 21
Babusha 22
```

---

## Important Points About Comparable

- Sorting logic inside class
- Only one natural ordering allowed
- Used when calling:
  ```java
  Collections.sort(list);
  ```

---

# 3️⃣ Comparator (Custom Ordering)

Package:
```
java.util.Comparator
```

Used to define sorting logic outside the class.

### Method:
```java
int compare(T o1, T o2);
```

---

## Example 1: Comparator Using Anonymous Class

```java
students.sort(new Comparator<Student>() {
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.age, s2.age);
    }
});
```

---

## Example 2: Comparator Using Lambda

```java
students.sort((s1, s2) -> Integer.compare(s1.age, s2.age));
```

---

## Example 3: Multi-Level Sorting Using Lambda

```java
students.sort((s1, s2) -> {
    int ageCompare = Integer.compare(s1.age, s2.age);
    if (ageCompare != 0) {
        return ageCompare;
    }
    return s1.name.compareTo(s2.name);
});
```

---

# 4️⃣ Modern Comparator Methods (Java 8+)

## comparing()

```java
students.sort(Comparator.comparing(s -> s.name));
```

---

## comparingInt()

```java
students.sort(Comparator.comparingInt(s -> s.age));
```

Better for int (avoids boxing).

---

## thenComparing()

```java
students.sort(
    Comparator.comparingInt((Student s) -> s.age)
              .thenComparing(s -> s.name)
);
```

Sort by:
1. Age
2. If equal → Name

---

## reversed()

```java
students.sort(
    Comparator.comparingInt((Student s) -> s.age)
              .reversed()
);
```

Sort age descending.

---

## Combine reversed() and thenComparing()

```java
students.sort(
    Comparator.comparingInt((Student s) -> s.age)
              .reversed()
              .thenComparing(s -> s.name)
);
```

Age → Descending  
Name → Ascending  

---

# 5️⃣ Comparable vs Comparator (Interview Table)

| Feature | Comparable | Comparator |
|----------|------------|------------|
| Package | java.lang | java.util |
| Method | compareTo() | compare() |
| Location | Inside class | Outside class |
| Default sorting | Yes | No |
| Multiple sorting rules | No | Yes |
| Used with | Collections.sort(list) | list.sort(comparator) |

---

# 6️⃣ Important Interview Notes

✔ Comparable defines natural order.  
✔ Comparator defines custom order.  
✔ Comparator overrides Comparable if passed explicitly.  
✔ comparingInt() is better for primitive int.  
✔ reversed() reverses entire comparator chain.  

---

# 7️⃣ toString() Clarification

When printing list:

```java
System.out.println(students);
```

Java automatically calls:

```
element.toString()
```

If not overridden → prints:
```
Student@hashcode
```

Always override toString() for readable output.

---

# 8️⃣ Summary (Interview Answer)

Comparable is used to define natural ordering inside a class using compareTo(), while Comparator is used to define custom sorting logic externally using compare() or lambda expressions. Comparator allows multiple sorting strategies without modifying the original class.

---

# Java LinkedList – Complete Guide (Interview Preparation)

---

# 1️⃣ What is LinkedList?

LinkedList is a doubly linked list implementation of:

- List
- Deque
- Queue

Package:
```java
import java.util.LinkedList;
```

Unlike ArrayList (which uses a dynamic array), LinkedList uses nodes connected through references.

---

# 2️⃣ Internal Structure

Each node contains:

```
[ previous | data | next ]
```

Visual Representation:

```
null <- [A] <-> [B] <-> [C] -> null
```

Each element stores:
- Data
- Reference to next node
- Reference to previous node

This is why it is called a doubly linked list.

---

# 3️⃣ LinkedList vs ArrayList

| Feature | ArrayList | LinkedList |
|----------|------------|------------|
| Internal Structure | Dynamic Array | Doubly Linked List |
| Random Access | O(1) | O(n) |
| Insert at Beginning | O(n) | O(1) |
| Insert at End | O(1)* | O(1) |
| Memory Usage | Less | More |
| Shifting Elements | Yes | No |

*ArrayList resizing may occasionally take O(n).

---

# 4️⃣ Time Complexity

| Operation | LinkedList Complexity |
|------------|----------------------|
| add() | O(1) |
| addFirst() | O(1) |
| addLast() | O(1) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| get(index) | O(n) |
| remove(index) | O(n) |

Reason:
LinkedList must traverse nodes sequentially.

---

# 5️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list);

        list.addFirst("Start");
        list.addLast("End");

        System.out.println(list);
    }
}
```

Output:
```
[A, B, C]
[Start, A, B, C, End]
```

---

# 6️⃣ Queue Methods (Because It Implements Deque)

Queue-style methods:

```java
add()
offer()
poll()
peek()
```

Deque-style methods:

```java
addFirst()
addLast()
removeFirst()
removeLast()
getFirst()
getLast()
```

---

# 7️⃣ When to Use LinkedList

Use LinkedList when:

✔ Frequent insertions at beginning  
✔ Frequent deletions  
✔ Implementing Queue or Deque  
✔ No need for random access  

---

# 8️⃣ When NOT to Use LinkedList

Avoid LinkedList when:

❌ Frequent index-based access  
❌ Memory efficiency is important  
❌ High-performance random reads required  

Each node stores:
- Data
- Next reference
- Previous reference

So it consumes more memory than ArrayList.

---

# 9️⃣ Important Interview Questions

Q: Is LinkedList faster than ArrayList?

Answer:
It depends on usage.

- Frequent random access → ArrayList is faster.
- Frequent insert/delete at beginning → LinkedList is faster.

---

# 🔟 Performance Example

### Case 1: Inserting at index 0 repeatedly

```java
for(int i = 0; i < 100000; i++){
    list.add(0, i);
}
```

LinkedList → Faster  
ArrayList → Slower (due to shifting)

---

### Case 2: Adding at end repeatedly

```java
for(int i = 0; i < 100000; i++){
    list.add(i);
}
```

ArrayList → Generally faster  
LinkedList → Slightly slower due to node allocation

---

# 1️⃣1️⃣ Summary

LinkedList is a doubly linked list implementation that provides fast insertions and deletions but slow random access. It is suitable for queue-like operations but not ideal for index-based access.

---

# Java Vector – Complete Guide (Interview Preparation)

---

# 1️⃣ What is Vector?

Vector is a legacy dynamic array implementation introduced in Java 1.0.

Package:
```java
import java.util.Vector;
```

It is similar to ArrayList but:

- It is synchronized (thread-safe)
- It was introduced before the Collection Framework (Java 1.2)
- It is considered a legacy class

---

# 2️⃣ Internal Working

Vector is backed by a dynamic array.

### Default Capacity:
```
10
```

### Resizing Rule:
When capacity is full → capacity doubles (100% increase)

Example growth:
```
10 → 20 → 40 → 80 → 160
```

This differs from ArrayList (which grows by 50%).

---

# 3️⃣ Why Vector Is Slower

All major methods are synchronized:

```java
public synchronized boolean add(E e)
```

Synchronization ensures thread safety but adds performance overhead.

In single-threaded applications, Vector is slower than ArrayList.

---

# 4️⃣ Time Complexity

Same as ArrayList (algorithm-wise):

| Operation | Time Complexity |
|------------|----------------|
| get(index) | O(1) |
| set(index) | O(1) |
| add() | O(1) amortized |
| remove(index) | O(n) |

Performance difference is due to synchronization.

---

# 5️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        Vector<String> vector = new Vector<>();

        vector.add("A");
        vector.add("B");
        vector.add("C");

        System.out.println(vector);

        vector.remove("B");

        System.out.println(vector);
    }
}
```

Output:
```
[A, B, C]
[A, C]
```

---

# 6️⃣ Legacy Methods in Vector

Vector has older methods not commonly used today:

```java
addElement()
removeElement()
elementAt()
firstElement()
lastElement()
```

Example:

```java
vector.addElement("D");
```

Modern code prefers `add()`.

---

# 7️⃣ Capacity Control

Vector allows capacity increment control:

```java
Vector<Integer> v = new Vector<>(initialCapacity, capacityIncrement);
```

Example:

```java
Vector<Integer> v = new Vector<>(10, 5);
```

Capacity growth:
```
10 → 15 → 20 → 25
```

If capacityIncrement is not specified, capacity doubles.

---

# 8️⃣ Vector vs ArrayList

| Feature | ArrayList | Vector |
|----------|------------|--------|
| Thread Safe | No | Yes |
| Synchronization | No | Yes |
| Introduced | Java 1.2 | Java 1.0 |
| Performance | Faster | Slower |
| Growth Factor | 50% | 100% |

---

# 9️⃣ When to Use Vector

Almost never in modern applications.

Better Alternatives:

- ArrayList → Single-threaded use
- Collections.synchronizedList()
- CopyOnWriteArrayList (modern thread-safe option)

Vector is mostly found in legacy systems.

---

# 🔟 Interview Summary

Vector is a synchronized dynamic array introduced in Java 1.0. It provides thread safety through method-level synchronization but is slower than ArrayList. It is considered a legacy class and is rarely used in modern Java applications.

---

# Java Stack – Complete Guide (Interview Preparation)

---

# 1️⃣ What is Stack?

Stack is a legacy class in Java that follows the LIFO principle.

LIFO = Last In First Out

Package:
```java
import java.util.Stack;
```

Stack extends Vector.

So internally:
```
Stack → Vector → List → Collection
```

---

# 2️⃣ Stack Principle (LIFO)

Example:

Push:
```
Push A
Push B
Push C
```

Stack looks like:
```
Top
 C
 B
 A
```

Pop removes:
```
C (first)
```

Last inserted element comes out first.

---

# 3️⃣ Basic Stack Methods

| Method | Description |
|----------|-------------|
| push(E item) | Add element to top |
| pop() | Remove and return top element |
| peek() | Return top element (no removal) |
| empty() | Check if stack is empty |
| search(Object o) | Returns position from top |

---

# 4️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack);

        System.out.println("Peek: " + stack.peek());

        System.out.println("Pop: " + stack.pop());

        System.out.println(stack);
    }
}
```

Output:
```
[A, B, C]
Peek: C
Pop: C
[A, B]
```

---

# 5️⃣ Important Notes

- Stack is synchronized (because it extends Vector)
- It is a legacy class
- Not recommended for modern usage

---

# 6️⃣ Why Stack Is Not Recommended

Because:

- It is synchronized (slower)
- It extends Vector (bad design choice)
- Modern alternative exists

---

# 7️⃣ Modern Replacement for Stack

Use:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

Push:
```java
stack.push(10);
```

Pop:
```java
stack.pop();
```

Peek:
```java
stack.peek();
```

ArrayDeque is:
- Faster
- Not synchronized
- Better design

---

# 8️⃣ Time Complexity

| Operation | Time Complexity |
|------------|----------------|
| push() | O(1) |
| pop() | O(1) |
| peek() | O(1) |

---

# 9️⃣ Interview Questions

Q: Why is Stack considered legacy?

Answer:
Stack extends Vector, making it synchronized and slower. Modern Java recommends using ArrayDeque for stack operations.

Q: What principle does Stack follow?

Answer:
LIFO (Last In First Out).

---

# 🔟 Interview Summary

Stack is a legacy class that implements a LIFO data structure. It extends Vector and is synchronized, making it slower. Modern Java recommends using ArrayDeque instead of Stack.

---

# Java CopyOnWriteArrayList – Complete Guide (Interview Preparation)

---

# 1️⃣ What is CopyOnWriteArrayList?

CopyOnWriteArrayList is a thread-safe variant of ArrayList.

Package:
```java
import java.util.concurrent.CopyOnWriteArrayList;
```

It is designed for concurrent (multi-threaded) environments.

---

# 2️⃣ What Does "Copy On Write" Mean?

Whenever a modification happens (add, remove, set):

✔ A new copy of the underlying array is created  
✔ The modification happens on the new copy  
✔ Old array remains unchanged  

Read operations do NOT require locking.

---

# 3️⃣ Why Is It Useful?

In multi-threaded applications:

- Many threads read data
- Few threads modify data

CopyOnWriteArrayList is ideal when:

✔ Reads are frequent  
✔ Writes are rare  

---

# 4️⃣ Internal Working

When you do:

```java
list.add("A");
```

Steps:
1. Create new array
2. Copy old elements
3. Add new element
4. Replace reference

This makes write operations expensive.

But read operations:

```java
list.get(0);
```

Are very fast and do not require synchronization.

---

# 5️⃣ Basic Example

```java
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list);

        list.remove("B");

        System.out.println(list);
    }
}
```

Output:
```
[A, B, C]
[A, C]
```

---

# 6️⃣ Important Feature: Safe Iteration

In normal ArrayList:

Modifying during iteration causes:

```
ConcurrentModificationException
```

Example (ArrayList problem):

```java
for(String s : list) {
    list.remove(s); // Exception
}
```

But CopyOnWriteArrayList does NOT throw this exception.

It iterates over a snapshot of the array.

---

# 7️⃣ Time Complexity

| Operation | Complexity |
|------------|------------|
| get() | O(1) |
| add() | O(n) |
| remove() | O(n) |

Write operations are expensive because copying happens.

---

# 8️⃣ When to Use CopyOnWriteArrayList

Use when:

✔ Multi-threaded environment  
✔ Read operations are frequent  
✔ Write operations are rare  

Example:
- Event listener lists
- Configuration lists

---

# 9️⃣ When NOT to Use

Avoid when:

❌ Frequent writes  
❌ Large data sets  
❌ Memory-sensitive systems  

Because each write creates a new array copy.

---

# 🔟 CopyOnWriteArrayList vs Vector

| Feature | Vector | CopyOnWriteArrayList |
|----------|--------|----------------------|
| Thread Safe | Yes | Yes |
| Synchronization | Method-level | Copy-on-write |
| Read Performance | Slower | Faster |
| Write Performance | Moderate | Expensive |
| Iterator Safety | Fail-fast | Fail-safe |

---

# 1️⃣1️⃣ Fail-Fast vs Fail-Safe

Fail-Fast:
Throws ConcurrentModificationException  
Example: ArrayList, Vector

Fail-Safe:
Works on a snapshot  
No exception  
Example: CopyOnWriteArrayList

---

# 1️⃣2️⃣ Interview Summary

CopyOnWriteArrayList is a thread-safe implementation of List where modifications create a new copy of the underlying array. It is best suited for scenarios where reads are frequent and writes are rare. It provides fail-safe iteration and avoids ConcurrentModificationException.

---
