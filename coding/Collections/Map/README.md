# Java Map – Complete Guide (Interview Preparation)

---

# 1️⃣ What is Map?

Map is a data structure that stores elements in **key–value pairs**.

Example:
```
ID → Name
101 → Rahul
102 → Amit
103 → Neha
```

Instead of storing single values, Map stores:

```
Key → Value
```

---

# 2️⃣ Important Interview Point

Map is part of the **Java Collections Framework**, but it does **NOT extend the Collection interface**.

Hierarchy:

```
Map (interface)
  |
  ├── HashMap
  ├── LinkedHashMap
  ├── TreeMap
  ├── Hashtable
  └── ConcurrentHashMap
```

Interview Answer:

> Map is part of the Collections Framework but does not extend Collection.

---

# 3️⃣ Key Rules of Map

✔ Keys must be unique  
✔ Values can be duplicate  
✔ Each key maps to exactly one value  

If duplicate key is inserted:

Old value is replaced.

Example:

```java
map.put(101, "Rahul");
map.put(101, "Amit");
```

Final stored value:
```
101 → Amit
```

---

# 4️⃣ Real-Life Examples

- Aadhaar Number → Person
- Email → User
- Username → Password
- ProductID → Product
- Roll Number → Student

Maps are widely used in backend systems.

---

# 5️⃣ Common Map Methods

```java
put(key, value)        // Insert or update
get(key)               // Retrieve value
remove(key)            // Delete entry
containsKey(key)       // Check key presence
containsValue(value)   // Check value presence
size()                 // Number of entries
isEmpty()              // Check if empty
clear()                // Remove all entries
```

---

# 6️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(101, "Rahul");
        map.put(102, "Amit");
        map.put(103, "Neha");

        System.out.println(map);

        System.out.println(map.get(102));

        map.remove(101);

        System.out.println(map);
    }
}
```

Output (HashMap order not guaranteed):

```
{101=Rahul, 102=Amit, 103=Neha}
Amit
{102=Amit, 103=Neha}
```

---

# 7️⃣ Iterating Map (Important for Interview)

## Using entrySet() (Best Approach)

```java
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}
```

Most efficient because no extra lookup.

---

## Using keySet()

```java
for (Integer key : map.keySet()) {
    System.out.println(key + " " + map.get(key));
}
```

Less efficient (extra get operation).

---

## Using forEach (Java 8)

```java
map.forEach((k, v) -> System.out.println(k + " " + v));
```

---

# 8️⃣ Important Map Implementations

We will study separately:

- HashMap → Most important (interviews)
- LinkedHashMap → Maintains insertion order
- TreeMap → Sorted map
- Hashtable → Legacy
- ConcurrentHashMap → Thread-safe modern

---

# 9️⃣ Null Rules (General Overview)

| Map Type | Null Key | Null Value |
|----------|----------|------------|
| HashMap | ✔ One allowed | ✔ Multiple |
| LinkedHashMap | ✔ | ✔ |
| TreeMap | ❌ (usually) | ✔ |
| Hashtable | ❌ | ❌ |

---

# 🔟 Performance Concept

Maps provide fast lookup using keys.

Average complexity (HashMap):

```
O(1)
```

We will study internal working later.

---

# 1️⃣1️⃣ Interview Summary

Map is an interface that stores data in key-value pairs where keys are unique and each key maps to a single value. It provides efficient retrieval based on keys and is implemented by classes like HashMap, LinkedHashMap, and TreeMap.

---

# Java HashMap – Complete Guide (Interview Preparation)

---

# 1️⃣ What is HashMap?

HashMap is a class that implements the Map interface and stores data in **key–value pairs** using hashing.

Package:
```java
import java.util.HashMap;
```

---

# 2️⃣ Key Features

✔ Stores data as key → value  
✔ Keys are unique  
✔ Allows one null key  
✔ Allows multiple null values  
✔ Not thread-safe  
✔ Does NOT maintain insertion order  

Output order may appear random.

---

# 3️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(101, "Rahul");
        map.put(102, "Amit");
        map.put(103, "Neha");

        System.out.println(map);

        System.out.println(map.get(102));
    }
}
```

---

# 4️⃣ Internal Working (Important)

HashMap uses:

```
Array + LinkedList (Java 7)
Array + LinkedList + Red-Black Tree (Java 8+)
```

Internal structure:

```
Node<K,V>[] table
```

Each index is called a **bucket**.

---

# 5️⃣ How put() Works Internally

When inserting:

```java
map.put(key, value);
```

Steps:

1. Calculate hash:
```
hash = key.hashCode()
```

2. Convert hash into index:
```
index = hash % arraySize
```

3. Insert into bucket:
- If empty → store node
- If collision → store in linked list or tree

---

# 6️⃣ Collision (Very Important)

Collision occurs when:

