package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q31FindNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int s = 1;
        int e = K;


        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            // count가 많다는 것은 임의의 mid보다 작은 수가 B[K]보다 많다는 뜻
            if (cnt >= K) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }

        System.out.println(s);
    }
}
