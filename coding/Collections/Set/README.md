# Java Set Interface – Complete Guide (Interview Preparation)

---

# 1️⃣ What is Set?

Set is an interface in Java that represents a collection of **unique elements**.

It does **not allow duplicates**.

Set is part of the **Java Collections Framework** and is located in:

```java
java.util package
```

It models the mathematical concept of a set.

---

# 2️⃣ Set Hierarchy

```
Iterable
   ↓
Collection
   ↓
Set
   ↳ HashSet
   ↳ LinkedHashSet
   ↳ TreeSet
   ↳ EnumSet
   ↳ CopyOnWriteArraySet
   ↳ ConcurrentSkipListSet
```

---

# 3️⃣ Key Features

✔ No duplicate elements allowed
✔ Allows at most one null element (depends on implementation)
✔ Not index-based (no positional access like List)
✔ Unordered by default (HashSet)
✔ Some implementations maintain order (LinkedHashSet, TreeSet)
✔ Supports mathematical set operations

---

# 4️⃣ How to Create Set in Java

### 1️⃣ Using HashSet

```java
Set<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
set.add(30);
```

---

### 2️⃣ Using LinkedHashSet

```java
Set<Integer> set = new LinkedHashSet<>();
```

---

### 3️⃣ Using TreeSet

```java
Set<Integer> set = new TreeSet<>();
```

---

### 4️⃣ Immutable Set (Java 9+)

```java
Set<Integer> set = Set.of(1, 2, 3, 4);
```

---

# 5️⃣ Important Methods

| Method             | Description          |
| ------------------ | -------------------- |
| add(E e)           | Adds element         |
| remove(Object o)   | Removes element      |
| contains(Object o) | Checks element       |
| size()             | Returns size         |
| isEmpty()          | Checks empty         |
| clear()            | Removes all elements |
| iterator()         | Returns iterator     |

---

# 6️⃣ Time Complexity

Depends on implementation:

| Implementation | Add      | Remove   | Search   |
| -------------- | -------- | -------- | -------- |
| HashSet        | O(1)     | O(1)     | O(1)     |
| LinkedHashSet  | O(1)     | O(1)     | O(1)     |
| TreeSet        | O(log n) | O(log n) | O(log n) |

---

# 7️⃣ Why Set Does Not Allow Duplicates

Set uses:

```
hashCode()
equals()
```

to identify uniqueness of elements.

If both match → duplicate ignored.

---

# 8️⃣ Set vs List

| Feature      | List         | Set         |
| ------------ | ------------ | ----------- |
| Duplicates   | Allowed      | Not allowed |
| Order        | Maintained   | Depends     |
| Index Access | Yes          | No          |
| Nulls        | Multiple     | Usually one |
| Use Case     | Ordered data | Unique data |

---

# 9️⃣ Null Rules

| Implementation        | Null Allowed |
| --------------------- | ------------ |
| HashSet               | Yes (one)    |
| LinkedHashSet         | Yes (one)    |
| TreeSet               | No           |
| EnumSet               | No           |
| ConcurrentSkipListSet | No           |

---

# 🔟 When to Use Set

Use when:

✔ Unique elements required
✔ Duplicate removal needed
✔ Fast lookup required
✔ Membership checking needed

---

# 1️⃣1️⃣ When NOT to Use

Avoid when:

❌ Order is important (use List)
❌ Index access required
❌ Duplicate data needed

---

# 1️⃣2️⃣ Real-World Examples

* Unique usernames
* Email storage
* Tags system
* Permissions
* Removing duplicates from list
* Cache keys

---

# 1️⃣3️⃣ Internal Working Concept

Set itself is an interface.

Implementations use different structures:

```
HashSet → HashMap
LinkedHashSet → HashMap + Linked List
TreeSet → Red-Black Tree
```

---

# 1️⃣4️⃣ Interview Questions

Q: What is Set in Java?