Two different keys produce the same bucket index.

Example:

```
Key1 → index 5
Key2 → index 5
```

Both are stored in the same bucket using linked list or tree.

---

# 7️⃣ Java 8 Optimization (Treeification)

If bucket size becomes large:

Linked list converts into **Red-Black Tree**.

Condition:

```
Bucket size ≥ 8
```

Performance improves:

```
O(n) → O(log n)
```

---

# 8️⃣ Time Complexity

Average Case:

| Operation | Complexity |
|------------|------------|
| put() | O(1) |
| get() | O(1) |
| remove() | O(1) |

Worst Case:

Before Java 8:
```
O(n)
```

After Java 8:
```
O(log n)
```

---

# 9️⃣ Default Capacity and Load Factor

Default values:

```
Initial Capacity = 16
Load Factor = 0.75
```

Resize condition:

```
size > capacity × loadFactor
```

Example:

```
16 × 0.75 = 12
```

When inserting the 13th element → resizing occurs.

---

# 🔟 Resizing (Rehashing)

When threshold exceeds:

- Array size doubles
- Elements rehashed
- Reinserted into new buckets

Example:

```
16 → 32 → 64 → 128
```

Resizing is an expensive operation.

---

# 1️⃣1️⃣ Why Only One Null Key?

Null key always maps to index 0 internally.

Allowing multiple null keys would cause conflicts.

Values can have multiple null entries.

---

# 1️⃣2️⃣ Internal Node Structure

Java 8 Node:

```
class Node<K,V> {
    int hash;
    K key;
    V value;
    Node<K,V> next;
}
```

If treeified:

```
TreeNode extends Node
```

---

# 1️⃣3️⃣ HashMap vs Hashtable

| Feature | HashMap | Hashtable |
|----------|----------|-----------|
| Thread Safe | No | Yes |
| Synchronization | No | Yes |
| Null Key | Allowed (1) | Not Allowed |
| Null Value | Allowed | Not Allowed |
| Performance | Faster | Slower |
| Introduced | Java 1.2 | Java 1.0 |

---

# 1️⃣4️⃣ When to Use HashMap

Use when:

✔ Fast lookup required  
✔ Order not important  
✔ Single-threaded environment  

---

# 1️⃣5️⃣ Important Interview Questions

Q: Why HashMap is fast?

Answer:
Because it uses hashing to directly locate the bucket, giving average O(1) time complexity.

Q: What happens if two keys have same hashCode?

Answer:
Both keys are stored in the same bucket using linked list or tree structure.

---

# 1️⃣6️⃣ Interview Summary

HashMap is a hash table–based implementation of the Map interface that stores key-value pairs using hashing for fast retrieval. It provides average O(1) time complexity for operations and allows one null key and multiple null values.

---

# Java LinkedHashMap – Complete Guide (Interview Preparation)

---

# 1️⃣ What is LinkedHashMap?

LinkedHashMap is a class that extends HashMap and maintains **insertion order** of elements.

Package:
```java
import java.util.LinkedHashMap;
```

Hierarchy:
```
HashMap → LinkedHashMap
```

It combines:
- Hash table (for fast access)
- Doubly linked list (for order)

---

# 2️⃣ Key Features

✔ Maintains insertion order  
✔ Allows one null key  
✔ Allows multiple null values  
✔ Not thread-safe  
✔ Faster than TreeMap  
✔ Slightly slower than HashMap (due to ordering overhead)  

---

# 3️⃣ Internal Working

LinkedHashMap uses:

```
Array + LinkedList + Hashing
```

Additionally, it maintains a **doubly linked list** connecting all entries.

Structure:

```
Head ↔ Node ↔ Node ↔ Node ↔ Tail
```

So iteration follows insertion order.

---

# 4️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(101, "Rahul");
        map.put(103, "Neha");
        map.put(102, "Amit");

        System.out.println(map);
    }
}
```

Output:
```
{101=Rahul, 103=Neha, 102=Amit}
```

Order is preserved.

---

# 5️⃣ LinkedHashMap vs HashMap

| Feature | HashMap | LinkedHashMap |
|----------|----------|---------------|
| Order Maintained | No | Yes |
| Performance | Faster | Slightly Slower |
| Null Key | Allowed | Allowed |
| Null Value | Allowed | Allowed |
| Data Structure | Hash Table | Hash Table + Linked List |

---

# 6️⃣ Access Order Mode (Important Feature)

LinkedHashMap can maintain order based on **access**, not insertion.

Constructor:

```java
LinkedHashMap<K,V>(initialCapacity, loadFactor, accessOrder)
```

If:

```
accessOrder = true
```

Then elements move to end when accessed.

Example:

```java
LinkedHashMap<Integer, String> map =
    new LinkedHashMap<>(16, 0.75f, true);
