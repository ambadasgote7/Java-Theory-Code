# Java Iterable, Lambda & Functional Interfaces – Interview Guide

---

# 1️⃣ Iterable Interface

## What is Iterable?

Iterable is the **root interface** for all collection classes that allows objects to be used in **for-each loop**.

Package:

```java
java.lang
```

It provides iterator functionality.

---

## Key Method

```java
Iterator<T> iterator();
```

---

## Example

```java
List<Integer> list = List.of(1, 2, 3);

for (Integer i : list) {
    System.out.println(i);
}
```

---

## Interview Point ⭐

> Iterable enables enhanced for-loop by providing iterator() method.

---

# 2️⃣ Lambda Expression

## What is Lambda?

Lambda is a **short way to implement functional interfaces** (interfaces with one abstract method).

Syntax:

```java
(parameters) -> expression
```

---

## Example

```java
Runnable r = () -> System.out.println("Hello");
```

---

## Benefits

✔ Less boilerplate
✔ Functional programming support
✔ Cleaner code

---

## Interview Point ⭐

> Lambda expressions provide implementation of functional interfaces without creating anonymous classes.

---

# 3️⃣ Predicate

## What is Predicate?

Predicate is a **functional interface** that takes input and returns **boolean**.

Package:

```java
java.util.function
```

---

## Method

```java
boolean test(T t);
```

---

## Example

```java
Predicate<Integer> isEven =
        n -> n % 2 == 0;

System.out.println(isEven.test(10));
```

---

## Use Cases

* Filtering data
* Conditions
* Validation logic

---

# 4️⃣ Function

## What is Function?

Function takes input and returns output.

```
T → R
```

---

## Method

```java
R apply(T t);
```

---

## Example

```java
Function<Integer, Integer> square =
        n -> n * n;

System.out.println(square.apply(5));
```

---

## Use Cases

* Data transformation
* Mapping operations

---

# 5️⃣ Consumer

## What is Consumer?

Consumer takes input but returns **nothing**.

```
T → void
```

---

## Method

```java
void accept(T t);
```

---

## Example

```java
Consumer<String> print =
        s -> System.out.println(s);

print.accept("Hello");
```

---

## Use Cases

* Printing
* Logging
* Side effects

---

# 6️⃣ Supplier

## What is Supplier?

Supplier provides value but takes **no input**.

```
() → T
```

---

## Method

```java
T get();
```

---

## Example

```java
Supplier<Double> random =
        () -> Math.random();

System.out.println(random.get());
```

---

## Use Cases

* Object creation
* Lazy values
* Configuration loading

---

# 7️⃣ Method Reference

## What is Method Reference?

Method reference is a **shortcut for lambda** that calls an existing method.

Syntax:

```
ClassName::methodName
```

---

## Types

1. Static method
2. Instance method
3. Constructor reference

---

## Example

```java
List<String> list = List.of("A", "B");

list.forEach(System.out::println);
```

Equivalent lambda:

```java
list.forEach(s -> System.out.println(s));
```

---

## Interview Point ⭐

> Method reference improves readability by referring to existing methods instead of writing lambda bodies.

---

# 8️⃣ Constructor Reference

## What is Constructor Reference?

Reference to a constructor using:

```
ClassName::new
```

---

## Example

```java
Supplier<ArrayList<String>> supplier =
        ArrayList::new;

ArrayList<String> list = supplier.get();
```

---

## Use Cases

* Object factories
* Stream API mapping
* Dependency injection

---

# 9️⃣ Functional Interface Summary ⭐

| Interface | Input | Output  | Method   |
| --------- | ----- | ------- | -------- |
| Predicate | T     | boolean | test()   |
| Function  | T     | R       | apply()  |
| Consumer  | T     | void    | accept() |
| Supplier  | —     | T       | get()    |

---

# 🔟 Most Important Interview Questions

Q: What is functional interface?

Answer:

> An interface with exactly one abstract method.

Example:

```
Runnable
Callable
Predicate
Function
Consumer
Supplier
```

---

Q: Difference between Function and Predicate?

Predicate → returns boolean
Function → returns any type

---

Q: Why Lambda introduced?

> To support functional programming and reduce boilerplate code.

---

# 1️⃣1️⃣ Interview Summary

Java 8 introduced lambda expressions and functional interfaces to enable functional programming. Predicate, Function, Consumer, and Supplier are core functional interfaces used extensively with Streams and collections. Method and constructor references provide cleaner alternatives to lambda expressions.

---

# Java BiPredicate, BiConsumer, BiFunction – Interview Guide

---

# 1️⃣ BiPredicate

## What is BiPredicate?

BiPredicate is a functional interface that takes **two inputs** and returns a **boolean** result.

```
(T, U) → boolean
```

Package:

```java
java.util.function
```

---

## Method

```java
boolean test(T t, U u);
```

---

## Example

```java
import java.util.function.BiPredicate;

BiPredicate<Integer, Integer> isGreater =
        (a, b) -> a > b;

System.out.println(isGreater.test(10, 5));
```

Output:

```
true
```

---

## Use Cases

✔ Comparison logic
✔ Validation with two parameters
✔ Filtering conditions

---

