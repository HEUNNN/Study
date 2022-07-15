public class Solution {

    public static void main(String[] args) {
        long gcd = gcd(5, 3);
        System.out.println(gcd);
    }

    public static long solution(long w, long h) {

        long rectCnt = 0;


        for (long i = 1; i < w; i++) {
            double v = (double) h * i;
            rectCnt += (long) (v / w);
        }

        return rectCnt * 2;
    }
    public static long solution2(long w, long h) {
        long result = 0L;
        long gcd = gcd(w, h);
        result = (w * h) - ((w + h) - gcd);
        return result;
    }


    public static long gcd(long x, long y) {

        // x < y 여도 gcd(y, x % y)에 의해 큰 수가 앞으로 오도록 자리를 잡게된다.
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}