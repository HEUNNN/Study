package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8TwoPointerGoodNumber {
    // 백준 1253
    // 좋은 수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            long M = arr[i];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                long sum = arr[start] + arr[end];
                if (sum < M) {
                    start++;
                } else if (sum > M) {
                    end--;
                } else { // sum == M
                    // 만약 arr[start] = 0, arr[end] = arr[i] 이라서 arr[start] + arr[end] = arr[i] 가 될 수 있다.
                    if(start != i && end != i) {
                        cnt++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
