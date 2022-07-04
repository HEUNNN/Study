package Ch6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q32FindNumberOfCoin {
    // 백준 11047
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 주어진 동전의 개수 (배수관계 & 오름 차순으로 동전이 N개 주어진다.)
        Long K = Long.parseLong(st.nextToken()); // 목표 금액

        Long[] arr = new Long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        Long cnt = 0L;

        for (int i = N - 1; i >= 0 ; i--) {

            if (K >= arr[i]) {
                cnt += K / arr[i];
                K = K % arr[i];
            }

        }

        if (K == 0L) {
            System.out.println(cnt);
        }
    }
}
