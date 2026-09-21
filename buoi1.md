# **[JAVA] - BUỔI 1: WELCOME TO JAVA**
## **I. TỔNG QUAN VỀ NGÔN NGỮ LẬP TRÌNH JAVA**

- **Định nghĩa**: Java là ngôn ngữ lập trình bậc cao, hướng đối tượng (OOP), có tính bảo mật cao và mạnh mẽ.
<br>
- **Lịch sử ra đời**: Được phát triển bởi Sun Microsystems (do James Gosling khởi xướng) vào năm 1995, sau này được Oracle mua lại.
<br>
- **Lí do ra đời**: Vào đầu những năm 1990, các ngôn ngữ phổ biến như C/C++ gặp phải hai hạn chế lớn 
   - Phụ thuộc vào phần cứng/hệ điều hành: Chương trình biên dịch trên hệ điều hành này không thể chạy trực tiếp trên hệ điều hành khác (phải biên dịch lại).


   - Quản lý bộ nhớ phức tạp: Lập trình viên C/C++ phải tự quản lý bộ nhớ (con trỏ, cấp phát/giải phóng bộ nhớ), dễ dẫn đến lỗi tràn bộ nhớ hoặc rò rỉ bộ nhớ.
<br>
- Java ra đời với mục tiêu giải quyết hai vấn đề trên:
  - Triết lý "Write Once, Run Anywhere" (WORA): Viết mã một lần, chạy ở bất kỳ đâu có môi trường Java.

  - Quản lý bộ nhớ tự động: Loại bỏ con trỏ trực tiếp và tích hợp cơ chế thu gom rác tự động (Garbage Collector).

---

## **II. JAVA HOẠT ĐỘNG NHƯ THẾ NÀO?**
Toàn bộ vòng đời của một chương trình Java có thể tóm gọn thành bốn bước, theo đúng thứ tự:

1. **Viết mã nguồn (Source Code)**: Bạn gõ những dòng code Java vào một file `.java`. File này giống như thực đơn bạn nghĩ ra cho bữa tối — chưa ăn được, nhưng là kế hoạch quan trọng nhất.
<br>
2. **Biên dịch thành Bytecode**: Trình biên dịch của Java (*javac*) biến mã nguồn thành **Bytecode**, lưu trong file `.class`. Bytecode giống như "món ăn nửa chín", không còn là code người đọc, cũng chưa phải mã máy, mà là một định dạng trung gian chuẩn hóa, sẵn sàng để JVM thực thi.
<br>
3. **Chạy trên JVM (Java Virtual Machine)**: JVM đọc Bytecode và dịch nó thành mã máy mà hệ điều hành cụ thể của bạn hiểu được. Đây là bước "dọn bàn" — và cũng chính là chìa khóa giúp cùng một file `.class` chạy được trên Windows, macOS hay Linux, miễn là nơi đó có cài JVM.  
<br>
4. **Dọn dẹp**: JVM không chỉ dịch mã, nó còn quản lý bộ nhớ, xử lý lỗi, và tự dọn dẹp những thứ không còn dùng đến (như các biến đã bị bỏ rơi).
---

Mấu chốt của tính đa nền tảng nằm ở chỗ này: trình biên dịch tạo ra một Bytecode duy nhất, độc lập với nền tảng; phần phụ thuộc vào hệ điều hành được đẩy hết xuống JVM. Mỗi hệ điều hành có một phiên bản JVM riêng, nhưng đối với code của bạn thì JVM nào cũng "nói" chung một thứ tiếng — Bytecode. Đó chính là cơ chế thật sự đứng sau "write once, run anywhere".

```
[Source Code: Main.java] 
       │ (javac - Trình biên dịch)
       ▼
[Bytecode: Main.class]
       │
       ├──► [JVM trên Windows] ──► Mã máy Windows
       ├──► [JVM trên macOS]   ──► Mã máy macOS
       └──► [JVM trên Linux]   ──► Mã máy Linux
```
<br>

