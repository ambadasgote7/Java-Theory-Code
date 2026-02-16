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



