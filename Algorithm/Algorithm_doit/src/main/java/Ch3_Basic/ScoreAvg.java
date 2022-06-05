package Ch3_Basic;

import java.util.Scanner;

public class ScoreAvg {
    // 백준 1546
    // 기말고사를 망친 학생은 점수를 조작하기로 하였다. 본인의 점수 중 최댓값 M을 고르고, 모든 점수를 (점수 / M * 100)으로 고쳤다. 이때 새로운 평균을 구하시오.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        float M = 0;
        float sum = 0;

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
            if (num[i] > M) {
                M = (float)num[i];
            }
        }

        for (int i = 0; i < N; i++) {
            sum += (float)num[i];
        }
        System.out.println(sum * 100.0 / M / N);


    }
}
