package Recursion;

public class Binary {
    public static void main(String[] args) {
        int n = 4;
        binary(8);

    }
    public static void binary(int n) {
        if (n == 1) {
            System.out.print(1);
            return;
        }
        binary(n / 2);
        System.out.print(n % 2);


    }
    public static void binary2(int n) {
        // 강의 답안
        if(n < 2) {
            System.out.println(n);
        } else {
            binary2(n / 2);
            System.out.println(n % 2);
        }
    }
}