```

Now calling `get()` changes order.

---

# 7️⃣ LRU Cache (Very Important Interview Topic)

LinkedHashMap is commonly used to implement **LRU Cache**.

LRU = Least Recently Used

Override method:

```java
protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
```

Example:

```java
import java.util.*;

class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > capacity;
    }
}
```

---

# 8️⃣ Time Complexity

Same as HashMap (average case):

| Operation | Complexity |
|------------|------------|
| put() | O(1) |
| get() | O(1) |
| remove() | O(1) |

Extra overhead due to linked list maintenance.

---

# 9️⃣ When to Use LinkedHashMap

Use when:

✔ Order of insertion matters  
✔ Implementing LRU cache  
✔ Need predictable iteration order  

---

# 🔟 When NOT to Use

Avoid when:

❌ Order is not required (use HashMap instead)  
❌ Memory is critical (extra pointers used)  

---

# 1️⃣1️⃣ Internal Node Structure

LinkedHashMap node extends HashMap node:

```
class LinkedHashMap.Entry<K,V> extends HashMap.Node<K,V> {
    Entry<K,V> before, after;
}
```

This creates doubly linked list.

---

# 1️⃣2️⃣ Interview Questions

Q: Difference between HashMap and LinkedHashMap?

Answer:
HashMap does not maintain order, while LinkedHashMap maintains insertion order using a doubly linked list.

Q: How is LRU cache implemented in Java?

Answer:
Using LinkedHashMap with accessOrder = true and overriding removeEldestEntry().

---

# 1️⃣3️⃣ Interview Summary

LinkedHashMap is a hash table and linked list implementation of the Map interface that maintains insertion or access order of elements. It provides predictable iteration order and is commonly used for implementing LRU cache.

---

# Java WeakHashMap – Complete Guide (Interview Preparation)

---

# 1️⃣ What is WeakHashMap?

WeakHashMap is a Map implementation where the keys are stored using **weak references**.

Package:
```java
import java.util.WeakHashMap;
```

This means:

If a key has no strong references elsewhere, it can be **garbage collected**, and the entry will be automatically removed from the map.

---

# 2️⃣ Key Concept: Weak Reference

Normal HashMap:
- Keys are strongly referenced.
- Objects are not garbage collected while present in the map.

WeakHashMap:
- Keys are weakly referenced.
- If no strong reference exists → Garbage Collector removes entry.

---

# 3️⃣ Why WeakHashMap Exists

Used when you want:

✔ Automatic memory cleanup  
✔ Cache-like behavior  
✔ Avoid memory leaks  

Common use cases:
- Metadata storage
- Caching frameworks
- Listener registries

---

# 4️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {

        WeakHashMap<Object, String> map = new WeakHashMap<>();

        Object key = new Object();

        map.put(key, "Value");

        System.out.println("Before GC: " + map);

        key = null;

        System.gc();
        Thread.sleep(1000);

        System.out.println("After GC: " + map);
    }
}
```

Possible Output:

```
Before GC: {java.lang.Object@1b6d3586=Value}
After GC: {}
```

Entry disappears after garbage collection.

---

# 5️⃣ WeakHashMap vs HashMap

| Feature | HashMap | WeakHashMap |
|----------|----------|-------------|
| Reference Type | Strong | Weak |
| Garbage Collection | No auto removal | Auto removal possible |
| Memory Leak Risk | Higher | Lower |
| Performance | Faster | Slightly slower |

---

# 6️⃣ Important Behavior

If key exists elsewhere:

```java
String key = new String("A");
map.put(key, "Value");
```

Then GC will NOT remove it because strong reference exists.

WeakHashMap removes entries only when:

```
No strong references remain
```

---

# 7️⃣ Null Rules

| Feature | Allowed |
|----------|---------|
| Null Key | ✔ Yes |
| Null Value | ✔ Yes |

Same as HashMap.

---

# 8️⃣ Internal Working

WeakHashMap internally uses:

```
WeakReference<K>
```

Keys are wrapped inside WeakReference objects.

When GC clears the reference:

Map detects and removes entry automatically.

---

# 9️⃣ Time Complexity

Same as HashMap (average case):

| Operation | Complexity |
|------------|------------|
| put() | O(1) |
| get() | O(1) |
| remove() | O(1) |

---

# 🔟 When to Use WeakHashMap

Use when:

✔ Memory-sensitive caches  
✔ Automatic cleanup required  
✔ Object lifecycle tied to key usage  

Example:
- Image cache
- Session metadata
- Reflection metadata

---

# 1️⃣1️⃣ When NOT to Use

Avoid when:

❌ Keys must persist permanently  
❌ Predictable behavior required  
❌ Business-critical data storage  

Because entries may disappear unexpectedly after GC.

---

# 1️⃣2️⃣ Interview Questions

