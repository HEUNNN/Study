package Recursion;

public class DoublePower {
    public static void main(String[] args) {
        double x = 2;
        int n = 4;
        double result = doublePower(x, n);
        System.out.println(x + "^" + n + ": " + result);
    }
    public static double doublePower(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * doublePower(x, n - 1);
        }
    }
}
