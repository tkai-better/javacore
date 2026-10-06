# **BUỔI 3 - MỌI THỨ ĐỀU LÀ ĐỐI TƯỢNG**
# **I. TÍNH ĐÓNG GÓI**

## **1. Khái niệm**

Tính đóng gói trong Java là kỹ thuật ẩn giấu chi tiết triển khai của một đối tượng và chỉ cung cấp các phương thức công khai để truy cập hoặc thay đổi dữ liệu.

---

## **2. Phạm vi truy cập**

- `default` (mặc định): Nếu như bạn không khai báo phạm vi truy cập thì Java sẽ hiểu mặc định phạm vi truy cập là *default*. Với *default* thì trong *class* đó và trong *package* đó mới có thể nhìn thấy được.

- `private` (riêng tư): chỉ duy nhất trong lớp (class) đó mới có thể nhìn thấy được.

- `public` (công khai): mọi nơi đều có thể nhìn thấy được.

- `protected` (được bảo vệ): *class* đó, *package* đó, *subclass* có thể nhìn thấy được.

**VD**:

```java
public class HinhChuNhat {
    private int rong; 
    private int dai; 
    
    // Các phương thức GETTER và SETTER
    public void setRong(int rong){
        this.rong = rong;
    }
    public void setDai(int dai){
        this.dai = dai;
    }
    public int getRong(){
        return this.rong;
    }
    public int getDai(){
        return this.dai;
    }
}
```

```java
HinhChuNhat a = new HinhChuNhat();
a.rong = 10  
// SAI vì rong là private không thể truy cập ngoài class
a.setRong(10)  
// dùng SETTER để thay đổi giá trị của thuộc tính rong bên ngoài class
```

---

## **3. Tại sao cần đóng gói?**

- Tăng tính bảo mật: Bằng cách ẩn dữ liệu, tính đóng gói ngăn chặn việc sửa đổi dữ liệu không đúng cách, đảm bảo rằng chỉ các phương thức được chỉ định mới có thể thay đổi trạng thái của đối tượng.

- Tăng tính kiểm soát cũng như giảm sự phụ thuộc giữa các phần khác nhau.

---

## **4. Những lưu ý khi sử dụng Tính Đóng Gói**

- **Không lạm dụng** *getter* và *setter*: Việc cung cấp *getter* và *setter* cho mọi thuộc tính có thể làm mất đi ý nghĩa của tính đóng gói. Hãy chỉ cung cấp những phương thức thực sự cần thiết.

```java
public class BankAccount {
    // Thuộc tính được bảo vệ (private), bên ngoài không thể truy cập trực tiếp
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
    }

    // Chỉ cung cấp Getter đọc thông tin khi thực sự cần thiết
    public double getBalance() {
        return balance;
    }

    // KHÔNG CÓ setBalance(). Thay vào đó là hành vi cụ thể có kiểm soát:
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền rút phải lớn hơn 0!");
        }
        if (amount > balance) {
            System.out.println("Số dư tài khoản không đủ!");
        }
        this.balance -= amount; // Trạng thái được cập nhật an toàn bên trong lớp
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền nạp phải lớn hơn 0!");
        }
        this.balance += amount;
    }
}
```

- Kiểm tra dữ liệu chặt chẽ: Trong các phương thức *setter*, luôn kiểm tra tính hợp lệ của dữ liệu để đảm bảo tính toàn vẹn.

---

## **5. Ứng dụng**

Tính đóng gói được sử dụng rộng rãi trong các ứng dụng Java, từ phát triển ứng dụng web, ứng dụng di động đến hệ thống quản lý doanh nghiệp. Một số ví dụ thực tế bao gồm:

- Ứng dụng ngân hàng: Các thông tin như số dư tài khoản, mật khẩu được đóng gói để chỉ có thể truy cập thông qua các phương thức được xác thực.

- Hệ thống quản lý sinh viên: Thông tin cá nhân của sinh viên được bảo vệ, chỉ có thể thay đổi thông qua các phương thức được định nghĩa sẵn.