Q: What is WeakHashMap?

Answer:
WeakHashMap is a Map implementation where keys are weakly referenced, allowing entries to be automatically removed when keys are no longer strongly referenced and are garbage collected.

Q: Difference between HashMap and WeakHashMap?

Answer:
HashMap uses strong references for keys, while WeakHashMap uses weak references, enabling automatic removal of entries during garbage collection.

---

# 1️⃣3️⃣ Interview Summary

WeakHashMap is a hash table–based Map implementation that stores keys using weak references, allowing entries to be automatically removed when keys are no longer strongly reachable. It is mainly used for memory-sensitive caching and avoiding memory leaks.

---

# Java SortedMap – Complete Guide (Interview Preparation)

---

# 1️⃣ What is SortedMap?

SortedMap is an interface that extends Map and maintains its keys in **sorted order**.

Package:
```java
import java.util.SortedMap;
```

Hierarchy:
```
Map → SortedMap → NavigableMap → TreeMap
```

The most common implementation is:

```
TreeMap
```

---

# 2️⃣ Key Features

✔ Keys are stored in sorted order  
✔ Sorting based on natural order or Comparator  
✔ Does not allow duplicate keys  
✔ Allows multiple values  
✔ Typically does NOT allow null keys (TreeMap)  
✔ Not thread-safe  

---

# 3️⃣ Sorting Mechanism

SortedMap sorts keys using:

1️⃣ Natural Ordering (Comparable)

Example:
```
Integer, String
```

2️⃣ Custom Ordering (Comparator)

Example:
```
Comparator passed in constructor
```

---

# 4️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        SortedMap<Integer, String> map = new TreeMap<>();

        map.put(103, "Neha");
        map.put(101, "Rahul");
        map.put(102, "Amit");

        System.out.println(map);
    }
}
```

Output:
```
{101=Rahul, 102=Amit, 103=Neha}
```

Keys are automatically sorted.

---

# 5️⃣ Important Methods of SortedMap

### firstKey()

Returns smallest key.

```java
map.firstKey();
```

---

### lastKey()

Returns largest key.

```java
map.lastKey();
```

---

### headMap(toKey)

Returns keys less than toKey.

```java
map.headMap(102);
```

---

### tailMap(fromKey)

Returns keys greater than or equal to fromKey.

```java
map.tailMap(102);
```

---

### subMap(fromKey, toKey)

Returns range between keys.

```java
map.subMap(101, 103);
```

---

# 6️⃣ SortedMap vs HashMap

| Feature | HashMap | SortedMap |
|----------|----------|-----------|
| Order | No order | Sorted order |
| Performance | Faster | Slower |
| Implementation | Hash table | Tree (Red-Black Tree) |
| Null Key | Allowed | Not allowed (TreeMap) |

---

# 7️⃣ Internal Implementation

TreeMap (SortedMap implementation) uses:

```
Red-Black Tree
```

Balanced binary search tree structure.

Time Complexity:

| Operation | Complexity |
|------------|------------|
| put() | O(log n) |
| get() | O(log n) |
| remove() | O(log n) |

---

# 8️⃣ When to Use SortedMap

Use when:

✔ Keys must be sorted  
✔ Range queries required  
✔ Ordered traversal needed  

Example:
- Leaderboards
- Rankings
- Time-based data
- Interval queries

---

# 9️⃣ When NOT to Use

Avoid when:

❌ Sorting not required (use HashMap)  
❌ Performance critical with large data  

HashMap is faster for simple lookup.

---

# 🔟 Interview Questions

Q: What is SortedMap?

Answer:
SortedMap is an interface that extends Map and maintains keys in sorted order using natural ordering or a Comparator. The primary implementation is TreeMap.

Q: Difference between HashMap and SortedMap?

Answer:
HashMap does not maintain order, while SortedMap maintains keys in sorted order using a tree-based structure.

---

# 1️⃣1️⃣ Interview Summary

SortedMap is a Map interface that maintains its keys in sorted order. It is typically implemented by TreeMap using a Red-Black Tree, providing O(log n) time complexity for operations and supporting range-based queries.

---

# Java NavigableMap – Complete Guide (Interview Preparation)

---

# 1️⃣ What is NavigableMap?

NavigableMap is an interface that extends SortedMap and provides **navigation methods** for searching keys relative to a given key.

Package:
```java
import java.util.NavigableMap;
```

Hierarchy:
```
Map → SortedMap → NavigableMap → TreeMap
```

The main implementation is:

```
TreeMap
```

---

# 2️⃣ Key Features

✔ Maintains keys in sorted order  
✔ Provides navigation methods (nearest match search)  
✔ Supports range views  
✔ Allows ascending and descending traversal  
✔ Typically does NOT allow null keys (TreeMap)  
✔ Not thread-safe  

---

# 3️⃣ Why NavigableMap Exists

SortedMap gives sorting.

NavigableMap adds:

✔ Find closest key  
✔ Find lower/higher entries  
✔ Reverse order traversal  

Useful in:
- Scheduling systems
- Time-series data
- Ranking systems
- Interval queries

---

# 4️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        NavigableMap<Integer, String> map = new TreeMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");

        System.out.println(map);
    }
}
```