- Ghi nhớ các khái niệm:

  - JDK (Java Development Kit): Bộ công cụ phát triển (bao gồm JRE + Trình biên dịch javac + Tools).

  - JRE (Java Runtime Environment): Môi trường chạy Java (bao gồm JVM + Core Libraries).

  - JVM (Java Virtual Machine): Máy ảo Java trực tiếp chạy Bytecode.
---

## **III. CẤU TRÚC CHƯƠNG TRÌNH JAVA VÀ PACKAGE**
### 1. Chương trình mẫu 
VD: Chương trình in ra `Hello World!`

```java
// 1. Khai báo Package (nếu có)
package com.example.helloworld;
// 2. Khai báo Class
public class Main {
    // 3. Hàm main - điểm bắt đầu của chương trình
    public static void main(String[] args) {
        // 4. Các câu lệnh xử lí
        System.out.println("Hello World!");
    }
}
```
  - package: Quy định thư mục chứa file.

  - public class Main: Tên class (phải trùng tên file Main.java).

  - public static void main(String[] args): Điểm bắt đầu bắt buộc khi chạy một ứng dụng Java.
---
### 2. Giải thích hàm main

- `public` (Access Modifier - Phạm vi truy cập):
  - Cho phép phương thức này có thể được truy cập và gọi từ bất kỳ đâu, kể cả bên ngoài class hay bên ngoài package.

  - JVM nằm ngoài package và class chứa hàm main của bạn. Để JVM có thể tìm thấy và kích hoạt hàm main khi khởi chạy ứng dụng, phương thức này bắt buộc phải được khai báo là public.
<br>
- `static` (Từ khóa cấp lớp):
  - Khai báo phương thức thuộc về chính Class chứ không thuộc về một Object (đối tượng) cụ thể nào được tạo ra từ class đó.
  - Nhờ có static, JVM có thể gọi trực tiếp `Main.main()` mà không cần phải khởi tạo đối tượng `new Main()` trước (tránh lãng phí bộ nhớ)          
<br>
- `void` (Kiểu trả về): Báo cho trình biên dịch biết phương thức này không trả về bất kỳ giá trị nào sau khi thực thi xong.
<br>
- `main` (Tên phương thức): Đây là tên mặc định quy ước bởi ngôn ngữ Java dành cho phương thức khởi đầu.
<br>
- `String[] args` (Tham số dòng lệnh - Command-line arguments)
  - `String[]`: Mảng chứa các chuỗi ký tự (String).
  - `args`: Tên biến đại diện cho mảng (bạn có thể đổi tên args thành tên khác như arguments hay a).

  - Tại sao cần String[] args?: Cho phép người dùng truyền các tham số đầu vào từ cửa sổ dòng lệnh (Terminal/CMD) vào chương trình ngay tại thời điểm khởi chạy.

Ví dụ: Nếu bạn chạy chương trình từ terminal với lệnh:
```
java Main Hello World 123
```
- Lúc này, mảng args sẽ nhận 3 phần tử dạng chuỗi: args[0] = "Hello", args[1] = "World", args[2] = "123".
---
### 3. **Package là gì?**
#### *3.1 Khái niệm*
- Package trong Java tương đương với một thư mục dùng để gom nhóm các lớp (class), giao diện (interface) có cùng chức năng hoặc liên quan với nhau.
<br>
#### *3.2 Tác dụng*
  - Phân loại mã nguồn giúp quản lý dự án dễ dàng.
  - Tránh xung đột tên (VD: Bạn có thể có 2 class cùng tên User nếu nằm ở 2 package khác nhau).
  - Kiểm soát quyền truy cập giữa các lớp.
<br>

#### *3.3 Cú pháp*
  - Viết bằng chữ cái in thường
  - Khai báo ở đầu file: `package com.proptit.app;`

  - Nhập (import) thư mục/class từ package khác: `import com.proptit.app.Training;`

