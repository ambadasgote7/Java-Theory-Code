# File Handling

---

## What is File Handling?
File handling in Java is the process of:
- Creating files
- Reading data from files
- Writing data into files
- Deleting files
- Managing file properties

Java does this using two main packages:
- java.io → Traditional (older, stream-based)
- java.nio.file → Modern (better, faster, more flexible)

---

# Java File Handling – Point 1

# 1️⃣ File vs Directory

## What is a File?

A file is a container that stores data.

Examples:
- data.txt
- image.png
- student.json
- notes.pdf

A file contains actual content (text, images, data, etc.).

---

## What is a Directory?

A directory (folder) is a container used to organize files.

A directory can contain:
- Files
- Other directories (subfolders)

Example Structure:

Project/
│── data.txt
│── image.png
└── docs/
    └── notes.txt

Project → Directory  
docs → Directory  
data.txt → File  

---

## Important Interview Point

In Java, both files and directories are handled using the same class:

```java
java.io.File
```

Even a directory is treated as a file object internally.

---

## Key Differences

| Feature       | File              | Directory            |
|--------------|------------------|----------------------|
| Stores data  | Yes              | No (stores files)    |
| Contains files | No              | Yes                  |
| Can contain subfolders | No     | Yes                  |

---

## Basic Java Example

```java
import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File("data.txt");
        File folder = new File("myFolder");

        System.out.println(file.isFile());
        System.out.println(folder.isDirectory());
    }
}
```

Note:
Creating a File object does NOT create a physical file on disk.

--- 

# Java File Handling – Point 2

# 2️⃣ File Class (java.io.File)

## What is File Class?

The `File` class is used to represent files and directories in Java.

Package:
```java
import java.io.File;
```

It allows you to:
- Check if a file exists
- Get file information
- Create files
- Delete files
- Create directories

---

## Important Concept

```java
File f = new File("data.txt");
```

This does NOT create a file physically.

It only creates a File object in memory that represents the path.

To create the file physically, use:

```java
createNewFile()
```

---

## Important Methods (Interview Focus)

| Method | Description |
|--------|-------------|
| exists() | Checks if file or folder exists |
| isFile() | Returns true if it is a file |
| isDirectory() | Returns true if it is a folder |
| getName() | Returns file name |
| getAbsolutePath() | Returns full path |
| length() | Returns file size in bytes |
| delete() | Deletes the file |
| createNewFile() | Creates file physically |
| mkdir() | Creates single directory |
| mkdirs() | Creates nested directories |

---

## Example Code

```java
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("data.txt");

        System.out.println("Exists: " + file.exists());
        System.out.println("Is File: " + file.isFile());
        System.out.println("Absolute Path: " + file.getAbsolutePath());

        // Create file physically
        file.createNewFile();
    }
}
```

---

## Common Mistakes

- Thinking `new File()` creates the file.
- Forgetting that `createNewFile()` throws IOException.
- Trying to delete a non-empty directory.

---

# Java File Handling – Point 4

# 4️⃣ Reading Data from Files

Java provides multiple ways to read data from files.
Choosing the correct one is important in interviews.

---

# 1️⃣ FileReader (Character Stream – Basic Method)

Used for reading text files character by character.

Example:

```java
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("data.txt");
            int ch;

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Important Points:
- `read()` reads one character at a time.
- Returns `-1` when end of file is reached.
- Slow for large files.

---

# 2️⃣ BufferedReader (Efficient Method – Interview Favorite)

Used for reading text files efficiently.

Example:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Why better?
- Reads line by line.
- Uses internal buffering.
- Faster than FileReader for large files.

---

# 3️⃣ Scanner (Simple but Not Fastest)

Used for simple file reading.

Example:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("data.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}
```

Use Case:
- Small programs
- Simple input parsing
- Not ideal for very large files

---

# Interview Comparison

| Method | Speed | Best For |
|--------|-------|----------|
| FileReader | Slow | Small text files |
| BufferedReader | Fast | Large text files |
| Scanner | Moderate | Simple parsing |

---

# Important Concept

FileReader and BufferedReader are Character Streams.