- Ứng dụng thương mại điện tử: Dữ liệu giỏ hàng hoặc thông tin thanh toán được đóng gói để đảm bảo an toàn

---

# **II. Tính Kế thừa**

## **1. Khái niệm**

- Tính kế thừa (Inheritance) trong Java là một đặc tính quan trọng của lập trình hướng đối tượng, cho phép một *class* (class con) thừa hưởng các thuộc tính và phương thức từ một *class* khác (class cha). 

- Cú pháp: sử dụng từ khóa `extends`

```java
public class ParentClass {
    // Code của parent
}
public class ChildClass extends ParentClass {
    // Kế thừa từ ParentClass
}
```

---

## **2. Đặc điểm**

Trong Java, lớp cha (superclass) là lớp cung cấp các thuộc tính và phương thức cho lớp con (subclass). Lớp con có thể:

- Thừa hưởng các thuộc tính và phương thức từ lớp cha (chỉ với `public` và `protected`).
- Thêm các thuộc tính và phương thức mới.
- Ghi đè (*override*) các phương thức của lớp cha để cung cấp triển khai cụ thể.

**VD**:
```java
class Animal {
    void eat() {
        System.out.println("Đang ăn...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Gâu gâu...");
    }
}
```

```java
    Dog a = new Dog();
    a.eat();
    a.bark();
```

- Trong ví dụ này, lớp *Dog* kế thừa từ lớp *Animal*, do đó đối tượng *Dog* có thể gọi phương thức `eat()` của *Animal* và phương thức của chính nó là `bark()`.

---

## **3. Constructor trong Kế Thừa**

Trong lập trình hướng đối tượng (OOP), khi một lớp con kế thừa từ lớp cha , cơ chế hoạt động của *constructor* có những quy tắc đặc thù nhằm đảm bảo các thuộc tính được kế thừa từ lớp cha được khởi tạo hợp lệ trước khi lớp con sử dụng.

Thứ tự gọi: Khi khởi tạo đối tượng lớp con, *constructor* của lớp cha luôn được gọi trước để khởi tạo phần dữ liệu thuộc về lớp cha.

Từ khóa `super()`:

- Nếu lớp cha có *constructor* mặc định (không tham số), compiler tự động chèn `super()` vào dòng đầu tiên của *constructor* lớp con.

- Nếu lớp cha chỉ có constructor có tham số, lớp con bắt buộc phải gọi tường minh `super(tham_số)` ở dòng đầu tiên của constructor.

**VD**:

```java

class Employee {
    protected String name;
    protected double salary;

    // 1. Constructor mặc định (không tham số) của lớp cha
    public Employee() {
        this.name = "Unknown";
        this.salary = 0.0;
    }

    // 2. Constructor có tham số của lớp cha
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

// Lớp con
class Manager extends Employee {
    String department;

    // Trường hợp A: Lớp con gọi tường minh constructor có tham số của lớp cha
    public Manager(String name, double salary, String department) {
        super(name, salary); // Gọi constructor của lớp cha
        this.department = department;
    }

    // Trường hợp B: Lớp con không gọi super(tham_số)
    // compiler tự động chèn super() là constructor mặc định của lớp cha
    public Manager(String department) {
        // Compiler tự động ngầm hiểu ở đây có dòng: super();
        this.department = department;
    }

    public void display() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Dept: " + department);
    }

public class Main {
    public static void main(String[] args) {
        // Trường hợp A
        Manager m1 = new Manager("Alice", 5000.0, "IT");
        m1.display();
        // Trường hợp B
        Manager m2 = new Manager("HR");
        m2.display();
    }
}
_________________
// OUTPUT
Name: Alice, Salary: 5000.0, Dept: IT
Name: Unknown, Salary: 0.0, Dept: HR
```
---

## **4. Variable Hiding (Che Dấu Biến)**

- Khái niệm Variable Hiding (Che giấu biến) trong Java xảy ra khi một lớp con khai báo một biến (thuộc tính/field) có cùng tên với biến đã được khai báo ở lớp cha.