**VD1: 2 File có CÙNG Package**
- Bạn có thể khởi tạo đối tượng hoặc gọi trực tiếp các phương thức/lớp mà không cần import.

```java
// File 1: Student.java
package com.proptit.app;

public class Student {
    public String name = "Nguyen Van A";
}
```
<br>

```java
// File 2: Main.java (Cùng package với Student)
package com.proptit.app;

public class Main {
    public static void main(String[] args) {
        Student st = new Student(); // Gọi trực tiếp không cần import
        System.out.println(st.name);
    }
}
```
<br>

**VD2: 2 File khác Package**
- Class cần dùng phải được khai báo bằng từ khóa public.

- Ở file mới, bạn phải dùng lệnh import trỏ đúng đến tên package + tên class đó.

```java
// File Main.java (Khác package)
package com.proptit.service; 

import com.proptit.app.Student; // Import class Student từ package com.mycompany.app

// import com.proptit.app.*; 
// các lớp và interface của các gói này sẽ có thể truy cập được
// tuy nhiên gói con sẽ không thể truy cập được.

public class Main {
    public static void main(String[] args) {
        Student st = new Student(); // Dùng Student từ File 1
        System.out.println(st.name);
    }
}
```
<br>

**VD3: Sử dụng tên đầy đủ**
- Khi sử dụng tên đầy đủ thì sẽ chỉ truy cập được tới lớp đã khai báo của package. Bạn  sẽ không cần phải sử dụng đến các từ khóa import. Tuy nhiên, mỗi khi truy cập vào các lớp hoặc interface thì ban cần phải sử dụng tên đầy đủ
<br>
- Khi 2 package có tên lớp giống nhau thì thường sử dụng cách này. Ví dụ: 2 package java.util và java.sql chứa lớp có tên giống nhau là lớp Date

```java
package pack; 
public class A {
    public void msg() {
    System.out.println("Hello");
    }
}
```
<br>

```java
package mypack; 
class B{ 
    public static void main(String args[]){ 
        pack.A obj = new pack.A(); // Sử dụng tên đầy đủ
        obj.msg(); // in kq: Hello
    } 
} 
```

#### *3.4 Quy trình thao tác*
- Chuẩn bị file: Tạo file Simple.java với nội dung:
```java
package mypack;

public class Simple {
    public static void main(String[] args) {
        System.out.println("Learn java package");
    }
}
```
<br>

- Biên dịch (Compile)
```Bash
javac -d . Simple.java
```
<br>

- Chạy chương trình (Run)
```Bash
java mypack.Simple
```
<br>

- Kết quả in ra màn hình;
```
Learn java package
```
---
## **IV. SYNTAX CƠ BẢN TRONG JAVA**
### **1. Khai báo biến nguyên thủy**
#### *1.1. 8 kiểu dữ liệu nguyên thủy*

| Nhóm | Kiểu dữ liệu | Kích thước | Giá trị mặc định | Khoảng giá trị / Mô tả | Ví dụ khai báo |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Số nguyên** | `byte` | 1 byte (8 bits) | `0` | -128 đến 127 | `byte b = 100;` |
| | `short` | 2 bytes (16 bits) | `0` | -32,768 đến 32,767 | `short s = 5000;` |
| | `int` | 4 bytes (32 bits) | `0` | Khoảng -2.14 tỷ đến 2.14 tỷ *(Mặc định cho số nguyên)* | `int age = 25;` |
| | `long` | 8 bytes (64 bits) | `0L` | Từ $-2^{63}$ đến $2^{63}-1$ *(Cần đuôi `L` hoặc `l`)* | `long pop = 8000000000L;` |
| **Số thực** | `float` | 4 bytes (32 bits) | `0.0f` | Chính xác ~6-7 chữ số thập phân *(Cần đuôi `F` hoặc `f`)* | `float pi = 3.14f;` |
| | `double` | 8 bytes (64 bits) | `0.0d` | Chính xác ~15 chữ số thập phân *(Mặc định cho số thực)* | `double price = 99.99;` |
| **Ký tự** | `char` | 2 bytes (16 bits) | `'\u0000'` | Ký tự Unicode đơn (đặt trong dấu nháy đơn `''`) | `char grade = 'A';` |
| **Logic** | `boolean` | 1 bit (về lý thuyết) | `false` | Chỉ nhận giá trị `true` hoặc `false` | `boolean pro = true;` |

