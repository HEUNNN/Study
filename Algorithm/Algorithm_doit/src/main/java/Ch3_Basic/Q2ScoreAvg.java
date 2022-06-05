package Ch3_Basic;

import java.util.Scanner;

public class Q2ScoreAvg {
    // 백준 1546
    // 기말고사를 망친 학생은 점수를 조작하기로 하였다. 본인의 점수 중 최댓값 M을 고르고, 모든 점수를 (점수 / M * 100)으로 고쳤다. 이때 새로운 평균을 구하시오.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scoreArr = new int[N];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            scoreArr[i] = sc.nextInt();
            if (scoreArr[i] > max) {
                max = scoreArr[i];
            }
            sum += scoreArr[i];
        }

        double result = (sum * 100.0) / (max * N);

        System.out.println(result);


    }
}
