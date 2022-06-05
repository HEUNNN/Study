package Ch3_Basic;

import java.util.Scanner;

public class SumOfIntervals {
    // 구간 합의 핵심이론: 합 배열을 미리 구해놓는 것이 핵심이다. 합 배열을 구해두면 시간 복잡도가 O(N) -> O(1)로 감소한다.
    // i부터 j까지 구갑합을 미리 구해둔 합 배열(s[n])을 사용하여 구하는 방법: s[j] - s[i-1]
    // 백준 11659, 구간 합 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수의 개수
        int M = sc.nextInt(); // 합을 구해야하는 횟수, 질의 횟수

        int[] numArr = new int[N];
        int[] intervalArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
            if(i == 0) {
                intervalArr[0] = numArr[0];
            } else {
                intervalArr[i] = intervalArr[i - 1] + numArr[i];
            }
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            if (a == 0) {
                System.out.println(intervalArr[b]);
            } else {
                int result = intervalArr[b] - intervalArr[a - 1];
                System.out.println(result);
            }
        }
    }
}