Answer:
Set is a collection that does not allow duplicate elements and is part of the Java Collections Framework.

---

Q: Which Set implementation is fastest?

Answer:
HashSet (O(1) average complexity).

---

Q: Can Set contain null?

Answer:
Yes, but depends on implementation (HashSet allows one null, TreeSet does not).

---

Q: Difference between List and Set?

Answer:
List allows duplicates and maintains order, while Set stores unique elements only.

---

# 1️⃣5️⃣ Interview Summary

Set is a collection interface used to store unique elements. It is commonly implemented using HashSet, LinkedHashSet, or TreeSet depending on ordering and performance needs.

---

# Java HashSet – Complete Guide (Interview Preparation)

---

# 1️⃣ What is HashSet?

HashSet is a class in Java that implements the **Set interface** and stores **unique elements**.

It does **not allow duplicates** and does **not maintain insertion order**.

HashSet internally uses a **HashMap** for storage.

It belongs to:

```java
java.util package
```

---

# 2️⃣ Internal Working

HashSet internally works using:

```
HashMap
```

When you add an element:

```
set.add("A");
```

Internally:

```
map.put("A", PRESENT);
```

Where `PRESENT` is a dummy constant object.

So HashSet stores only keys of HashMap.

---

# 3️⃣ HashSet Hierarchy

```
Object
   ↓
AbstractCollection
   ↓
AbstractSet
   ↓
HashSet
```

Implements:

```
Set
Cloneable
Serializable
Iterable
Collection
```

---

# 4️⃣ Key Features

✔ No duplicate elements
✔ Allows one null element
✔ Unordered collection
✔ Not synchronized (not thread-safe)
✔ Fast performance (O(1) average)
✔ Uses hashing mechanism

---

# 5️⃣ How to Create HashSet

### 1️⃣ Default Constructor

```java
HashSet<Integer> set = new HashSet<>();
```

---

### 2️⃣ With Initial Capacity

```java
HashSet<Integer> set = new HashSet<>(100);
```

---

### 3️⃣ From Another Collection

```java
List<Integer> list = Arrays.asList(1,2,3);

HashSet<Integer> set = new HashSet<>(list);
```

---

# 6️⃣ Important Methods

| Method             | Description      |
| ------------------ | ---------------- |
| add(E e)           | Adds element     |
| remove(Object o)   | Removes element  |
| contains(Object o) | Checks element   |
| size()             | Returns size     |
| isEmpty()          | Checks empty     |
| clear()            | Removes all      |
| iterator()         | Returns iterator |

---

# 7️⃣ Example

```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate ignored

        System.out.println(set);
    }
}
```

Output (order may vary):

```
[Banana, Apple]
```

---

# 8️⃣ Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Add       | O(1)       |
| Remove    | O(1)       |
| Search    | O(1)       |

Worst case: O(n) (hash collision).

---

# 9️⃣ Why HashSet is Fast

Because it uses:

```
Hashing
```

Elements are stored based on hashCode → direct bucket access.

No traversal required like list.

---

# 🔟 HashSet vs ArrayList

| Feature      | HashSet        | ArrayList  |
| ------------ | -------------- | ---------- |
| Duplicates   | Not allowed    | Allowed    |
| Order        | Not maintained | Maintained |
| Search       | Fast O(1)      | Slow O(n)  |
| Null         | One allowed    | Multiple   |
| Index Access | No             | Yes        |

---

# 1️⃣1️⃣ Null Rules

HashSet allows only **one null** element.

Example:

```java
set.add(null);
set.add(null); // ignored
```

---

# 1️⃣2️⃣ When to Use HashSet

Use when:

✔ Unique elements required
✔ Fast lookup needed
✔ Order not important
✔ Duplicate removal needed

---

# 1️⃣3️⃣ When NOT to Use

Avoid when:

❌ Order matters
❌ Sorting required
❌ Index-based access needed

Use:

