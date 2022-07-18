package Ch7TheoryOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q42EuclideanEx1 { // 유클리드 호제법
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int res = GCD(a, b);
            System.out.println((a * b) / res);
        }
    }

    private static int GCD(int x, int y) {

        if (y == 0) {
            return x;
        } else {
            return GCD(y, x % y);
        }

    }
}
