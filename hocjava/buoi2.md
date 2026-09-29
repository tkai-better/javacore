**BUỔI 2 - TÌM HIỂU SÂU VỀ OBJECT**
---
# **I. OBJECT**
## **1. Object là gì?**

- Trong lập trình hướng đối tượng (OOP), **Object** (Đối tượng) là một thực thể (instance) cụ thể của một *Class*. 
- Nó bao gồm hai thành phần: 
    - **Trạng thái**: thuộc tính
    - **Hành vi**: phương thức
---
## **2. Cơ chế lưu trữ trong Java**

- **Stack Memory**: 
    - Trong Java, **Thread** (luồng) là đơn vị nhỏ nhất của tiến trình (process) mà hệ điều hành có thể thực thi.
    - Bộ nhớ stack được sử dụng cho việc thực thi của một *thread*. *Stack* chứa các giá trị của các method (vốn có thời gian tồn tại ngắn) và các tham chiếu đến những *object* khác trong *heap* mà method đó đang tham chiếu tới.

    - Bộ nhớ stack luôn được tham chiếu theo thứ tự *LIFO (Last-In-First-Out)*. Mỗi khi một method được gọi, một block bộ nhớ mới được tạo trong *stack* dành cho method đó để giữ các giá trị *primitive* (nguyên thủy) cục bộ và tham chiếu đến các *object* khác trong method.

    - Ngay khi method dừng, block đó đực giải phóng và có thể được dùng cho method mới. Kích thước *stack* nhỏ hơn nhiều so với bộ nhớ *heap*.
<br></br>

- **Heap Memory**: 
    - *Heap* được *Java runtime* sử dụng để cấp phát bộ nhớ cho các đối tượng và các *class* của JRE. Bất cứ khi nào chúng ta tạo một *object*, nó luôn được tạo trong bộ nhớ *heap*. *Heap* là nơi chứa toàn bộ các thực thể *object* thực tế và các biến *instance*.

    - *Garbage collection* (GC) chạy trên vùng này để giải phóng bộ nhớ được sử dụng bởi các object không còn tham chiếu nào. Mọi object được tạo trong heap đều có quyền truy cập *global* và có thể được tham chiếu từ bất kỳ đâu trong ứng dụng.
    

```java
package com.journaldev.test;

public class Memory {
    public static void main(String[] args) { // Line 1
	int i=1; // Line 2
	Object obj = new Object(); // Line 3
	Memory mem = new Memory(); // Line 4
	mem.foo(obj); // Line 5
    } // Line 9

    private void foo(Object param) { // Line 6
	    String str = param.toString(); //// Line 7
	    System.out.println(str);
    } // Line 8
}
```