```
LinkedHashSet → Order
TreeSet → Sorted
```

---

# 1️⃣4️⃣ Real-World Examples

* Unique usernames
* Tags system
* Cache keys
* Removing duplicates from list
* Permission systems
* Unique IDs storage

---

# 1️⃣5️⃣ Interview Questions

Q: How does HashSet prevent duplicates?

Answer:
Using `hashCode()` and `equals()` methods.

---

Q: What is the internal data structure of HashSet?

Answer:
HashMap.

---

Q: Is HashSet thread-safe?

Answer:
No.

Use:

```java
Collections.synchronizedSet()
```

---

Q: Why order is not maintained?

Answer:
Because hashing determines storage location.

---

# 1️⃣6️⃣ Interview Summary

HashSet is a collection class that stores unique elements using hashing and provides constant time performance for basic operations. It is best used when uniqueness and speed are required but ordering is not important.

---

# Java LinkedHashSet – Complete Guide (Interview Preparation)

---

# 1️⃣ What is LinkedHashSet?

LinkedHashSet is a class in Java that implements the **Set interface** and stores **unique elements** while **maintaining insertion order**.

It is similar to HashSet but with predictable iteration order.

LinkedHashSet belongs to:

```java
java.util package
```

---

# 2️⃣ Internal Working

LinkedHashSet internally uses:

```
LinkedHashMap
```

Structure:

```
Hash Table + Doubly Linked List
```

Hash table → Fast operations
Linked list → Maintains insertion order

---

# 3️⃣ LinkedHashSet Hierarchy

```
Object
   ↓
AbstractCollection
   ↓
AbstractSet
   ↓
HashSet
   ↓
LinkedHashSet
```

Implements:

```
Set
Cloneable
Serializable
Iterable
Collection
```

---

# 4️⃣ Key Features

✔ No duplicate elements
✔ Maintains insertion order
✔ Allows one null element
✔ Not synchronized (not thread-safe)
✔ Faster than TreeSet
✔ Slightly slower than HashSet

---

# 5️⃣ How to Create LinkedHashSet

### 1️⃣ Default Constructor

```java
LinkedHashSet<Integer> set = new LinkedHashSet<>();
```

---

### 2️⃣ With Initial Capacity

```java
LinkedHashSet<Integer> set = new LinkedHashSet<>(100);
```

---

### 3️⃣ From Collection

```java
List<Integer> list = Arrays.asList(1,2,3);

LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
```

---

# 6️⃣ Important Methods

| Method             | Description      |
| ------------------ | ---------------- |
| add(E e)           | Adds element     |
| remove(Object o)   | Removes element  |
| contains(Object o) | Checks element   |
| size()             | Returns size     |
| isEmpty()          | Checks empty     |
| clear()            | Removes all      |
| iterator()         | Returns iterator |

(Same as HashSet because it extends HashSet)

---

# 7️⃣ Example

```java
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {

        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Mango");

        System.out.println(set);
    }
}
```

Output:

```
[Apple, Banana, Mango]
```

Order preserved.

---

# 8️⃣ Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Add       | O(1)       |
| Remove    | O(1)       |
| Search    | O(1)       |

---

# 9️⃣ LinkedHashSet vs HashSet

| Feature            | HashSet        | LinkedHashSet   |
| ------------------ | -------------- | --------------- |
| Order              | Not maintained | Maintained      |
| Performance        | Faster         | Slightly slower |
| Null Allowed       | Yes            | Yes             |
| Internal Structure | HashMap        | LinkedHashMap   |

---

# 🔟 When to Use LinkedHashSet

Use when:

✔ Unique elements required
✔ Insertion order must be preserved
✔ Fast lookup needed

Example:

* Recently visited items
* Cache implementations
* Order-sensitive unique collections

---

# 1️⃣1️⃣ When NOT to Use

Avoid when:

❌ Sorting required → Use TreeSet
❌ Maximum performance needed → Use HashSet