## Interview Point ⭐

> BiPredicate is used when condition depends on two inputs.

---

# 2️⃣ BiConsumer

## What is BiConsumer?

BiConsumer takes **two inputs** and returns **nothing**.

```
(T, U) → void
```

---

## Method

```java
void accept(T t, U u);
```

---

## Example

```java
import java.util.function.BiConsumer;

BiConsumer<String, Integer> print =
        (name, age) ->
                System.out.println(name + " " + age);

print.accept("John", 25);
```

Output:

```
John 25
```

---

## Use Cases

✔ Logging with multiple parameters
✔ Map iteration (forEach uses BiConsumer)
✔ Side effects

Example with Map:

```java
map.forEach((k, v) -> System.out.println(k + v));
```

---

## Interview Point ⭐

> Map.forEach internally uses BiConsumer.

---

# 3️⃣ BiFunction

## What is BiFunction?

BiFunction takes **two inputs** and returns a **result**.

```
(T, U) → R
```

---

## Method

```java
R apply(T t, U u);
```

---

## Example

```java
import java.util.function.BiFunction;

BiFunction<Integer, Integer, Integer> sum =
        (a, b) -> a + b;

System.out.println(sum.apply(5, 3));
```

Output:

```
8
```

---

## Use Cases

✔ Calculations
✔ Combining two values
✔ Transformations

---

# 4️⃣ Functional Interface Comparison ⭐

| Interface   | Input | Output  | Method   |
| ----------- | ----- | ------- | -------- |
| BiPredicate | T, U  | boolean | test()   |
| BiConsumer  | T, U  | void    | accept() |
| BiFunction  | T, U  | R       | apply()  |

---

# 5️⃣ Normal vs Bi Interfaces ⭐

| Normal    | Bi Version  |
| --------- | ----------- |
| Predicate | BiPredicate |
| Consumer  | BiConsumer  |
| Function  | BiFunction  |

Bi → means **two parameters**.

---

# 6️⃣ Interview Questions ⭐

Q: Difference between Function and BiFunction?

Function → one input
BiFunction → two inputs

---

Q: Where is BiConsumer used in real Java?

Answer:

```
Map.forEach()
Map.replaceAll()
```

---

Q: Can BiFunction return void?

No. Use BiConsumer for void.

---

# 7️⃣ Interview Summary

BiPredicate, BiConsumer, and BiFunction are functional interfaces that operate on two input parameters. They extend the concept of Predicate, Consumer, and Function to support operations involving two values and are widely used with Map operations and stream processing.

---

# Java UnaryOperator & BinaryOperator – Interview Guide

---

# 1️⃣ UnaryOperator

## What is UnaryOperator?

UnaryOperator is a **special type of Function** where:

```
Input and Output types are SAME
```

It extends:

```
Function<T, T>
```

Package:

```java
java.util.function
```

---

## Method

```java
T apply(T t);
```

---

## Example

```java
import java.util.function.UnaryOperator;

UnaryOperator<Integer> square =
        x -> x * x;

System.out.println(square.apply(5));
```

Output:

```
25
```

---

## Use Cases

✔ Value transformation
✔ Data modification
✔ Stream operations

Example with List:

```java
list.replaceAll(x -> x * 2);
```

---

## Interview Point ⭐

> UnaryOperator is used when input and output types are the same.

---

# 2️⃣ BinaryOperator

## What is BinaryOperator?

BinaryOperator is a **special type of BiFunction** where:

```
Both inputs and output are SAME type
```

It extends:

```
BiFunction<T, T, T>
```

---

## Method

```java
T apply(T t1, T t2);
```

---

## Example

```java
import java.util.function.BinaryOperator;

BinaryOperator<Integer> sum =
        (a, b) -> a + b;

System.out.println(sum.apply(10, 20));
```

Output:

```
30
```

---

## Use Cases

✔ Calculations
✔ Aggregation
✔ Reduction operations

Example with Streams:

```java
list.stream()
    .reduce((a, b) -> a + b);
```

---

## 3️⃣ Unary vs Binary Operator ⭐

| Feature | UnaryOperator | BinaryOperator |
| ------- | ------------- | -------------- |
| Inputs  | One           | Two            |
| Output  | Same type     | Same type      |
| Extends | Function      | BiFunction     |
| Method  | apply()       | apply()        |

---

# 4️⃣ Real Java Usage ⭐

| Method            | Interface Used |
| ----------------- | -------------- |
| List.replaceAll() | UnaryOperator  |
| Stream.reduce()   | BinaryOperator |
| Collections.max() | BinaryOperator |

---

# 5️⃣ Interview Questions ⭐

Q: Difference between Function and UnaryOperator?

Function → input and output can differ
UnaryOperator → input and output same

---

Q: Difference between BiFunction and BinaryOperator?

BiFunction → different output type allowed
BinaryOperator → same output type required

---

Q: Why BinaryOperator used in reduce()?

Because reduction combines two same-type elements into one.

---

# 6️⃣ Interview Summary

UnaryOperator and BinaryOperator are specialized functional interfaces used when input and output types are the same. UnaryOperator works on a single operand, while BinaryOperator works on two operands and is commonly used in reduction operations.

---

