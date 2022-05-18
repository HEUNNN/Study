package Debugging;

import java.util.Scanner;

public class DebuggingEx {
    public static void main(String[] args) {
        // TODO 배열에서 주어진 범위의 합을 구하는 프로그램을 작성하시오.
        Scanner sc = new Scanner(System.in);

        System.out.println("testCase 입력...");
        int testCase = sc.nextInt();
        int answer = 0;
        int A[] = new int[100001];
        int B[] = new int[100001];

//        System.out.println(B[0]); // B[0] = 0
//        Integer b[] = new Integer[100];
//        System.out.println(b[0]); // b[0] = null

        for (int i = 1; i < 10000; i++) {
            A[i] = (int) (Math.random() * Integer.MAX_VALUE);
            B[i] = B[i - 1] + A[i];
        }
        System.out.println("query 입력...");
        for (int j = 1; j < testCase; j++) {
            int query = sc.nextInt();
            for (int k = 0; k < query; k++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                answer += B[end] - B[start-1];
                System.out.println(testCase + " " + answer);
            }
        }


    }
}