---

# 1️⃣2️⃣ Real-World Examples

* Browser history
* Recently viewed products
* Ordered unique tags
* LRU cache base structure

---

# 1️⃣3️⃣ Interview Questions

Q: Difference between HashSet and LinkedHashSet?

Answer:
HashSet does not maintain order, LinkedHashSet maintains insertion order using a linked list.

---

Q: What is internal data structure?

Answer:
LinkedHashMap (Hash table + Doubly linked list).

---

Q: Is LinkedHashSet thread-safe?

Answer:
No.

Use:

```java
Collections.synchronizedSet()
```

---

Q: Performance difference from HashSet?

Answer:
LinkedHashSet is slightly slower due to linked list maintenance.

---

# 1️⃣4️⃣ Interview Summary

LinkedHashSet is a Set implementation that stores unique elements while maintaining insertion order using a combination of hashing and a doubly linked list. It provides near constant time performance with predictable iteration order.

---

# Java TreeSet – Complete Guide (Interview Preparation)

---

# 1️⃣ What is TreeSet?

TreeSet is a class in Java that implements the **Set interface** and stores **unique elements in sorted order**.

The sorting is based on:

✔ Natural ordering (Comparable)
✔ Custom comparator (Comparator)

TreeSet internally uses a **Red-Black Tree (self-balancing binary search tree)**.

It belongs to:

```java
java.util package
```

---

# 2️⃣ Internal Working

TreeSet internally uses:

```
TreeMap
```

Structure:

```
Red-Black Tree
```

When you add element:

```
set.add(10);
```

Internally:

```
map.put(10, PRESENT);
```

So TreeSet stores only keys of TreeMap.

---

# 3️⃣ TreeSet Hierarchy

```
Object
   ↓
AbstractCollection
   ↓
AbstractSet
   ↓
TreeSet
```

Implements:

```
Set
NavigableSet
SortedSet
Cloneable
Serializable
Iterable
Collection
```

---

# 4️⃣ Key Features

✔ No duplicate elements
✔ Sorted order maintained
✔ Does NOT allow null elements
✔ Not synchronized (not thread-safe)
✔ Provides navigation methods
✔ Slower than HashSet (log n operations)

---

# 5️⃣ How to Create TreeSet

### 1️⃣ Default Constructor (Natural Sorting)

```java
TreeSet<Integer> set = new TreeSet<>();
```

---

### 2️⃣ Custom Comparator

```java
TreeSet<Integer> set = new TreeSet<>(
        (a, b) -> b - a
);
```

Descending order.

---

### 3️⃣ From Collection

```java
List<Integer> list = Arrays.asList(5,3,1);

TreeSet<Integer> set = new TreeSet<>(list);
```

---

# 6️⃣ Important Methods

| Method             | Description      |
| ------------------ | ---------------- |
| add(E e)           | Adds element     |
| remove(Object o)   | Removes element  |
| contains(Object o) | Checks element   |
| first()            | Smallest element |
| last()             | Largest element  |
| higher(E e)        | Next greater     |
| lower(E e)         | Next smaller     |
| ceiling(E e)       | ≥ element        |
| floor(E e)         | ≤ element        |
| pollFirst()        | Remove first     |
| pollLast()         | Remove last      |

---

# 7️⃣ Example

```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>();

        set.add(50);
        set.add(10);
        set.add(30);
        set.add(20);

        System.out.println(set);
    }
}
```

Output:

```
[10, 20, 30, 50]
```

Sorted automatically.

---

# 8️⃣ Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Add       | O(log n)   |
| Remove    | O(log n)   |
| Search    | O(log n)   |

Because of Red-Black Tree.

---

# 9️⃣ TreeSet vs HashSet

| Feature      | HashSet     | TreeSet           |
| ------------ | ----------- | ----------------- |
| Order        | No order    | Sorted            |
| Performance  | Faster O(1) | Slower O(log n)   |
| Null Allowed | Yes         | No                |
| Structure    | HashMap     | TreeMap / RB Tree |

