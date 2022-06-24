package Ch4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15BubbleSortEx1 {
    // 백준 2750
    // N개의 수가 주어졌을 때 이를 오름차순으로 정렬한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputArr = new int[N];

        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (inputArr[j-1] > inputArr[j]) {
                    int tmp = inputArr[j - 1];
                    inputArr[j-1] = inputArr[j];
                    inputArr[j] = tmp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(inputArr[i]);
        }
    }
}
