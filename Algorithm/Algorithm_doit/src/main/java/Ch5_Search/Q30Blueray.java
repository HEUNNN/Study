package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30Blueray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 레슨 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 개수

        int[] arr = new int[N];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > start) start = arr[i];
            end = end + arr[i];
        }

        while (start <= end) {

            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;

                    // return이 없기 때문에 조건 문이 끝나도 아래의 코드 수행된다.
                }
                sum += arr[i];

            }

            // 탐색 후 sum이 0이 아니면 cnt ++
            if (cnt != 0) cnt++;

            if (cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);


    }
}