---

# 🔟 Null Rules

TreeSet does **NOT allow null**.

Example:

```java
set.add(null); // NullPointerException
```

Because comparison required for sorting.

---

# 1️⃣1️⃣ When to Use TreeSet

Use when:

✔ Sorted unique data required
✔ Range operations needed
✔ Navigation operations required

Examples:

* Leaderboards
* Ranking systems
* Sorted logs
* Dictionary implementations

---

# 1️⃣2️⃣ When NOT to Use

Avoid when:

❌ Maximum performance required → Use HashSet
❌ Order not needed

---

# 1️⃣3️⃣ Real-World Examples

* Score ranking
* Event scheduling
* Sorted user IDs
* Priority-based collections

---

# 1️⃣4️⃣ Interview Questions

Q: What is internal structure of TreeSet?

Answer:
TreeMap (Red-Black Tree).

---

Q: Why TreeSet is slower than HashSet?

Answer:
Because TreeSet uses tree structure (O log n) while HashSet uses hashing (O 1 average).

---

Q: Can TreeSet store null?

Answer:
No.

---

Q: Difference between TreeSet and LinkedHashSet?

Answer:
TreeSet → Sorted order
LinkedHashSet → Insertion order

---

# 1️⃣5️⃣ Interview Summary

TreeSet is a Set implementation that stores unique elements in sorted order using a Red-Black Tree. It provides navigation methods and logarithmic time complexity operations, making it suitable for sorted collections and range queries.

---

# Java EnumSet – Complete Guide (Interview Preparation)

---

# 1️⃣ What is EnumSet?

EnumSet is a specialized **Set implementation** designed specifically for use with **enum types**.

It stores only enum values and is highly optimized and efficient.

EnumSet belongs to:

```java
java.util package
```

---

# 2️⃣ Key Characteristics

✔ Only enum elements allowed
✔ Very fast and memory efficient
✔ Internally represented as bit vector
✔ Maintains natural order of enum constants
✔ Not synchronized (not thread-safe)
✔ Does NOT allow null

---

# 3️⃣ Why EnumSet is Special

EnumSet is much faster than HashSet because:

```
No hashing
No tree structure
Uses bit manipulation internally
```

So performance is extremely high.

---

# 4️⃣ EnumSet Hierarchy

```
Object
   ↓
AbstractCollection
   ↓
AbstractSet
   ↓
EnumSet
```

Implements:

```
Set
Cloneable
Serializable
Iterable
Collection
```

---

# 5️⃣ Internal Working

EnumSet uses:

```
Bit Vector (Bitwise Operations)
```

Each enum constant is stored as a bit position.

Example:

```
MONDAY → 0001
TUESDAY → 0010
WEDNESDAY → 0100
```

This makes operations extremely fast.

---

# 6️⃣ Creating EnumSet

### Step 1: Create Enum

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}
```

---

### 1️⃣ allOf()

Creates set containing all enum constants.

```java
EnumSet<Day> set = EnumSet.allOf(Day.class);
```

---

### 2️⃣ noneOf()

Creates empty EnumSet.

```java
EnumSet<Day> set = EnumSet.noneOf(Day.class);
```

---

### 3️⃣ of()

Creates with specific elements.

```java
EnumSet<Day> set = EnumSet.of(Day.MONDAY, Day.FRIDAY);
```

---

### 4️⃣ range()

Creates range between two enum constants.

```java
EnumSet<Day> set =
        EnumSet.range(Day.MONDAY, Day.WEDNESDAY);
```

---

# 7️⃣ Example

```java
import java.util.EnumSet;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY
}

public class EnumSetExample {

