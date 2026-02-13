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