- Khi hiện tượng này xảy ra, biến ở lớp con sẽ "che giấu" biến của lớp cha trong phạm vi của lớp con.

- Sử dụng từ khóa `super`: Nếu muốn truy cập biến bị che giấu của lớp cha từ bên trong lớp con, bạn bắt buộc phải dùng từ khóa `super`.

**VD**:

```java
class Animal {
    String ten = "Động vật chung";
}

class Dog extends Animal {
    // Che giấu biến ten của lớp cha
    String ten = "Chó Cảnh (Lu"; 

    void hienThiThongTin() {
        // Truy cập biến ten của lớp con
        System.out.println("Tên ở lớp con: " + ten); 
        
        // Truy cập biến ten của lớp cha bằng từ khóa super
        System.out.println("Tên ở lớp cha: " + super.ten);
    }
}
```
---

## **5. Đa Kế Thừa**
### *5.1 Khái niệm*

- **Định nghĩa**: Đa kế thừa là hiện tượng một lớp con có thể kế thừa trực tiếp từ nhiều lớp cha khác nhau.

- Tuy nhiên, trong Java không cho phép 1 lớp con có thể kế thừa nhiều lớp cha (không có `class C extends A, B`).

```
       A (Lớp gốc có hàm `keu()`)
      / \
     /   \
    B     C (B và C Cùng ghi đè hàm `keu()`)
     \   /
      \ /
       D 
D kế thừa cả B và C nhưng Không biết chọn `keu()` của B hay C?
```
---
### *5.2 INTERFACE*
- Java cho phép đạt được mục đích của đa kế thừa thông qua **Interface** (Giao diện) bằng từ khóa `implements`:

```java
interface GiaoTiep {
    String language;  // static public final
    void noiChuyen(); // public abstract
}
```

- Đặc điểm của `interface`:
    - Bạn không thể tạo đối tượng trực tiếp từ một giao diện trong Java.
    - Các phương thức trong giao diện mặc định là `public` và `abstract` (trừ `default` và `static`).
    -  Các biến trong giao diện mặc định là `public`, `static`, và `final`.

```java
// 1. Interface định nghĩa khả năng giao tiếp
interface GiaoTiep {
    String language = "ENGLISH";
    // dùng default -> method chung
    default void noiChuyen() {  
        System.out.println("HELLO in " + language);
    }
}

// 2. Interface định nghĩa khả năng dọn dẹp
interface DonDep {
    default void quetNha() {
        System.out.println("CLEANING");
    }
}

class Robot implements GiaoTiep, DonDep {
    // Phương thức riêng của lớp RobotThongMinh
    public void hienThiPin() {
        System.out.println("Dung lượng pin hiện tại: 95%");
    }
}

public class Main {
    public static void main(String[] args) {
        Robot myRobot = new Robot();

        // Gọi các method được tổng hợp từ nhiều interface khác nhau
        myRobot.noiChuyen();
        myRobot.quetNha();
        myRobot.hienThiPin();

        // OUTPUT:
        // HELLO in ENGLISH
        // CLEANING
        // Dung lượng pin hiện tại: 95%
    }
}
```
- Ở VD đầu:
```java
interface GiaoTiep {
    String language;  // static public final
    void noiChuyen(); // public abstract
}
```
> Muốn các lớp khác sử dụng phương thức `noiChuyen()` cần @override lại

- Lợi ích của việc sử dụng `interface` trong Java
    - **Tăng tính linh hoạt**: Giao diện trong Java cho phép lập trình viên định nghĩa các phương thức mà không cần quan tâm đến cách chúng được triển khai. Điều này giúp dễ dàng thay đổi hoặc mở rộng mã nguồn.
    - **Hỗ trợ đa kế thừa**: Giúp các lớp thực hiện nhiều hành vi khác nhau.
    - **Tăng khả năng tái sử dụng mã**: Giao diện cho phép sử dụng lại các hợp đồng chung giữa các lớp không liên quan.
    - **Dễ bảo trì và mở rộng**: Các thay đổi trong giao diện không ảnh hưởng đến các lớp thực thi, miễn là hợp đồng không bị phá vỡ.