    public static void main(String[] args) {

        EnumSet<Day> set =
                EnumSet.of(Day.MONDAY, Day.WEDNESDAY);

        System.out.println(set);
    }
}
```

Output:

```
[MONDAY, WEDNESDAY]
```

---

# 8️⃣ Time Complexity

All operations:

```
O(1)
```

Because bitwise operations are constant time.

---

# 9️⃣ EnumSet vs HashSet

| Feature      | EnumSet            | HashSet    |
| ------------ | ------------------ | ---------- |
| Data Type    | Enum only          | Any object |
| Performance  | Faster             | Slower     |
| Memory       | Very low           | Higher     |
| Internal     | Bit vector         | HashMap    |
| Null Allowed | No                 | Yes        |
| Order        | Natural enum order | No order   |

---

# 🔟 Null Rules

EnumSet does **NOT allow null**.

Example:

```java
set.add(null); // NullPointerException
```

---

# 1️⃣1️⃣ When to Use EnumSet

Use when:

✔ Working with enum values
✔ High performance needed
✔ Memory efficiency required
✔ Flag-based logic

Examples:

* Permissions (READ, WRITE, EXECUTE)
* Days of week
* States of system
* Feature flags

---

# 1️⃣2️⃣ When NOT to Use

Avoid when:

❌ Non-enum objects needed
❌ Dynamic object storage required

---

# 1️⃣3️⃣ Real-World Examples

* Role permissions
* Application states
* Feature toggles
* Game modes
* Workflow states

---

# 1️⃣4️⃣ Interview Questions

Q: Why EnumSet is faster than HashSet?

Answer:
Because it uses bitwise operations instead of hashing.

---

Q: Can EnumSet store null?

Answer:
No.

---

Q: What is internal structure of EnumSet?

Answer:
Bit vector (bit mask representation).

---

Q: Does EnumSet maintain order?

Answer:
Yes, natural order of enum constants.

---

# 1️⃣5️⃣ Interview Summary

EnumSet is a high-performance Set implementation designed specifically for enum types. It uses bitwise operations internally, making it extremely fast and memory efficient compared to other Set implementations.

---

# Java Collections.synchronizedSet() – Quick Guide

## What is synchronizedSet?

`Collections.synchronizedSet()` is a method that returns a **thread-safe (synchronized) Set**.

It wraps an existing Set and makes all operations **synchronized** to allow safe use in multi-threaded environments.

---

## How to Create

```java
import java.util.*;

Set<Integer> set = new HashSet<>();

Set<Integer> syncSet =
        Collections.synchronizedSet(set);
```

---

## Key Points

✔ Thread-safe
✔ Wrapper over existing Set
✔ Allows concurrent access from multiple threads
✔ Slower than normal Set (due to synchronization)
✔ Must manually synchronize during iteration

---

## Iteration Rule (Important)

When iterating, you must synchronize manually:

```java
synchronized (syncSet) {
    for (Integer i : syncSet) {
        System.out.println(i);
    }
}
```

---

## When to Use

Use when:

✔ Multiple threads modify the same Set
✔ Simple thread safety needed

---

## Alternative (Better for Concurrency)

```java
CopyOnWriteArraySet
ConcurrentSkipListSet
```

These are modern concurrent collections.

---

## Interview Point

> Collections.synchronizedSet() provides thread safety by synchronizing every method call on the Set object.

---

# Java ConcurrentSkipListSet – Quick Guide

## What is ConcurrentSkipListSet?

ConcurrentSkipListSet is a **thread-safe, sorted Set implementation** that allows concurrent access by multiple threads without external synchronization.

It belongs to:

```java
java.util.concurrent package
```

It maintains elements in **sorted order** (natural or comparator).

---

## Internal Working

ConcurrentSkipListSet uses:

```
ConcurrentSkipListMap
```

Data structure:

```
Skip List (layered linked list)
```

Skip list provides:

✔ Logarithmic time performance
✔ Better concurrency than synchronized collections

---

## Key Features

✔ Thread-safe (concurrent)
✔ Sorted elements
✔ No duplicates allowed
✔ Does NOT allow null
✔ Non-blocking reads
✔ Scalable in multi-threaded environments

---

## How to Create

```java
import java.util.concurrent.ConcurrentSkipListSet;