Output:
```
{10=A, 20=B, 30=C, 40=D}
```

---

# 5️⃣ Important Navigation Methods

### lowerKey(key)

Returns greatest key strictly less than given key.

```java
map.lowerKey(25);   // 20
```

---

### floorKey(key)

Returns greatest key less than or equal to given key.

```java
map.floorKey(20);   // 20
```

---

### higherKey(key)

Returns smallest key strictly greater than given key.

```java
map.higherKey(25);  // 30
```

---

### ceilingKey(key)

Returns smallest key greater than or equal to given key.

```java
map.ceilingKey(20); // 20
```

---

# 6️⃣ Entry-Based Methods

These return key-value pairs.

```java
lowerEntry(key)
floorEntry(key)
ceilingEntry(key)
higherEntry(key)
```

Example:

```java
System.out.println(map.ceilingEntry(25));
```

---

# 7️⃣ First and Last Entries

```java
map.firstEntry();
map.lastEntry();
```

---

# 8️⃣ Reverse Order View

```java
map.descendingMap();
```

Reverse traversal.

---

# 9️⃣ Poll Methods (Remove While Accessing)

```java
map.pollFirstEntry();
map.pollLastEntry();
```

Removes and returns entries.

---

# 🔟 Time Complexity

TreeMap implementation:

| Operation | Complexity |
|------------|------------|
| put() | O(log n) |
| get() | O(log n) |
| remove() | O(log n) |
| navigation | O(log n) |

Because it uses Red-Black Tree.

---

# 1️⃣1️⃣ NavigableMap vs SortedMap

| Feature | SortedMap | NavigableMap |
|----------|-----------|--------------|
| Sorting | Yes | Yes |
| Navigation Methods | Limited | Advanced |
| Closest Match Search | No | Yes |
| Reverse Traversal | No | Yes |

NavigableMap is a more powerful version of SortedMap.

---

# 1️⃣2️⃣ When to Use NavigableMap

Use when:

✔ Need nearest key search  
✔ Range queries required  
✔ Ordered data traversal  
✔ Scheduling or ranking systems  

---

# 1️⃣3️⃣ Interview Questions

Q: What is NavigableMap?

Answer:
NavigableMap is an interface that extends SortedMap and provides navigation methods such as floor, ceiling, lower, and higher to find keys relative to a given key.

Q: Which class implements NavigableMap?

Answer:
TreeMap.

---

# 1️⃣4️⃣ Interview Summary

NavigableMap is a sorted map interface that provides navigation methods for finding closest matches to a given key. It is typically implemented using TreeMap, which uses a Red-Black Tree and provides O(log n) time complexity.

---

# Java TreeMap – Complete Guide (Interview Preparation)

---

# 1️⃣ What is TreeMap?

TreeMap is a class that implements NavigableMap and SortedMap interfaces and stores data in **sorted order of keys**.

Package:
```java
import java.util.TreeMap;
```

Hierarchy:
```
Map → SortedMap → NavigableMap → TreeMap
```

---

# 2️⃣ Key Features

✔ Stores key–value pairs  
✔ Maintains keys in sorted order  
✔ Sorting based on natural order or Comparator  
✔ Does NOT allow null keys (usually)  
✔ Allows multiple null values  
✔ Not thread-safe  
✔ Slower than HashMap (due to sorting)  

---

# 3️⃣ Internal Working

TreeMap is implemented using a:

```
Red-Black Tree (Self-balancing Binary Search Tree)
```

This ensures balanced height and predictable performance.

---

# 4️⃣ Time Complexity

Because of Red-Black Tree:

| Operation | Complexity |
|------------|------------|
| put() | O(log n) |
| get() | O(log n) |
| remove() | O(log n) |
| search | O(log n) |

Slower than HashMap (O(1)) but provides ordering.

---

# 5️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(103, "Neha");
        map.put(101, "Rahul");
        map.put(102, "Amit");

        System.out.println(map);
    }
}
```

Output:
```
{101=Rahul, 102=Amit, 103=Neha}
```

Keys are automatically sorted.

---

# 6️⃣ Sorting Using Comparator

Custom sorting:

```java
TreeMap<Integer, String> map =
    new TreeMap<>(Comparator.reverseOrder());