---
# **III. UPCASTING VÀ DOWNCASTING**

## **1. UPCASTING**

- Upcasting là quá trình chuyển đổi một đối tượng của lớp con thành kiểu của lớp cha. Điều này cho phép một đối tượng lớp con được xử lý như một đối tượng của lớp cha.

- Đặc điểm:
    - Được thực hiện tự động hoàn toàn, bạn không cần phải viết thêm dấu ngoặc ép kiểu.

    - Luôn luôn an toàn vì class con chứa tất cả các thuộc tính của class cha.

- Hạn chế: Sau khi **Upcasting**, biến tham chiếu sẽ bị "bóp méo tầm nhìn" – nó chỉ có thể nhìn thấy các thuộc tính và phương thức có ở lớp cha, không còn nhìn thấy các phương thức riêng biệt của lớp con nữa.

**VD**:
```java
class Animal {
    void an() { 
      System.out.println("Động vật đang ăn..."); 
    }
}

class Dog extends Animal {
    void an() { 
      System.out.println("Chó đang gặm xương..."); 
    }

    // Phương thức riêng của Dog
    void sua() { 
      System.out.println("Gâu gâu!"); 
    } 
}

public class Main {
    public static void main(String[] args) {
        // UPCASTING: Tự động nâng kiểu từ Cho lên DongVat
        Animal dv = new Animal(); 
        Dog a = new Dog();
        dv = a; // Không cần viết (Dog) a;

        // đơn giản thì dùng Animal dv = new Dog();
        
        dv.an();

        // dv.sua(); 
        // LỖI BIÊN DỊCH! 
        // Biến dv kiểu Animal không nhìn thấy hàm sua() của Dog.
    }
}
```
---
## **2. DOWNCASTING**

- **Downcasting** là quá trình chuyển đổi một đối tượng của lớp cha về kiểu của lớp con. Điều này cho phép lớp cha truy cập các phương thức và thuộc tính riêng của lớp con mà không có trong lớp cha.

**VD**:
```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
    
    void eat() {
        System.out.println("Dog is eating...");
    }
}

public class Main {
    public static void main(String[] args) {
        // Upcasting (Tự động)
        Animal myAnimal = new Dog(); 
        myAnimal.makeSound(); // Dog barks


        // myAnimal.eat();  
        // Lỗi biên dịch vì kiểu biên dịch là Animal không có phương thức eat()

        // Downcasting (Tường minh)
        Dog myDog = (Dog) myAnimal;
        myDog.eat(); // Hoạt động bình thường vì đã ép về kiểu Dog
    }
}
```

- Downcasting yêu cầu chỉ định tường minh và có thể gây ra lỗi *`ClassCastException`* nếu đối tượng không thực sự là instance của lớp con. Do đó, cần kiểm tra kỹ trước khi thực hiện downcasting.

**VD lỗi**:
```java
Animal animal = new Animal();
Dog dog = (Dog) animal; // Lỗi! Animal không phải là một Dog thực sự ở bộ nhớ.
```

- Để tránh ngoại lệ *ClassCastException*, bạn nên luôn kiểm tra kiểu của đối tượng bằng `instanceof` trước khi tiến hành Downcasting:

```java
Animal myAnimal = new Dog();

if (myAnimal instanceof Dog) {
    Dog myDog = (Dog) myAnimal;
    myDog.eat(); // An toàn tuyệt đối
} 
else {
    System.out.println("Không thể ép kiểu đối tượng này sang Dog.");
}
```

## **3. BẢNG SO SÁNH**


