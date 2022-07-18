package Ch7TheoryOfNumber;

import java.io.*;
import java.util.StringTokenizer;

public class Q43EuclideanEx2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long length = GCD(A, B);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (length > 0) {
            bw.write("1");
            length--;
        }

        bw.flush();
        bw.close();

    }

    private static long GCD(long x, long y) {
        if (y == 0) return x;
        else return GCD(y, x % y);
    }
}