```

Now keys are stored in descending order.

---

# 7️⃣ Important Navigation Methods

TreeMap supports NavigableMap methods:

```java
firstKey()
lastKey()
higherKey()
lowerKey()
ceilingKey()
floorKey()
```

Example:

```java
map.ceilingKey(102);
```

---

# 8️⃣ Entry Methods

```java
firstEntry()
lastEntry()
pollFirstEntry()
pollLastEntry()
```

---

# 9️⃣ Range Methods

```java
headMap(toKey)
tailMap(fromKey)
subMap(fromKey, toKey)
```

Useful for range queries.

---

# 🔟 TreeMap vs HashMap

| Feature | HashMap | TreeMap |
|----------|----------|---------|
| Order | No order | Sorted |
| Performance | Faster | Slower |
| Structure | Hash Table | Red-Black Tree |
| Null Key | Allowed | Not Allowed |
| Null Value | Allowed | Allowed |

---

# 1️⃣1️⃣ TreeMap vs LinkedHashMap

| Feature | LinkedHashMap | TreeMap |
|----------|----------------|---------|
| Order Type | Insertion Order | Sorted Order |
| Performance | Faster | Slower |
| Structure | Hash + Linked List | Tree |

---

# 1️⃣2️⃣ Why Null Key Not Allowed?

TreeMap uses comparison (compareTo or Comparator).

Null cannot be compared → NullPointerException.

Example:

```java
map.put(null, "A"); // Exception
```

---

# 1️⃣3️⃣ When to Use TreeMap

Use when:

✔ Sorted keys required  
✔ Range operations needed  
✔ Navigation methods needed  
✔ Ordered traversal important  

Examples:
- Leaderboards
- Scheduling systems
- Rankings
- Time-based data

---

# 1️⃣4️⃣ When NOT to Use

Avoid when:

❌ Fast lookup required (use HashMap)  
❌ Order not required  

---

# 1️⃣5️⃣ Interview Questions

Q: What data structure does TreeMap use?

Answer:
Red-Black Tree.

Q: Difference between HashMap and TreeMap?

Answer:
HashMap uses hashing and provides O(1) operations without order, while TreeMap uses Red-Black Tree and provides sorted keys with O(log n) operations.

---

# 1️⃣6️⃣ Interview Summary

TreeMap is a Red-Black Tree–based implementation of NavigableMap that stores key-value pairs in sorted order. It provides O(log n) time complexity for operations and supports navigation and range queries.

---

# Java Hashtable – Complete Guide (Interview Preparation)

---

# 1️⃣ What is Hashtable?

Hashtable is a legacy class that implements the Map interface and stores data in **key–value pairs** using hashing.

Package:
```java
import java.util.Hashtable;
```

Hierarchy:
```
Map → Hashtable
```

It was introduced in Java 1.0 (before the Collections Framework).

---

# 2️⃣ Key Features

✔ Stores key–value pairs  
✔ Keys are unique  
✔ Thread-safe (synchronized)  
✔ Does NOT allow null key  
✔ Does NOT allow null value  
✔ Does NOT maintain order  
✔ Slower than HashMap  

---

# 3️⃣ Internal Working

Hashtable uses:

```
Hash Table (Array + Linked List)
```

Similar to HashMap internally, but methods are synchronized.

---

# 4️⃣ Why Hashtable Is Slower

Because methods are synchronized:

```java
public synchronized V put(K key, V value)
```

Synchronization adds overhead.

---

# 5️⃣ Basic Example

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {

        Hashtable<Integer, String> table = new Hashtable<>();

        table.put(101, "Rahul");
        table.put(102, "Amit");
        table.put(103, "Neha");

        System.out.println(table);
    }
}
```

Output:
```
{101=Rahul, 102=Amit, 103=Neha}
```

Order is not guaranteed.

---

# 6️⃣ Null Rules

Hashtable does NOT allow null.

Example:

```java
table.put(null, "A");   // NullPointerException
table.put(101, null);   // NullPointerException
```

Reason:
Hashtable cannot differentiate between missing key and null value.

---

# 7️⃣ Time Complexity

Average case:

| Operation | Complexity |
|------------|------------|
| put() | O(1) |
| get() | O(1) |
| remove() | O(1) |

Worst case:
```
O(n)
```

---

# 8️⃣ Hashtable vs HashMap

| Feature | HashMap | Hashtable |
|----------|----------|-----------|
| Thread Safe | No | Yes |
| Synchronization | No | Yes |
| Null Key | Allowed | Not Allowed |
| Null Value | Allowed | Not Allowed |
| Performance | Faster | Slower |
| Introduced | Java 1.2 | Java 1.0 |

---

# 9️⃣ Hashtable vs ConcurrentHashMap

| Feature | Hashtable | ConcurrentHashMap |
|----------|-----------|-------------------|
| Locking | Whole map | Segment-level |
| Performance | Slower | Faster |
| Modern Usage | Rare | Recommended |

---

