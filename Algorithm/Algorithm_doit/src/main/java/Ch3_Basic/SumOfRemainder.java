package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfRemainder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] count = new long[M];
        int[] s = new int[N + 1];
        long result = 0;
        for (int i = 1; i <= N; i++) {
            s[i] = (s[i - 1] + Integer.parseInt(st.nextToken())) % M;
            count[s[i]] ++; // 같은 나머지의 인덱스를 카운트하는 배열
        }
        for (int i = 0; i < M; i++) {
            if (count[i] != 0) {
                result += combi(count[i]);
            }
        }
        result += count[0]; // 구간의 합을 %M 한 배열의 값 중에서 0의 수를 더해줘야 한다.
        System.out.println(result);
    }
    public static long combi(long a) { // nC2를 하는 조합 함수
        return (a * (a-1)) / 2;
    }
}
