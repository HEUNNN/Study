package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfIntervalsEx2 {
    // 백준 11660
    /*
     * 첫 번째 줄에 표의 크기 N과 질의 횟수 M이 주어진다. (1<= N <= 1024, 1 <= M <= 100000)
     * 표는 N * N
     * 2 - N 번째 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
     * 다음 M개의 줄에는 4개의 정수 X1, Y1, X2, Y2가 주어지며 (X1, Y1)에서 (X2, Y2)의 합을 구해야한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        int[][] original = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + original[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