![alt text](https://lh3.googleusercontent.com/d/1Z1U0nbt7js6e8-bH_AD4jheNDj7Ukuho)

---

# **II. WRAPPER CLASS & AUTO BOXING / AUTO UNBOXING**

## **1. WRAPPER là gì?**
- Lớp *Wrapper* trong java sử dụng để chuyển đổi kiểu dữ liệu nguyên thủy thành kiểu đối tượng và ngược lại từ đối tượng thành kiểu dữ liệu nguyên thủy.

## **2. Đặc điểm của lớp Wrapper trong Java**

- Đóng gói dữ liệu nguyên thủy thành các đối tượng, cung cấp tính linh hoạt trong việc xử lý dữ liệu

- Các đối tượng của lớp wrapper là không thay đổi, đảm bảo tính an toàn khi sử dụng trong môi trường đa luồng.

- Cung cấp các phương thức tiện ích để phục vụ các hoạt động chuyển đổi kiểu dữ liệu, so sánh giá trị, thực hiện các phép toán số học.

- Các lớp *wrapper* còn có thể sử dụng để biểu diễn giá trị `null` của các kiểu dữ liệu nguyên thủy.

- Tính năng *autoboxing* và *unboxing* cho phép tự động chuyển đổi giữa các kiểu dữ liệu nguyên thủy và các đối tượng wrapper tương ứng dễ dàng và tự động.

- Sử dụng trong Collections Framework: Các cấu trúc dữ liệu như `ArrayList`, `HashMap`,`HashSet` chỉ lưu trữ được đối tượng, không thể chứa kiểu dữ liệu nguyên thủy. Ví dụ: bạn không thể khai báo `ArrayList<int>`, mà bắt buộc phải dùng `ArrayList<Integer>`.

| Kiểu nguyên thủy | Lớp WRAPPER | 
| :--- | :--- | 
| `byte` | `Byte` | 
| `short` | `Short` | 
| `int` | `Integer` | 
| `long` | `long` | 
| `float` | `Float` | 
| `double` | `Double` | 
| `char` | `Character` | 
| `boolean` | `Boolean` | 

---

## **3. AUTO BOXING & AUTO UNBOXING**

- Autoboxing: Cơ chế trình biên dịch Java tự động chuyển đổi từ kiểu nguyên thủy (primitive) sang đối tượng Wrapper tương ứng.

```java
public class Wrapper1 {
    public static void main(String[] args) {
        // Chuyển đổi int thành Integer
        int a = 20;
        
        // Cách 1: Chuyển đổi thủ công sử dụng phương thức valueOf()
        Integer i = Integer.valueOf(a); 
        
        // Cách 2: AUTOBOXING, trình biên dịch sẽ tự động hiểu là Integer.valueOf(a)
        Integer j = a; 

        // In kết quả ra màn hình 20 20 20
        System.out.println(a + " " + i + " " + j);
    }
}
```
- Unboxing: Cơ chế tự động giải nén từ đối tượng Wrapper thành kiểu dữ liệu nguyên thủy.

```java
public class Wrapper2 {
    public static void main(String[] args) {
        // Chuyển đổi Integer thành int
        Integer a = new Integer(3);
        
        // Cách 1: Chuyển đổi thủ công sử dụng phương thức intValue()
        int i = a.intValue(); 
        
        // Cách 2: AUTO UNBOXING, trình biên dịch sẽ tự động viết thành a.intValue()
        int j = a; 

        // In kết quả ra màn hình 3 3 3
        System.out.println(a + " " + i + " " + j);
    }
}
```
---

# **III. STRING & STRINGBUILDER**
## **1. STRING**
### *1.1 STRING và tính BẤT BIẾN*

- Thông thường, `String` là một chuỗi các ký tự. Nhưng, trong Java, `String` là một đối tượng biểu diễn một nối tiếp của các ký tự. Lớp `java.lang.String` được sử dụng để tạo đối tượng `String`.

- **Đặc điểm**: Đối tượng `String` là bất biến (Immutable). Một khi một đối tượng `String` đã được tạo ra (trên *Heap*), giá trị của nó không thể thay đổi trong suốt vòng đời của nó.

    - Lớp String được khai báo là `public final class String`: Không *class* nào có thể kế thừa và ghi đè (override) hành vi của nó.

```java
String str = "Hello";
str = str + " World"; 
```

- Cụ thể quá trình diễn ra như sau:

    - Ban đầu, biến str trỏ đến ô nhớ chứa đối tượng String có giá trị "Hello".

    - Khi bạn thực hiện phép cộng chuỗi `str = str + " World";`, Java tạo ra một đối tượng String mới hoàn toàn chứa giá trị "Hello World" ở một vùng nhớ khác.

    - Biến str lúc này được gán lại và chuyển sang trỏ vào đối tượng mới ("Hello World").

    - Đối tượng cũ ("Hello") lúc này không còn biến nào trỏ đến nữa và trở thành rác (garbage) trong bộ nhớ *Heap*.
---
### *1.2 Các cách khởi tạo đối tượng String*

- Sử dụng **String Literal**:
  - `String s = "welcome";`
  - Mỗi khi bạo tạo một biến *string literal*, đầu tiên JVM sẽ kiểm tra xem giá trị đó đã tồn tại trong Pool chưa. Nếu chuỗi này đã tồn tại trong Pool, thì giá trị của biến sẽ được tham chiếu đến instance đã được tạo ra trong Pool. Nếu chuỗi này không tồn tại trong Pool, một instance mới được tạo ra và đặt vào trong Pool. Ví dụ: 

```java
String s1 = "welcome";  
String s2 = "welcome"; // se khong tao instance moi
```

![alt text](https://viettuts.vn/images/java/java-string/string-pool.jpg)

---

- Sử dụng từ khóa `new`:
    - `String s = new String("Welcome");`(Tạo 2 đối tượng và 1 biến tham chiếu)
    - Trong trường hợp này, JVM sẽ tạo ra một đối tượng *string* mới như một đối tượng trong bộ nhớ *HEAP* và chữ "Welcome" sẽ được đặt trong Pool. Biến s sẽ tham chiếu tới đối tượng được tạo ra trong HEAP (ngoài SCP).
```java
String s1 = "abc";
String s3 = new String("abc");
```

> Lưu ý rằng s1 và s3 sẽ trỏ đến 2 ô nhớ khác nhau trên Heap
---
### *1.3 Một số phương thức của lớp String*

| Method | Nội dung | Kiểu trả về |
| :--- | :--- | :--- |
| `s.length()` | Trả về độ dài (số lượng kí tự) của chuỗi s | `int` |
| `s.charAt(i)` | Trả về kí tự `char` tại vị trí i | `char` |
| `s.equals(String ...)` | So sánh nội dung, có phân biệt hoa/thường | `boolean` (True nếu = nhau, False nếu khác nhau) |
| `s.equalsIgnoreCase(String ...)` | So sánh không phân biệt hoa/thường | `boolean` |
|`s.compareTo(String k)`|So sánh theo từ điển |`int` (0 nếu = nhau, > 0 nếu s đứng sau k, < 0 nếu s đứng trước k)|
| `s.contains(CharSequence t)`|Kiểm tra xem chuỗi t có phải là chuỗi con của s không|`boolean` (true nếu là chuỗi con, false nếu ko)|
|`s.indexOf(String k)`|Tìm vị trí xuất hiện đầu tiên của chuỗi k trong s|`int` (nếu ko tìm thấy thì trả về -1)|
|`s.toLowerCase()`|Đổi sang chữ thường|`String`|
|`s.toUpperCase()`|Đổi sang chữ hoa|`String`|
|`s.trim()`|Xóa khoảng trắng thừa ở 2 đầu|`String`|
|`s.split(String regex)`|Tách chuỗi gốc thành một mảng các chuỗi con dựa vào *regex* truyền vào.|`String[]`|


### *1.4 STRINGBUILDER*

- Đặc điểm: Đối tượng **StringBuilder** là có thể thay đổi (Mutable). Khi bạn thực hiện các thao tác như nối, chèn, hoặc xóa ký tự, nó thực hiện trực tiếp trên cùng một vùng nhớ mà không tạo ra đối tượng mới.

- Ưu điểm: Hiệu năng rất cao và tiết kiệm bộ nhớ khi phải thực hiện nhiều phép biến đổi chuỗi (trong vòng lặp, xử lý văn bản lớn).

- Nhược điểm: Không an toàn trong môi trường đa luồng vì các phương thức không được đồng bộ hóa (nếu cần đa luồng an toàn, có thể dùng *StringBuffer* thay thế).

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Thêm trực tiếp vào đối tượng hiện tại, không tạo đối tượng mới
System.out.println(sb.toString()); // Kết quả: Hello World

// String s = sb; // Lỗi biên dịch
String s = sb.toString(); // Đúng: Phải dùng .toString()
```
--- 
### *1.5 Một số phương thức của lớp StringBuilder*

- `sb.append(val)`: Nối thêm dữ liệu (chuỗi, số, boolean,...) vào cuối chuỗi hiện tại.

- `insert(int offset, val)`: Chèn dữ liệu vào vị trí (offset) chỉ định.

...................................
---

# **IV. TOÁN TỬ `==`, EQUALS() VÀ HASHCODE()**

## **1. TOÁN TỬ `==`** (So sánh tham chiếu)

- Toán tử `==` kiểm tra xem hai biến có đang trỏ đến cùng một ô nhớ trong *Heap* hay không.

- Với kiểu **nguyên thủy** (`int`, `char`, `boolean`,...): So sánh giá 
trị thực tế của chúng.

```java
   int a = 1;
   int b = 1;
   System.out.println(a == b); // true
```

- Với kiểu **đối tượng** (String, Integer, các class tự định nghĩa,...): So sánh địa chỉ ô nhớ (xem hai biến có phải là cùng một đối tượng hay không).

```java
String s1 = new String("hello");
String s2 = new String("hello");

System.out.println(s1 == s2); // false (vì nằm ở 2 ô nhớ khác nhau trong heap) 
```
---

## **2. Phương thức `equals()`** (So sánh nội dung)
- Phương thức `equals()` được dùng để so sánh nội dung của hai đối tượng.

- Mặc định (khi chưa ghi đè), phương thức `equals()` trong lớp gốc *Object* hoạt động y hệt như toán tử `==` (tức là so sánh địa chỉ ô nhớ).

- Tuy nhiên, các lớp có sẵn trong Java như `String`, `Integer`, `Double`, ... đã ghi đè lại `equals()` để so sánh giá trị bên trong.

```java
String s1 = new String("hello");
String s2 = new String("hello");

System.out.println(s1.equals(s2)); // true (vì nội dung chuỗi bên trong giống nhau)
```
---
## **3. Phương thức `hashCode()`** 
- Phương thức `hashCode()` trả về một số nguyên (`int`) đại diện cho **mã băm** của đối tượng. Mã băm này thường được dùng bởi các cấu trúc dữ liệu dạng băm như `HashMap`, `HashSet`, `HashTable` để tìm kiếm nhanh đối tượng.

- **Quy tắc bắt buộc** giữa `equals()` và `hashCode()`:
    - Nếu bạn tự tạo một class và quyết định ghi đè phương thức `equals()`, bạn bắt buộc phải ghi đè luôn `hashCode()`.

    - Nếu hai đối tượng bằng nhau theo `equals()` (tức `a.equals(b)` là *true*), thì bắt buộc `a.hashCode() == b.hashCode()` phải là *true*.

    - Nếu hai đối tượng có `hashCode()` khác nhau, chắc chắn chúng không bằng nhau (`equals()` trả về *false*).

    - Lưu ý ngược lại: Hai đối tượng có `hashCode()` giống nhau chưa chắc đã bằng nhau (hiện tượng trùng mã băm).

```java
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals dựa trên id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    // QUÊN KHÔNG OVERRIDE HASHCODE()!
}

public class HashDemo {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Student s1 = new Student("SV01", "An");
        Student s2 = new Student("SV01", "An");

        set.add(s1);
        
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // In ra: true (Đúng logic)
        System.out.println("set.contains(s2): " + set.contains(s2)); // IN RA: FALSE ??? TẠI SAO?
        System.out.println("Kích thước Set: " + set.size());        // IN RA: 1 (nhưng không tìm thấy s2!)
    }
}
```
- Khi gọi `set.contains(s2)`:
    - HashSet sẽ lấy `s2.hashCode()` để tính ra vị trí thùng chứa (Bucket Index).
    - Vì *Student* không *override* `hashCode()`, nó thừa hưởng hàm `hashCode()` từ *Object* (vốn sinh mã băm dựa trên địa chỉ bộ nhớ vật lý).
    - s1 và s2 là hai đối tượng nằm ở hai địa chỉ RAM khác nhau ⟹ Chúng sinh ra 2 mã `hashCode()` hoàn toàn khác nhau ⟹ Trỏ tới 2 Bucket khác nhau trong bảng băm!
    - `HashSet` nhảy thẳng vào Bucket tính từ s2, thấy bucket đó rỗng ⟹ Kết luận ngay lập tức là contains == false mà chưa thèm gọi đến hàm `equals()`!

- Khắc phục:
```java
...
@Override
public int hashCode() {
    return Objects.hash(id); 
}
...
```
---

# **V. CƠ CHẾ TRUYỀN THAM SỐ TRONG JAVA**

## **1. PASS-BY-VALUE"** (Truyền tham trị)

- JAVA hoàn toán lá **PASS-BY-VALUE** trong mọi trường hợp. 
- Java KHÔNG CÓ cơ chế **Pass-by-reference** như con trỏ/tham chiếu trong C++
- Khi bạn truyền bất kỳ một đối số nào vào một hàm:
    - Java sẽ tạo ra một bản sao giá trị (copy of the value) của biến đó và đặt vào Stack Frame của hàm được gọi.
    - Hàm nhận bản sao và thao tác trên bản sao đó, hoàn toàn không làm thay đổi bản gốc bên ngoài.
---
## **2. Phân biệt cách hoạt động với 2 loại kiểu dữ liệu**

### *A. Kiểu dữ liệu nguyên thủy*

- int, double, char, boolean, v.v.
- Giá trị được truyền vào phương thức chính là giá trị thực tế của biến (ví dụ: 5, true).

- Kết quả: Thay đổi giá trị bên trong phương thức không ảnh hưởng đến biến gốc bên ngoài.

```java
public static void changeNumber(int x) {
    x = 99; // Chỉ làm thay đổi biến x cục bộ trong Stack Frame của hàm changeNumber
}