They are used for:
- Text files
- Human-readable data

They should NOT be used for:
- Images
- Audio files
- PDFs

For those, use Byte Streams (FileInputStream).

---

# Java File Handling – Point 6 & 7

# 6️⃣ Byte Streams (FileInputStream & FileOutputStream)

Byte Streams are used to read and write raw binary data.

Used for:
- Images (.png, .jpg)
- PDFs
- Audio files
- Video files
- ZIP files
- Any binary data

Do NOT use Character Streams for binary files.

---

## FileInputStream (Reading Bytes)

Reads one byte at a time.

Example:

```java
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("image.png");
            int data;

            while ((data = fis.read()) != -1) {
                System.out.print(data + " ");
            }

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Important:
- `read()` returns one byte.
- Returns -1 when end of file is reached.

---

## FileOutputStream (Writing Bytes)

Writes raw byte data.

Example:

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileOutputStream fos = new FileOutputStream("data.bin");
            fos.write(65);  // ASCII value of 'A'
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## Append Mode

```java
FileOutputStream fos =
    new FileOutputStream("data.bin", true);
```

Second parameter `true` enables append mode.

---

## Character vs Byte Streams

| Character Stream | Byte Stream |
|------------------|------------|
| FileReader | FileInputStream |
| FileWriter | FileOutputStream |
| Used for text | Used for binary data |
| Handles encoding | Raw bytes |

---

# 7️⃣ Buffered Byte Streams (Performance Improvement)

Buffered streams improve performance by reducing direct disk access.

Without buffering:
- Slow
- More disk IO operations

With buffering:
- Faster
- Uses memory buffer

---

## BufferedInputStream

```java
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("image.png"));

            int data;

            while ((data = bis.read()) != -1) {
                // process byte
            }

            bis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## BufferedOutputStream

```java
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream("copy.png"));

            bos.write(65);
            bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## flush() Method

```java
bos.flush();
```

Forces buffered data to be written to disk immediately.

Note:
- `close()` automatically calls `flush()`.

---

## Interview Comparison

| Without Buffer | With Buffer |
|---------------|------------|
| Slow | Fast |
| Direct disk access | Memory-assisted IO |
| One byte at a time | Chunked IO |

---

## Key Interview Concepts

✔ Byte Streams are for binary files  
✔ Character Streams are for text files  
✔ Buffering improves performance  
✔ Append mode uses second constructor parameter  
✔ flush() forces writing buffered data

---

# Java File Handling – Point 8

# 8️⃣ NIO (java.nio.file) – Modern File Handling

NIO stands for New Input Output.

It is the modern way of handling files in Java.
It is cleaner, more powerful, and more flexible than traditional IO.

Package:
```java
import java.nio.file.*;
```

---

# Core Classes

You must know these three:

1. Path
2. Paths
3. Files

---

# 1️⃣ Path

Represents a file or directory path.

Example:

```java
import java.nio.file.Path;
import java.nio.file.Paths;

Path path = Paths.get("data.txt");
```

Path replaces the older File class for path handling.

---

# 2️⃣ Files

Files is a utility class with static methods to:

- Create files
- Delete files
- Copy files
- Read files
- Write files

---

# Reading File Using NIO

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("data.txt");

        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
```

Important:
- `readAllLines()` loads the entire file into memory.
- Not recommended for very large files.

---

# Writing File Using NIO

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("data.txt");

        Files.write(path, Arrays.asList("Hello", "World"));
    }
}
```

By default:
- It overwrites the file.

---

# Append Mode in NIO

```java
import java.nio.file.StandardOpenOption;

