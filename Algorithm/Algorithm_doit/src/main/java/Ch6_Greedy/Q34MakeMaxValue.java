package Ch6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class Q34MakeMaxValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수의 개수

        PriorityQueue<Integer> positiveQ = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순으로 정렬\
        int one = 0;
        int zero = 0;
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val > 1) {
                positiveQ.add(val);
            } else if (val == 1) {
                one++;
            } else if (val == 0) {
                zero++;
            } else {
                negativeQ.add(val);
            }
        }

        int sum = 0;
        // 1보다 큰 양수
        while (positiveQ.size() > 1) {
            Integer d1 = positiveQ.remove();
            Integer d2 = positiveQ.remove();
            sum += (d1 * d2);
        }
        if (positiveQ.size() == 1){
            sum += positiveQ.remove();
        }

        // 1
        sum += one;

        // 음수
        while (negativeQ.size() > 1) {
            Integer d1 = negativeQ.remove();
            Integer d2 = negativeQ.remove();
            sum += (d1 * d2);
        }

        // 0
        if (!negativeQ.isEmpty() && zero == 0) {
            sum += negativeQ.remove();
        }

        System.out.println(sum);
    }
}