|Tiêu chí | Upcasting | Downcasting |
|-|-|-|
|Định nghĩa | Chuyển đổi đối tượng từ lớp con lên lớp cha.	| Chuyển đổi đối tượng từ lớp cha xuống lớp con.|
Phương thức chuyển đổi |Có thể thực hiện ngầm định hoặc tường minh.	|Phải thực hiện tường minh bằng cách ép kiểu.
Truy cập thành phần	|Chỉ truy cập được các phương thức và thuộc tính của lớp cha.|	Có thể truy cập các phương thức và thuộc tính đặc trưng của lớp con.
Độ an toàn|	An toàn, ít gây lỗi.|	Có thể gây lỗi ClassCastException nếu đối tượng không thuộc lớp con; cần kiểm tra bằng instanceof trước khi ép kiểu.
Ứng dụng|	Tận dụng tính đa hình, cho phép xử lý các đối tượng khác nhau thông qua tham chiếu của lớp cha.	|Truy cập các phương thức hoặc thuộc tính cụ thể của lớp con sau khi đã upcast đối tượng lên lớp cha.
---

# **IV. CLASS OBJECT**

## **1. Giới thiệu tổng quan**
- **Vị trí**: nằm trong *package* `java.lang.Object`

- **Vai trò**: Là *class* cơ sở cho mọi *class* trong Java. Nếu bạn định nghĩa một *class* mà không chỉ định từ khóa `extends`, Java sẽ tự động hiểu là lớp đó kế thừa trực tiếp từ `class Object`.

```java
public class Employee {
    // Tương đương với:
    // public class Employee extends Object
}
```

- **Tính chất**: vì mọi đối tượng đều là Object, bạn có thể gán bất kỳ tham chiếu đối tượng nào vào một biến kiểu Object.

```java
// Khai báo một biến có kiểu là Object
    Object obj;

// Bạn có thể gán nó bằng một chuỗi (String)
    obj = "Xin chào"; 

// Hoặc gán nó bằng một số nguyên được bọc (Integer)
    obj = 100; // AUTOBOXING

// Hoặc gán bằng một đối tượng tự định nghĩa bất kỳ
    obj = new Animal();
```
---

## **2. Các Phương Thức Quan Trọng của Object**

Lớp `Object` cung cấp các phương thức cốt lõi mà mọi đối tượng đều sở hữu. Bạn có thể ghi đè (*@Override*) các phương thức này để phù hợp với ngữ cảnh của lớp.

### A. `toString()`
- Kiểu trả về: `String`
- Mặc định: Trả về tên của class cộng với mã băm (hashcode) dưới dạng hệ thập lục phân (Ví dụ: ClassName@1b6d3586). Thường được ghi đè để in ra thông tin chi tiết của đối tượng.

```java
class Person {
    String name;
    int age;

    @Override
    public String toString() {
        return name + " " + age; 
    }
}
```
### B. `equals(Object obj)`

- Kiểu trả về: `boolean`

- Mặc định: So sánh địa chỉ ô nhớ của hai đối tượng (tương đương với toán tử ==). Thường được ghi đè để so sánh giá trị bên trong của hai đối tượng khác nhau.

```java
class Product {
    private String Id;
    private String name;
    
    public Product(String Id, String name) {
        this.Id = Id;
        this.name = name;
    }
    
    // equals theo Id
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Product other = (Product) obj;
        return Id.equals(other.Id);
    }
}
```
### C. `hashCode()`

- Chức năng: Trả về một số nguyên `int` (mã băm) đại diện cho đối tượng.

- Quy tắc: Nếu hai đối tượng bằng nhau theo phương thức `equals()`, chúng bắt buộc phải có cùng một `hashCode()`.
- Thường được Override lại cùng với `equals()`

```java
@Override
public int hashCode() {
    return Id.hashCode();
}
```
### D. `getClass()`

- Trả về class của object
- Thường được dùng để kiểm tra 2 đối tượng có thuộc cùng một class không
```java
if (o1.getClass() == o2.getClass())
```
---
# **V. TÍNH ĐA HÌNH**

Tính đa hình (polymorphism) là một trong những đặc tính quan trọng của lập trình hướng đối tượng, cho phép các đối tượng thuộc các lớp khác nhau phản hồi theo những cách khác nhau đối với cùng một lời gọi phương thức.

Trong Java, tính đa hình được thực hiện chủ yếu thông qua cơ chế kế thừa và hai hình thức chính: nạp chồng phương thức (method overloading) và ghi đè phương thức (method overriding).

