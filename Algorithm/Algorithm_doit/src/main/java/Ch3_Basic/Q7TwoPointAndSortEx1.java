package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7TwoPointAndSortEx1 {
    // 백준 1940
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        int start = 0;
        int end = N - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum > M) {
                end--;
            } else if (sum < M) {
                start++;
            } else { // sum == M
                cnt++;
                start++;
                end--;
            }
        }
        System.out.println(cnt);

    }
}
