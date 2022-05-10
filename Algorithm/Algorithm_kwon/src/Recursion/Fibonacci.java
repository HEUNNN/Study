package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 3;
        int result = fibonacci(n);
        System.out.println("fibonacci(" + n + ") : " + result);
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
