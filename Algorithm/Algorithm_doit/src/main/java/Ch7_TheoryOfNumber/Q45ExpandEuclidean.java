package Ch7_TheoryOfNumber;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q45ExpandEuclidean {

    static long x = 1;
    static long y = 0;
    static Stack<Long> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        long tmp = GCD(A, B);

        if (C % tmp != 0) {
            System.out.println(-1);
            return;
        }

        long a = A;
        long b = B;
        boolean flag = false;
        while (!flag) {
            stack.add(a / b);

            long rest = a % b;
            if (rest == 0) {
                flag = true;
            }
            a = b;
            b = rest;

        }

        DFS(x, y);
        long K = C / tmp;
        System.out.println(x * K + " " + y * K);

    }

    public static long GCD(long a, long b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }

    public static void DFS(long preX, long preY) {
        if (stack.isEmpty()) {
            return;
        }
        long p = stack.pop();
        x = preY;
        y = preX - (preY * p);
        DFS(x, y);
    }
}
