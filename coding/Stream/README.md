# Java Streams – Interview Focused Guide

---

# 1️⃣ What is Stream?

Stream is a **sequence of elements** that supports **functional-style operations** to process data.

Introduced in:

```
Java 8
```

Stream does NOT store data. It processes data from collections, arrays, or I/O sources.

---

# 2️⃣ Stream Pipeline (Very Important ⭐)

A stream has 3 parts:

```
Source → Intermediate Operations → Terminal Operation
```

Example:

```java
list.stream()
    .filter(x -> x > 10)
    .map(x -> x * 2)
    .forEach(System.out::println);
```

---

# 3️⃣ Ways to Create Streams ⭐

## From Collection

```java
List<Integer> list = List.of(1,2,3);

Stream<Integer> stream = list.stream();
```

---

## From Array

```java
int[] arr = {1,2,3};

IntStream stream = Arrays.stream(arr);
```

---

## Using Stream.of()

```java
Stream<Integer> stream =
        Stream.of(1,2,3,4);
```

---

## Using Stream Builder

```java
Stream<Integer> stream =
        Stream.<Integer>builder()
              .add(1)
              .add(2)
              .build();
```

---

## Infinite Stream

```java
Stream<Integer> stream =
        Stream.iterate(0, n -> n + 1)
              .limit(5);
```

---

## Generate Stream

```java
Stream<Double> stream =
        Stream.generate(Math::random)
              .limit(5);
```

---

# 4️⃣ Important Intermediate Operations ⭐

Intermediate operations return another stream.

They are **lazy** (execute only when terminal called).

## filter()

```java
list.stream()
    .filter(x -> x % 2 == 0);
```

---

## map()

```java
list.stream()
    .map(x -> x * 2);
```

---

## sorted()

```java
list.stream()
    .sorted();
```

---

## distinct()

```java
list.stream()
    .distinct();
```

---

## limit()

```java
list.stream()
    .limit(5);
```

---

## skip()

```java
list.stream()
    .skip(2);
```

---

## flatMap() ⭐ Important

```java
List<List<Integer>> list = ...

list.stream()
    .flatMap(Collection::stream);
```

Used for nested collections.

---

# 5️⃣ Important Terminal Operations ⭐

Terminal operations produce result or side effect.

## forEach()

```java
stream.forEach(System.out::println);
```

---

## collect() ⭐ Most Important

```java
List<Integer> result =
    list.stream()
        .collect(Collectors.toList());
```

---

## count()

```java
long count = stream.count();
```

---

## reduce() ⭐ Very Important

```java
int sum =
    list.stream()
        .reduce(0, (a, b) -> a + b);
```

---

## findFirst()

```java
Optional<Integer> value =
    list.stream().findFirst();
```

---

## anyMatch()

```java
boolean result =
    list.stream()
        .anyMatch(x -> x > 10);
```

---

## allMatch()

```java
stream.allMatch(...)
```

---

## noneMatch()

```java
stream.noneMatch(...)
```

---

# 6️⃣ Real Life Problems (Small Code) ⭐

## 1️⃣ Filter Even Numbers

```java
List<Integer> list = List.of(1,2,3,4,5,6);

list.stream()
    .filter(x -> x % 2 == 0)
    .forEach(System.out::println);
```

---

## 2️⃣ Square Numbers

```java
list.stream()
    .map(x -> x * x)
    .forEach(System.out::println);
```

---

## 3️⃣ Find Max

```java
int max =
    list.stream()
        .max(Integer::compare)
        .get();
```

---

## 4️⃣ Remove Duplicates

```java
list.stream()
    .distinct()
    .forEach(System.out::println);
```

---

## 5️⃣ Sum of Numbers

```java
int sum =
    list.stream()
        .reduce(0, Integer::sum);
```

---

## 6️⃣ Convert List to Map ⭐

```java
Map<Integer, String> map =
    list.stream()
        .collect(Collectors.toMap(
            x -> x,
            x -> "Value" + x
        ));
```

---

# 7️⃣ Stream vs Collection ⭐

| Feature    | Stream     | Collection |
| ---------- | ---------- | ---------- |
| Storage    | No         | Yes        |
| Processing | Functional | Direct     |
| Traversal  | Once       | Multiple   |
| Lazy       | Yes        | No         |

---

# 8️⃣ Parallel Stream ⭐

```java
list.parallelStream()
    .forEach(System.out::println);
```

Uses multiple CPU cores.

---

# 9️⃣ Important Interview Questions ⭐

Q: Difference between map and flatMap?

map → one to one
flatMap → one to many flattening

---

Q: Why streams are lazy?

Because intermediate operations execute only when terminal operation called.

---

Q: Can stream be reused?

No.

---

Q: Difference between forEach and collect?

forEach → side effects
collect → produces result container

---

# 🔟 Interview Summary ⭐