---

## **1. Đa hình Compile time** (Method Overloading)

- Nạp chồng phương thức cho phép một lớp có nhiều phương thức cùng tên nhưng khác nhau về số lượng hoặc kiểu dữ liệu của tham số. Điều này giúp tăng tính linh hoạt và khả năng đọc hiểu của mã nguồn.

- Thời điểm xác định: Trình biên dịch (Compiler) sẽ quyết định gọi phương thức nào dựa vào tham số truyền vào lúc viết code.

**VD**:

```java
class Calculator {
    // Phép cộng 2 số nguyên
    int add(int a, int b) {
        return a + b;
    }

    // Phép cộng 3 số nguyên (Khác số lượng tham số)
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Phép cộng 2 số thực (Khác kiểu dữ liệu tham số)
    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println(calc.add(2, 3));         
        // Gọi hàm add(int, int) -> Kết quả: 5

        System.out.println(calc.add(1, 2, 3));      
        // Gọi hàm add(int, int, int) -> Kết quả: 6

        System.out.println(calc.add(2.5, 3.5));     
        // Gọi hàm add(double, double) -> Kết quả: 6.0
    }
}
```
---

## **2. Đa hình Runtime** (Method Overriding)

- Xảy ra giữa lớp cha và lớp con. Lớp con định nghĩa lại (viết đè) một phương thức đã có sẵn ở lớp cha với giống hệt tên, kiểu trả về và tham số.

- Thời điểm xác định: Java Virtual Machine (JVM) sẽ quyết định gọi phương thức nào dựa vào đối tượng thực tế lúc chương trình đang chạy (Runtime).

**VD**:
```java
class HinhHoc {
    void ve() {
        System.out.println("Vẽ một hình chung chung");
    }
}

class HinhTron extends HinhHoc {
    @Override
    void ve() {
        System.out.println("Vẽ hình tròn");
    }
}

class HinhVuong extends HinhHoc {
    @Override
    void ve() {
        System.out.println("Vẽ hình vuông");
    }
}

public class MainOverriding {
    public static void main(String[] args) {
        HinhHoc h1 = new HinhTron();   // Tính đa hình: Tham chiếu lớp cha, đối tượng lớp con
        HinhHoc h2 = new HinhVuong();
        
        h1.ve(); // Kết quả: Vẽ hình tròn 
        h2.ve(); // Kết quả: Vẽ hình vuông
    }
}
```

**VD về interface:**

```java
public interface Animal {
    void makeSound(); // Đây là phương thức abstract ngầm định
    void eat();
}

// BẮT BUỘC phải override lại cả makeSound và eat
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Gâu gâu");
    }

    @Override
    public void eat() {
        System.out.println("Đang ăn xương...");
    }
}
```
---
## **3. SO SÁNH OVERLOAD VÀ OVERRIDE**


TIÊU CHÍ                |  OVERLOAD       | OVERRIDE
|-|-|-|
Mối quan hệ            | Xảy ra trong cùng một lớp.              | Xảy ra giữa lớp cha và lớp con (kế thừa).
Danh sách tham số      | Phải khác nhau (kiểu hoặc số lượng).    | Phải giống hệt nhau.
Kiểu trả về            | Có thể giống hoặc khác nhau.            | Phải giống nhau (hoặc là kiểu con).
Thời gian quyết định   | Lúc biên dịch (Compile-time).           | Lúc chạy chương trình (Run-time).
Từ khóa liên quan      | Không bắt buộc.                         | Thường dùng annotation @Override.

---

## **4. LỢI ÍCH CỦA ĐA HÌNH TRONG KẾ THỪA**
- Tăng Tính Linh Hoạt: Cho phép các đối tượng khác nhau phản hồi theo cách riêng đối với cùng một lời gọi phương thức.

- Dễ Dàng Mở Rộng: Dễ dàng thêm các lớp mới mà không cần thay đổi mã nguồn hiện có.

- Quản Lý Mã Nguồn Hiệu Quả: Giảm thiểu sự trùng lặp mã và tăng tính tái sử dụng.