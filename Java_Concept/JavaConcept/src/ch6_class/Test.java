package ch6_class;

public class Test {
    public int a;
    public int b;

    public Test(int a, int b) { // 생성자
        this.a = a;
        this.b = b;
    }
    public static void print() {
        System.out.println("안녕하세요.");
    }
    public void print2() {
        System.out.println("반가워요.");
    }
}