Streams provide a functional way to process collections using operations like filter, map, and reduce. They support lazy evaluation, parallel execution, and concise code, making them a core feature introduced in Java 8.

---

# Java ParallelStream, Collectors & Primitive Streams – Interview Guide

---

# 1️⃣ Parallel Stream

## What is Parallel Stream?

Parallel stream allows processing data **using multiple CPU cores** to improve performance.

It splits the stream into multiple parts and processes them **concurrently**.

---

## How to Create

```java
List<Integer> list = List.of(1,2,3,4,5);

list.parallelStream()
    .forEach(System.out::println);
```

Or:

```java
Stream<Integer> stream =
        list.stream().parallel();
```

---

## When to Use

✔ Large datasets
✔ CPU-intensive operations
✔ Independent tasks

Avoid when:

❌ Small data
❌ Shared mutable state
❌ I/O operations

---

## Important Interview Points ⭐

* Uses **ForkJoinPool.commonPool()**
* Order not guaranteed with `forEach()`
* Use `forEachOrdered()` to maintain order

Example:

```java
list.parallelStream()
    .forEachOrdered(System.out::println);
```

---

## Parallel vs Sequential

| Feature     | Sequential | Parallel            |
| ----------- | ---------- | ------------------- |
| Threads     | Single     | Multiple            |
| Performance | Normal     | Faster (large data) |
| Order       | Maintained | Not guaranteed      |

---

# 2️⃣ Collectors (Very Important ⭐)

Collectors are used with:

```java
collect()
```

to convert stream into collections or results.

Package:

```java
java.util.stream.Collectors
```

---

## Common Collectors

### toList()

```java
List<Integer> result =
    list.stream()
        .collect(Collectors.toList());
```

---

### toSet()

```java
Set<Integer> set =
    list.stream()
        .collect(Collectors.toSet());
```

---

### joining()

```java
String result =
    list.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(","));
```

---

### counting()

```java
long count =
    list.stream()
        .collect(Collectors.counting());
```

---

### groupingBy() ⭐ Most Important

```java
Map<Integer, List<String>> map =
    names.stream()
         .collect(Collectors.groupingBy(
             String::length
         ));
```

Groups elements by key.

---

### partitioningBy()

```java
Map<Boolean, List<Integer>> map =
    list.stream()
        .collect(Collectors.partitioningBy(
            x -> x % 2 == 0
        ));
```

Splits into true/false groups.

---

### mapping()

```java
Map<Integer, List<Integer>> map =
    list.stream()
        .collect(Collectors.groupingBy(
            x -> x % 2,
            Collectors.mapping(
                x -> x * 2,
                Collectors.toList()
            )
        ));
```

---

## Interview Tip ⭐

> groupingBy is one of the most frequently asked collectors.

---

# 3️⃣ Primitive Streams ⭐

Primitive streams are specialized streams for primitives to avoid **boxing/unboxing overhead**.

Types:

```
IntStream
LongStream
DoubleStream
```

Package:

```java
java.util.stream
```

---

## Why Primitive Streams?

Normal stream:

```
Stream<Integer> → boxing cost
```

Primitive stream:

```
IntStream → faster
```

---

## Creating Primitive Streams

### IntStream

```java
IntStream range =
        IntStream.range(1, 5);
```

---

### From Array

```java
int[] arr = {1,2,3};

IntStream stream =
        Arrays.stream(arr);
```

---

### Generate

```java
IntStream stream =
        IntStream.iterate(0, n -> n + 1)
                 .limit(5);
```

---

## Important Methods ⭐

### sum()

```java
int sum =
    IntStream.of(1,2,3).sum();
```

---

### average()

```java
OptionalDouble avg =
    IntStream.of(1,2,3).average();
```

---

### max()

```java
OptionalInt max =
    IntStream.of(1,2,3).max();
```

---

### boxed() (Convert to Object Stream)

```java
IntStream.range(1,5)
         .boxed()
         .collect(Collectors.toList());
```

---

# 4️⃣ Map to Primitive Streams ⭐

```java
list.stream()
    .mapToInt(x -> x)
    .sum();
```

Methods:

```
mapToInt()
mapToLong()
mapToDouble()
```

---

# 5️⃣ Interview Questions ⭐

Q: Difference between stream() and parallelStream()?

Sequential vs multi-threaded processing.

---

Q: Why primitive streams faster?

Because they avoid boxing/unboxing overhead.

---

Q: Difference between groupingBy and partitioningBy?

groupingBy → multiple keys
partitioningBy → boolean (2 groups)

---

Q: What thread pool used in parallel stream?

ForkJoinPool.commonPool()

---

# 6️⃣ Interview Summary ⭐

Parallel streams enable concurrent data processing using multiple CPU cores. Collectors provide powerful ways to transform streams into collections or grouped results. Primitive streams like IntStream improve performance by eliminating boxing overhead.

---

