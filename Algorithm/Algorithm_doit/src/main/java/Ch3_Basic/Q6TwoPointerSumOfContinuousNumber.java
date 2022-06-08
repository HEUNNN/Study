package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6TwoPointerSumOfContinuousNumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int result = 1;

        int start = 1;
        int end = 1;
        int sum = 1;
        while (end != N) {
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum == N) {
                sum -= start;
                start++;
                result++;
            } else { // sum > N
                sum -= start;
                start++;
            }
        }

        System.out.println(result);
    }
}