public static void main(String[] args) {
    int a = 10;
    changeNumber(a);
    System.out.println(a); // VẪN LÀ 10
}
```

### *B. Kiểu đối tượng*

- Object, Array, Integer, String, v.v.

- Giá trị được truyền vào phương thức là giá trị của tham chiếu (reference value) — hiểu đơn giản là địa chỉ ô nhớ của đối tượng đó.

- Kết quả: Cả biến gốc và tham số trong phương thức đều cùng trỏ đến một đối tượng trên vùng nhớ Heap.

- Nếu bạn gọi phương thức làm thay đổi trạng thái bên trong đối tượng (ví dụ: thay đổi phần tử của mảng, dùng setter của object), bạn sẽ thấy sự thay đổi ở bên ngoài.

- Nhưng nếu bạn gán tham số đó trỏ sang một đối tượng hoàn toàn mới ( `= new Object()`), biến gốc bên ngoài không hề bị thay đổi.

## **3. Giải mã nghịch lý: Tại sao Object thay đổi trạng thái được, còn String thì không?**

- ****Tình huống 1**: Thay đổi thuộc tính Object ⟹ **ĐỔI BÊN NGOÀI****

```java
public static void changeName(Student stu) {
    stu.setName("Hoàng"); // Truy xuất qua địa chỉ và đổi trường bên trong Heap
}
public static void main(String[] args) {
    Student s = new Student("Nam");
    changeName(s);
    System.out.println(s.getName()); // KẾT QUẢ: "Hoàng"
}
```
>Giải thích: Vì `stu` nắm giữ địa chỉ ô nhớ thật của đối tượng trên *Heap*, nên thao tác `stu.setName()` đã trực tiếp sửa đổi vùng nhớ dùng chung đó.

<br></br>

- ****Tình huống 2**: Gán lại Object bằng `new` ⟹ **KHÔNG ĐỔI BÊN NGOÀI****

```java
public static void reassignStudent(Student stu) {
    stu = new Student("Khánh"); // Gán stu trỏ sang 1 đối tượng hoàn toàn mới
}
public static void main(String[] args) {
    Student s = new Student("Nam");
    reassignStudent(s);
    System.out.println(s.getName()); // KẾT QUẢ: VẪN LÀ "Nam"!
}
```
>Giải thích: Phép gán stu = new Student(...) chỉ làm cho biến bản sao stu trong hàm con trỏ sang một ô nhớ mới trên Heap. Biến s ban đầu ở hàm main vẫn giữ nguyên địa chỉ ô nhớ cũ trỏ về "Nam".

<br></br>

- **Tình huống 3: Tại sao truyền String vào hàm, sửa đổi lại KHÔNG BAO GIỜ bị đổi bên ngoài?**

```java
public static void modifyString(String str) {
    str = str + " World"; // Hoặc str.concat(" World")
}
public static void main(String[] args) {
    String text = "Hello";
    modifyString(text);
    System.out.println(text); // KẾT QUẢ: VẪN LÀ "Hello"!
}
```
- Bản chất nguyên nhân cốt lõi:

    1. Java truyền bản sao địa chỉ của chuỗi "Hello" cho biến str trong hàm modifyString.
    2. Nhưng như đã học ở Phần III: `String` là **BẤT BIẾN**! Không có bất kỳ phương thức nào cho phép sửa đổi nội dung của một `String` đã tồn tại.
    3. Khi bạn viết `str = str + " World"`, Java bắt buộc phải tạo ra một đối tượng `String` **HOÀN TOÀN MỚI** mang giá trị `"Hello World"` trên *Heap*, rồi gán địa chỉ của đối tượng mới này cho biến `str`.
    4. Điều này đồng nghĩa hàm `modifyString` vừa thực hiện hành vi Gán lại tham chiếu. Biến `str` giờ trỏ sang chuỗi mới, trong khi biến `text` ở hàm main vẫn kiên định trỏ vào chuỗi `"Hello"` ban đầu.
---

# **VI. CƠ CHẾ THU GOM RÁC (GARBAGE COLLECTOR - GC)**

## **1. Khái niệm về Garbage Collector**

- Trong **C/C++**, lập trình viên phải tự quản lý bộ nhớ: xin cấp phát bằng `malloc()` / `new` và tự giải phóng bằng `free()` / `delete`. Nếu quên giải phóng sẽ gây rò rỉ bộ nhớ (Memory Leak).

- **Garbage Collector** là cơ chế tự động quản lý bộ nhớ của Java Virtual Machine (JVM).

- Nhiệm vụ chính là **tìm kiếm** và **giải phóng bộ nhớ** trên *Heap* của những đối tượng không còn được sử dụng (không còn tham chiếu từ chương trình) nhằm ngăn chặn tình trạng tràn bộ nhớ (OutOfMemoryError) và rò rỉ bộ nhớ (Memory Leak).

## **2. Cơ chế hoạt động**

- GC hoạt động theo các bước chính sau:
    - **Đánh dấu** (Marking): GC quét qua bộ nhớ heap để xác định các đối tượng đang được tham chiếu và đánh dấu chúng. Các đối tượng không được đánh dấu sẽ được coi là không còn sử dụng.
    - **Xóa bỏ** (Sweeping): Sau khi đánh dấu, GC giải phóng bộ nhớ của các đối tượng không được đánh dấu, tức là các đối tượng không còn tham chiếu.
    - **Gom bộ nhớ** (Compacting): GC sắp xếp lại các đối tượng còn sống trong bộ nhớ heap để loại bỏ các khoảng trống, giúp tối ưu hóa việc cấp phát bộ nhớ cho các đối tượng mới.

- Để quản lý hiệu quả, bộ nhớ heap trong JVM được chia thành các vùng:

    - **Young Generation**: Chứa các đối tượng mới được tạo. Vùng này được chia thành ba phần: Eden Space, Survivor Space 1 và Survivor Space 2. GC thường xuyên quét vùng này để giải phóng bộ nhớ của các đối tượng có tuổi thọ ngắn.
    - **Old Generation**: Chứa các đối tượng đã tồn tại lâu và sống sót qua nhiều lần GC ở Young Generation. GC ít quét vùng này hơn, nhưng khi thực hiện sẽ tốn nhiều thời gian hơn do kích thước lớn.
    - **Permanent Generation** (PermGen): Lưu trữ metadata của JVM như thông tin về các lớp và phương thức. Từ Java 8 trở đi, PermGen được thay thế bằng Metaspace, có khả năng mở rộng động.