# 🔟 Should You Use Hashtable Today?

Almost never.

Better alternatives:

- HashMap → Single-threaded
- ConcurrentHashMap → Multi-threaded

Hashtable is mostly used in legacy code.

---

# 1️⃣1️⃣ When to Use Hashtable

Only when:

✔ Working with legacy APIs  
✔ Old systems requiring synchronization  

---

# 1️⃣2️⃣ Interview Questions

Q: Difference between HashMap and Hashtable?

Answer:
HashMap is not synchronized and allows null keys and values, while Hashtable is synchronized and does not allow null keys or values.

Q: Why Hashtable is considered legacy?

Answer:
Because it was introduced before the Collections Framework and has inefficient synchronization compared to modern alternatives like ConcurrentHashMap.

---

# 1️⃣3️⃣ Interview Summary

Hashtable is a synchronized hash table implementation of the Map interface introduced in Java 1.0. It does not allow null keys or values and is slower due to method-level synchronization. It is considered a legacy class and is rarely used in modern applications.

---

# Java ConcurrentHashMap – Complete Guide (Interview Preparation)

---

# 1️⃣ What is ConcurrentHashMap?

ConcurrentHashMap is a thread-safe implementation of the Map interface designed for high-performance concurrent environments.

Package:
```java
import java.util.concurrent.ConcurrentHashMap;
```

Hierarchy:
```
Map → ConcurrentHashMap
```

It allows multiple threads to read and write simultaneously without locking the entire map.

---

# 2️⃣ Key Features

✔ Thread-safe  
✔ High concurrency performance  
✔ No null keys allowed  
✔ No null values allowed  
✔ Does NOT maintain order  
✔ Faster than Hashtable in multi-threaded environments  
✔ Fail-safe iterator (no ConcurrentModificationException)  

---

# 3️⃣ Why ConcurrentHashMap Exists

Problem with Hashtable:

- Entire map locked during operations
- Poor scalability

ConcurrentHashMap solves this by allowing:

✔ Multiple threads to operate concurrently  
✔ Fine-grained locking  

---

# 4️⃣ Internal Working (Java 7 vs Java 8)

### Java 7

Used **Segment-based locking**:

```
Map divided into segments
Each segment locked separately
```

---

### Java 8 (Modern)

Uses:

```
Array + Linked List + Red-Black Tree + CAS (Compare-And-Swap)
```

No fixed segments.

Uses bucket-level locking and atomic operations.

---

# 5️⃣ Basic Example

```java
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map =
                new ConcurrentHashMap<>();

        map.put(101, "Rahul");
        map.put(102, "Amit");
        map.put(103, "Neha");

        System.out.println(map);
    }
}
```

---

# 6️⃣ Important Methods

Same as Map plus atomic methods:

```java
putIfAbsent()
compute()
computeIfAbsent()
computeIfPresent()
replace()
```

Example:

```java
map.putIfAbsent(101, "NewValue");
```

---

# 7️⃣ Thread Safety Mechanism

ConcurrentHashMap uses:

- CAS (Compare-And-Swap)
- Synchronization on bucket level
- Volatile variables

Allows high concurrency without blocking entire structure.

---

# 8️⃣ Time Complexity

Average case:

| Operation | Complexity |
|------------|------------|
| put() | O(1) |
| get() | O(1) |
| remove() | O(1) |

Worst case:

```
O(log n)  (tree bucket)
```

---

# 9️⃣ Null Rules

ConcurrentHashMap does NOT allow null.

Example:

```java
map.put(null, "A");   // NullPointerException
map.put(101, null);   // NullPointerException
```

Reason:
Avoid ambiguity in concurrent operations.

---

# 🔟 ConcurrentHashMap vs Hashtable

| Feature | Hashtable | ConcurrentHashMap |
|----------|-----------|-------------------|
| Thread Safe | Yes | Yes |
| Locking | Entire Map | Bucket-level |
| Performance | Slower | Faster |
| Null Allowed | No | No |
| Iterator | Fail-fast | Fail-safe |
| Modern Usage | Rare | Recommended |

---

# 1️⃣1️⃣ Fail-Fast vs Fail-Safe

Hashtable Iterator → Fail-fast  
ConcurrentHashMap Iterator → Fail-safe  

Fail-safe means:
No ConcurrentModificationException during iteration.

---

# 1️⃣2️⃣ When to Use ConcurrentHashMap

Use when:

✔ Multi-threaded environment  
✔ High performance required  
✔ Concurrent reads and writes  
✔ Shared data structures  

Example:
- Caches
- Counters
- Session management
- Real-time systems

---

# 1️⃣3️⃣ When NOT to Use

Avoid when:

❌ Single-threaded environment (use HashMap)  
❌ Order required  

---

# 1️⃣4️⃣ Interview Questions

