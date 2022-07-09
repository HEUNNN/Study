package Ch7TheoryOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q40FindNotSquareNum {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long MIN = Long.parseLong(st.nextToken());
        long MAX = Long.parseLong(st.nextToken());

        int length = (int) (MAX - MIN) + 1;

        long[] arr = new long[length];

        for (int i = 0; i < length; i++) {
            arr[i] = i + MIN;
        }


        for (long i = 2; i * i <= MAX; i++) {
            long pow = i * i;
            long start = MIN / pow; // 25
            if (MIN % pow != 0) {
                start++;
            }
            for (long j = start; j * pow <= MAX; j++) {
                long realValue = j * pow; // 0 ->
                int index = (int) (realValue - MIN);
                arr[index] = 0;
            }
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] != 0) {
                result++;
            }
        }

        System.out.println(result);

    }
}