ConcurrentSkipListSet<Integer> set =
        new ConcurrentSkipListSet<>();

set.add(10);
set.add(5);
set.add(20);
```

Output (sorted):

```
[5, 10, 20]
```

---

## Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Add       | O(log n)   |
| Remove    | O(log n)   |
| Search    | O(log n)   |

---

## When to Use

Use when:

✔ Thread-safe sorted data required
✔ High concurrency needed
✔ Range operations required

Examples:

* Leaderboards
* Real-time ranking
* Concurrent scheduling systems

---

## Difference vs TreeSet

| Feature      | TreeSet        | ConcurrentSkipListSet  |
| ------------ | -------------- | ---------------------- |
| Thread Safe  | No             | Yes                    |
| Performance  | Single-thread  | Multi-thread optimized |
| Structure    | Red-Black Tree | Skip List              |
| Null Allowed | No             | No                     |

---

## Interview Point

> ConcurrentSkipListSet provides a scalable concurrent alternative to TreeSet using a skip list data structure.

---

# Java SortedSet – Quick Guide

## What is SortedSet?

SortedSet is an interface that extends **Set** and stores elements in **sorted order**.

Sorting can be:

✔ Natural ordering (Comparable)
✔ Custom ordering (Comparator)

It belongs to:

```java
java.util package
```

---

## Key Features

✔ No duplicate elements
✔ Elements stored in sorted order
✔ Does NOT allow null (most implementations)
✔ Provides range operations
✔ Navigation methods available

---

## Main Implementation

```
TreeSet
```

TreeSet is the most common class implementing SortedSet.

---

## Important Methods

| Method                 | Description                 |
| ---------------------- | --------------------------- |
| first()                | Returns smallest element    |
| last()                 | Returns largest element     |
| headSet(E toElement)   | Elements less than value    |
| tailSet(E fromElement) | Elements greater than value |
| subSet(E from, E to)   | Range between values        |
| comparator()           | Returns comparator          |

---

## Example

```java
import java.util.*;

SortedSet<Integer> set = new TreeSet<>();

set.add(30);
set.add(10);
set.add(20);

System.out.println(set);
```

Output:

```
[10, 20, 30]
```

---

## When to Use

Use when:

✔ Sorted unique elements required
✔ Range operations needed
✔ Navigation operations required

---

## Interview Point

> SortedSet maintains elements in sorted order and is typically implemented using TreeSet.

---

# Java CopyOnWriteArraySet – Quick Guide

## What is CopyOnWriteArraySet?

CopyOnWriteArraySet is a **thread-safe Set implementation** where every modification creates a **new copy of the underlying array**.

It belongs to:

```java
java.util.concurrent package
```

---

## Internal Working

Uses:

```
CopyOnWriteArrayList internally
```

On modification:

```
Old Array → Copy → Modify → Replace
```

This makes reads safe without locking.

---

## Key Features

✔ Thread-safe (no manual synchronization needed)
✔ No duplicates allowed
✔ Maintains insertion order
✔ Safe iteration (no ConcurrentModificationException)
✔ Very fast reads
✔ Slow writes (due to copying)

---

## How to Create

```java
import java.util.concurrent.CopyOnWriteArraySet;

CopyOnWriteArraySet<Integer> set =
        new CopyOnWriteArraySet<>();

set.add(10);
set.add(20);
```

---

## When to Use

Use when:

✔ Read operations >> Write operations
✔ Multi-threaded environment
✔ Iteration safety required

Examples:

* Event listeners
* Subscriber lists
* Configuration snapshots

---

## Interview Point

> CopyOnWriteArraySet is best for concurrent read-heavy scenarios where modifications are rare.

---

