package Ch7TheoryOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q38FindPrimeNumber2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int sqrt = 10000000; // 10^14의 sqrt
        long[] arr = new long[sqrt + 1];
        // 어차피 10^7보다 +1 이라도 큰 수가 소수여도 제곱하면 범위를 벗어나기 때문에 탐색해야할 배열의 크기는 10^7 이다.

        int length = arr.length;

        // 10000000 는 당연히 소수가 아니기 때문에 굳이 배열을 안채워도 된다.
        for (int i = 2; i < length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(length); i++) { // 제곱근까지만 체크한다.

            if (arr[i] == 0) continue;

            for (int j = i + i; j < length; j = j + i) { // 배수 지우기
                arr[j] = 0;
            }
        }

        int cnt = 0;

        for (int i = 2; i < length; i++) {
            int num = 2;
            if (arr[i] == 0) continue;
            long tmp = arr[i];

            while (((double) arr[i] * (double) tmp) <= (double) M) {
                if (((double) arr[i] * (double) tmp) >= (double) N) {
                    cnt++;
                }
                tmp *= arr[i];
            }
        }

        System.out.println(cnt);
    }
}