Q: Difference between HashMap and ConcurrentHashMap?

Answer:
HashMap is not thread-safe, while ConcurrentHashMap provides thread safety with high concurrency using bucket-level locking and atomic operations.

Q: Why ConcurrentHashMap does not allow null?

Answer:
To avoid ambiguity between missing values and null values in concurrent operations.

---

# 1️⃣5️⃣ Interview Summary

ConcurrentHashMap is a high-performance thread-safe implementation of Map that allows concurrent read and write operations using fine-grained locking and atomic operations. It is preferred over Hashtable in modern multi-threaded applications.

---

# Java ConcurrentSkipListMap – Complete Guide (Interview Preparation)

---

# 1️⃣ What is ConcurrentSkipListMap?

ConcurrentSkipListMap is a thread-safe implementation of NavigableMap that maintains keys in **sorted order** and supports concurrent access.

Package:
```java
import java.util.concurrent.ConcurrentSkipListMap;
```

Hierarchy:
```
Map → SortedMap → NavigableMap → ConcurrentSkipListMap
```

---

# 2️⃣ Key Features

✔ Thread-safe  
✔ Maintains sorted order of keys  
✔ High concurrency support  
✔ Does NOT allow null keys  
✔ Does NOT allow null values  
✔ Scalable performance  
✔ Supports navigation methods (floor, ceiling, etc.)  

---

# 3️⃣ Internal Data Structure

ConcurrentSkipListMap uses a:

```
Skip List
```

A probabilistic data structure similar to a balanced tree.

Structure idea:

```
Level 3 → 10 ------ 30
Level 2 → 10 -- 20 -- 30 -- 40
Level 1 → 10 -- 15 -- 20 -- 25 -- 30 -- 40
```

Multiple layers allow fast searching.

---

# 4️⃣ Why Skip List?

Advantages over trees in concurrent environments:

✔ Easier to implement concurrency  
✔ Less locking overhead  
✔ Better scalability  

---

# 5️⃣ Time Complexity

Average case:

| Operation | Complexity |
|------------|------------|
| put() | O(log n) |
| get() | O(log n) |
| remove() | O(log n) |
| navigation | O(log n) |

---

# 6️⃣ Basic Example

```java
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {

        ConcurrentSkipListMap<Integer, String> map =
                new ConcurrentSkipListMap<>();

        map.put(30, "C");
        map.put(10, "A");
        map.put(20, "B");

        System.out.println(map);
    }
}
```

Output:
```
{10=A, 20=B, 30=C}
```

Keys are sorted automatically.

---

# 7️⃣ Navigation Methods

Same as NavigableMap:

```java
lowerKey()
floorKey()
ceilingKey()
higherKey()
firstKey()
lastKey()
```

Example:

```java
map.ceilingKey(15);   // 20
```

---

# 8️⃣ ConcurrentSkipListMap vs ConcurrentHashMap

| Feature | ConcurrentHashMap | ConcurrentSkipListMap |
|----------|-------------------|-----------------------|
| Order | No | Sorted |
| Structure | Hash Table | Skip List |
| Performance | Faster (O(1)) | Slower (O(log n)) |
| Navigation Methods | Limited | Full support |
| Use Case | General concurrency | Sorted concurrency |

---

# 9️⃣ Null Rules

ConcurrentSkipListMap does NOT allow null.

Example:

```java
map.put(null, "A");   // NullPointerException
map.put(10, null);    // NullPointerException
```

---

# 🔟 Thread Safety Mechanism

Uses:

- CAS (Compare-And-Swap)
- Lock-free algorithms
- Atomic operations

Allows multiple threads without blocking entire structure.

---

# 1️⃣1️⃣ When to Use ConcurrentSkipListMap

Use when:

✔ Thread-safe sorted map required  
✔ Navigation methods needed  
✔ Range queries in concurrent environment  
✔ Ordered concurrent data  

Examples:
- Real-time leaderboards
- Scheduling systems
- Time-series data
- Financial systems

---

# 1️⃣2️⃣ When NOT to Use

Avoid when:

❌ Sorting not required (use ConcurrentHashMap)  
❌ Maximum speed required  

ConcurrentHashMap is faster for general use.

---

# 1️⃣3️⃣ Interview Questions

Q: What data structure does ConcurrentSkipListMap use?

Answer:
Skip List.

Q: Difference between ConcurrentHashMap and ConcurrentSkipListMap?

Answer:
ConcurrentHashMap is faster and unordered, while ConcurrentSkipListMap maintains sorted order with O(log n) operations using a Skip List.

---

# 1️⃣4️⃣ Interview Summary

ConcurrentSkipListMap is a thread-safe, sorted map implementation based on a skip list data structure. It provides O(log n) operations and supports concurrent access with navigation methods, making it suitable for ordered data in multi-threaded environments.

---
