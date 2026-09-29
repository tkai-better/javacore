import java.util.*;

class StudentManager {
    static public String getGrade(double avg) {
        if (avg >= 8.0) return "Xuat Sac";

        else if (avg >= 7.0) return "Gioi";

        else if (avg >= 6.0) return "Kha";

        else if (avg >= 5.0) return "Trung Binh";

        else return "Yeu";
    }
}

class Student {
    String name, add, study;
    int age;
    double m1, m2, m3, avg;

    public Student(String name, int age, String add, double m1, double m2, double m3) {
        this.name = name;
        this.age = age;
        this.add = add;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.avg = (m1+m2+m3) / 3;
        this.study = StudentManager.getGrade(this.avg);
    }

    public void INRA() {
        System.out.print(this.name + " " + this.age + " " + this.add + " " +
                this.m1 + " " + this.m2 + " " + this.m3 + " ");
        System.out.printf(Locale.US, "%.3f ", this.avg);
        System.out.println(this.study);
    }
}

public class Main {
        public static void main(String []argh){
            Scanner scan = new Scanner(System.in);
            scan.useLocale(Locale.US); // Ép dùng dấu chấm cho số thực
            int n = scan.nextInt();
            Student[] ds = new Student[n];
            scan.nextLine();

            for (int i=0; i<n; ++i) {
                 String ten = scan.nextLine();
                 int old = scan.nextInt();
                 scan.nextLine();
                 String ad = scan.nextLine();
                 double a = scan.nextDouble();
                 double b = scan.nextDouble();
                 double c = scan.nextDouble();
                 ds[i] = new Student(ten, old, ad, a, b, c);
                 scan.nextLine();
            }

            int q = scan.nextInt();

            while (q-- > 0) {
                int i = scan.nextInt();
                ds[i-1].INRA();
            }

            scan.close();
        }
}