<br>

> Một số lưu ý quan trọng:
> - Hằng số số nguyên trong Java mặc định là int. Muốn gán kiểu long bắt buộc phải có hậu tố L hoặc l.
> - Hằng số số thực mặc định là double. Muốn gán cho kiểu float, bắt buộc phải có hậu tố F hoặc f.
---

#### *1.2. Quy tắc đặt tên biến*
- Ký tự cho phép: Chỉ gồm chữ cái (a-z, A-Z), chữ số (0-9), dấu gạch dưới (_), và dấu đô la ($).

- Không bắt đầu bằng số: Tên biến không được bắt đầu bằng chữ số.

```
int 1number = 10; (Lỗi)
int number1 = 10; (Hợp lệ)
```

- Phân biệt hoa thường: age, Age, và AGE là 3 biến hoàn toàn khác nhau.

- Không trùng từ khóa (Keywords): Không đặt tên trùng với từ khóa reserved của Java như class, int, public, static, void, for, if,...

- Không chứa khoảng trắng hoặc ký tự đặc biệt khác (@, #, %, -,...).
---
### **2. Câu lệnh rẽ nhánh**

```java
int score = 85;

// if - else if - else
if (score >= 90) System.out.println("Xuất sắc");
else if (score >= 70) System.out.printl("Khá");
else System.out.println("Trung bình");

// switch - case
int day = 2;
switch (day) {
    case 1:
        System.out.println("Chủ nhật");
        break;
    case 2:
        System.out.println("Thứ hai");
        break;
    default:
        System.out.println("Ngày không hợp lệ");
}
```
---
### **3. Vòng Lặp**
```java
// 1. Vòng lặp for
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}

// 2. Vòng lặp while (kiểm tra điều kiện trước)
int count = 0;
while (count < 3) {
    System.out.println("Count: " + count);
    count++;
}

// 3. Vòng lặp do-while (chạy ít nhất 1 lần trước khi kiểm tra)
int n = 0;
do {
    System.out.println("Chạy lần đầu");
    n++;
} while (n < 0);
```
---

### **4. Mảng**
- Khai báo
```java
// Cách 1: Khai báo kích thước mảng trước
// các phần tử nhận giá trị mặc định (0)
kieuDuLieu[] tenMang = new kieuDuLieu[KichThuoc];

// Cách 2: Khai báo và gán sẵn giá trị ban đầu
int[] scores = {90, 85, 78, 92, 100};
String[] fruits = {"Táo", "Cam", "Xoài"};
```

- 1 số thao tác
```java

int[] numbers = new int[3];

// Gán giá trị theo chỉ số (index bắt đầu từ 0)
numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;

// Truy xuất giá trị
System.out.println("Phần tử đầu tiên: " + numbers[0]); // 10

// Lấy chiều dài của mảng
System.out.println("Độ dài mảng: " + numbers.length); // 3

// Duyệt mảng bằng vòng lặp for
for (int i=0; i<3; ++i) {
     System.out.println(numbers[i]);
}
// Duyệt mảng bằng vòng lặp for-each
for (int num : numbers) {
     System.out.println(num);
}
// lưu ý khi dùng for-each sẽ không thay đổi được giá trị các phần tử trong mảng

// Khi truy cập ngoài kích thước mảng sẽ bị lỗi
```
---
## **V. CLASS VÀ OBJECT**