Files.write(
    path,
    Arrays.asList("New Line"),
    StandardOpenOption.APPEND
);
```

---

# Reading Large Files Efficiently

For large files, use:

```java
Files.lines(path);
```

This reads file as a stream instead of loading entire file into memory.

---

# Copying File Using NIO

```java
Files.copy(sourcePath, destinationPath);
```

Much cleaner than manual byte stream copying.

---

# Old IO vs NIO

| Old IO | NIO |
|--------|-----|
| File | Path |
| FileReader | Files.readAllLines |
| Manual buffering | Optimized internally |
| More boilerplate code | Cleaner syntax |

---

# Key Interview Points

✔ NIO is modern file handling approach  
✔ Path replaces File  
✔ Files contains static utility methods  
✔ readAllLines() loads entire file into memory  
✔ Use Files.lines() for large files  
✔ Files.copy() simplifies file copying  
✔ APPEND mode requires StandardOpenOption.APPEND

---

# Java File Handling – Point 9

# 9️⃣ Try-With-Resources (Automatic Resource Management)

Try-with-resources was introduced in Java 7 to automatically close resources.

It helps prevent:
- Resource leaks
- File locking issues
- Memory problems

---

# Problem with Old Approach

```java
FileReader fr = new FileReader("data.txt");
fr.read();
fr.close();
```

If an exception occurs before `close()` is called,
the resource remains open.

---

# Solution: Try-With-Resources

Syntax:

```java
try (resource) {
    // code
}
```

The resource is closed automatically when the block ends.

---

# Reading File Example

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br =
                new BufferedReader(new FileReader("data.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

No need to call `close()` explicitly.

---

# Writing File Example

```java
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (FileWriter fw = new FileWriter("data.txt")) {
            fw.write("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

# Why Try-With-Resources Works

The resource class must implement:

```
AutoCloseable
```

Java automatically calls `close()` at the end of the block.

---

# Multiple Resources Example

```java
try (
    FileInputStream fis = new FileInputStream("a.txt");
    FileOutputStream fos = new FileOutputStream("b.txt")
) {
    // code
}
```

All resources are closed automatically in reverse order.

---

# Interview Key Points

✔ Introduced in Java 7  
✔ Automatically closes resources  
✔ Prevents resource leaks  
✔ Cleaner than finally block  
✔ Requires AutoCloseable interface  
✔ Supports multiple resources  

---

# Java File Handling – Point 10

# 🔟 Serialization (Object ↔ File Conversion)

Serialization is the process of converting an object into a byte stream
so that it can be:

- Saved to a file
- Sent over a network
- Stored in a database
- Cached

The reverse process is called Deserialization
(Byte stream → Object).

---

# Why Serialization is Needed

Normal file writing stores:
- Text
- Numbers
- Raw bytes

But to store a complete object, we must serialize it.

Example object:

```java
Student s = new Student("Ram", 25);
```

This object cannot be written directly using FileWriter.
It must be serialized.

---

# Step 1️⃣: Make Class Serializable

```java
import java.io.Serializable;

class Student implements Serializable {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Important:
- The class must implement `Serializable`.
- `Serializable` is a marker interface (no methods).

---

# Step 2️⃣: Writing Object to File (Serialization)

Use `ObjectOutputStream`.

```java
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (
            FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {

            Student s = new Student("Ram", 25);
            oos.writeObject(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

The object is now stored as bytes in the file.

---

# Step 3️⃣: Reading Object from File (Deserialization)

Use `ObjectInputStream`.

```java
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (
            FileInputStream fis = new FileInputStream("student.ser");
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {

            Student s = (Student) ois.readObject();
            System.out.println(s.name + " " + s.age);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

Important:
- `readObject()` returns Object.
- Type casting is required.
- May throw ClassNotFoundException.

---

# Important Interview Concepts

## 1️⃣ Serializable is a Marker Interface
It contains no methods.
It simply marks the class as serializable.

---

## 2️⃣ serialVersionUID

```java
private static final long serialVersionUID = 1L;
```

- Used for version control.
- Prevents InvalidClassException.
- Should be explicitly declared.

---

## 3️⃣ transient Keyword

If a field should NOT be serialized:

```java
transient String password;
```

That field will not be saved.

---

# Common Exceptions

- NotSerializableException
- InvalidClassException
- ClassNotFoundException

---

# Key Interview Points

✔ Serialization converts object → byte stream  
✔ Deserialization converts byte stream → object  
✔ Class must implement Serializable  
✔ Serializable is a marker interface  
✔ serialVersionUID prevents version mismatch errors  
✔ transient prevents field serialization  
✔ ObjectOutputStream and ObjectInputStream are used  

--- 

# Java File Handling – Point 11

# 1️⃣1️⃣ Checked Exceptions in File Handling

Checked exceptions are exceptions that the compiler forces you to handle.

If you do not handle them, the program will not compile.

---

# Why File Handling Uses Checked Exceptions

File operations are risky because:

- File may not exist
- File may be locked
- Permission may be denied
- Disk errors may occur
- Network drives may fail

Java forces developers to handle these situations.

---

# Common Checked Exceptions in File Handling

## 1️⃣ IOException

Base class for file-related exceptions.

Example:

```java
FileWriter fw = new FileWriter("data.txt");
```

This throws `IOException`.

---

## 2️⃣ FileNotFoundException

Occurs when:
- File does not exist during reading
- No permission to access file

Example:

```java
FileReader fr = new FileReader("abc.txt");
```

If the file does not exist → `FileNotFoundException`

---

# How to Handle Checked Exceptions

## 1️⃣ Using Try-Catch

```java
try {
    FileReader fr = new FileReader("data.txt");
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## 2️⃣ Using throws Keyword

```java
public static void main(String[] args) throws IOException {
    FileReader fr = new FileReader("data.txt");
}
```

This passes exception handling responsibility to the caller.

---

# Exception Hierarchy (Simplified)

```
Exception
   └── IOException
         ├── FileNotFoundException
         ├── EOFException
         └── ...
```

---

# Checked vs Unchecked Exceptions

| Checked Exception | Unchecked Exception |
|------------------|--------------------|
| Must be handled | Optional to handle |
| Compile-time checking | Runtime checking |
| Example: IOException | Example: NullPointerException |

---

# Important Interview Points

✔ Checked exceptions must be handled  
✔ File operations commonly throw IOException  
✔ FileNotFoundException is a subclass of IOException  
✔ You must use try-catch or throws  
✔ Ignoring checked exceptions causes compilation error  
✔ Try-with-resources is recommended for file handling  

---
# Java File Handling – Important Theory Concepts

# 1️⃣ Absolute Path vs Relative Path

## Absolute Path
Full path from root directory.

Example (Windows):
```
C:\Users\Username\Desktop\data.txt
```

Example (Linux/Mac):
```
/home/user/data.txt
```

- Always points to exact location.
- Not portable across systems.

---

## Relative Path
Path relative to current project directory.

Example:
```
data.txt
```

- More portable.
- Commonly used in real projects.

---

# 2️⃣ Reading Large Files Efficiently

Avoid:

```java
Files.readAllLines(path);
```

Reason:
- Loads entire file into memory.
- Can cause OutOfMemoryError for large files.

Use:

```java
Files.lines(path);
```

or

```java
BufferedReader
```

Reason:
- Reads file line by line.
- More memory efficient.

---

# 3️⃣ File Permissions (Basic Understanding)

Files may fail to open because of:

- No read permission
- No write permission
- File locked by another process

Common methods:

```java
file.canRead();
file.canWrite();
file.canExecute();
```

Important:
Permission issues can cause IOException or FileNotFoundException.

---

# 4️⃣ IO vs NIO Difference

| IO | NIO |
|----|-----|
| Stream-based | Buffer-based |
| Blocking | Can be non-blocking |
| Older API | Modern API |
| Uses File class | Uses Path class |
| More boilerplate code | Cleaner code |

NIO is preferred in modern applications.

---

# 5️⃣ Best Practices in File Handling

✔ Use try-with-resources  
✔ Prefer Buffered streams for performance  
✔ Use NIO when possible  
✔ Handle specific exceptions instead of generic Exception  
✔ Avoid loading very large files fully into memory  
✔ Always close resources  
✔ Use append mode carefully  

---

# Final Interview Reminders

✔ Character Streams → Text files  
✔ Byte Streams → Binary files  
✔ Serialization → Object to byte stream  
✔ Checked exceptions must be handled  
✔ NIO is modern approach  
✔ Buffering improves performance  
