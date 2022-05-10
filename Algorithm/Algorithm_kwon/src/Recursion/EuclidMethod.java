package Recursion;

/* 최대 공약수 Euclid Method
 *  m>=n 인 두 양의 정수 m과 n에 대해서 m이 n의 배수이면 gcd(m,n)=n이고,
 *   그렇지 않으면 gcd(m,n)=gcd(n,m%n)이다.
 * */
public class EuclidMethod {
    public static void main(String[] args) {
        int m = 10;
        int n = 7;
        double result = gcd(m,n);
        System.out.println("gcd(" + m + ", " + n + "): " + result);
    }
    public static double gcd(int m, int n) {
        if (m < n) {
            int tmp;
            tmp = m;
            m = n;
            n = tmp;
        }
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }
}
