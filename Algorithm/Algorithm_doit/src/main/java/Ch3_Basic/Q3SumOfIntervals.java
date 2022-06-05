package Ch3_Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Q3SumOfIntervals {
    // 구간 합의 핵심이론: 합 배열을 미리 구해놓는 것이 핵심이다. 합 배열을 구해두면 시간 복잡도가 O(N) -> O(1)로 감소한다.
    // i부터 j까지 구갑합을 미리 구해둔 합 배열(s[n])을 사용하여 구하는 방법: s[j] - s[i-1]
    // 백준 11659, 구간 합 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken()); // 질의 개수

        int[] intervalSum = new int[N + 1]; // 구간 합

        st = new StringTokenizer(br.readLine());

        // intervalSum[0] = 0
        for (int i = 1; i <= N; i++) {
            intervalSum[i] = intervalSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(intervalSum[end] - intervalSum[start - 1]);
        }
    }
}
