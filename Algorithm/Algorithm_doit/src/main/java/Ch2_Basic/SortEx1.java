package Ch2_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.stream.LongStream;

public class SortEx1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int startIdx = 0;
        int endIdx = N - 1;
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        while (startIdx < endIdx) {
            long tmp = arr[startIdx] + arr[endIdx];
            if (tmp < M) {
                startIdx++;
            } else if (tmp > M) {
                endIdx--;
            } else {
                cnt++;
                endIdx--;
                startIdx++;
            }
        }
        System.out.println(cnt);

    }
}
