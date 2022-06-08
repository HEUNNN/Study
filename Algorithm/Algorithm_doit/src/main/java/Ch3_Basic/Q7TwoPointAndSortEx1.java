package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7TwoPointAndSortEx1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // readLine()은 String 값을 반환
        long[] arr = new long[N];
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            long find = arr[i];
            int startIdx = 0; // 위치가 중요, 외부에 있으면 while에서 update한 startIdx, endIdx가 반영되지 않는다.
            int endIdx = N - 1;
            while (startIdx < endIdx) {
                long sum = arr[startIdx] + arr[endIdx];
                if (sum > find) {
                    endIdx--;
                } else if (sum < find) {
                    startIdx++;
                } else {
                    if(startIdx != i && endIdx != i) {
                        cnt++;
                        break;
                    } else if (startIdx == i) {
                        startIdx++;
                    } else if (endIdx == i) {
                        endIdx--;
                    }
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
