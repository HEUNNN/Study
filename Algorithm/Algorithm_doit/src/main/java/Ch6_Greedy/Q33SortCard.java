package Ch6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q33SortCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Integer num = Integer.parseInt(st.nextToken());
            q.add(num);
        }

/*        for (int i = 0; i < N; i++) {
            System.out.println(q.poll());
        }*/

        int d1 = 0;
        int d2 = 0;
        int sum = 0;

        while (q.size() != 1) {
            d1 = q.poll();
            d2 = q.poll();

            sum += (d1 + d2);
            q.add(d1 +  d2); // 우선 순위 큐 삽입
            // 작은 묶음 부터 더하는 것이 포인트
            // 묶음이 10, 40, 45, 46으로 주어질 때 첫 회차에 (10 + 40)으로 50이 큐에 add 될 때는 50이 남은 45, 46 보다 크니까 우선순위 큐에 의해 가장 뒤로 간다.
            // 이렇게 하면 묶음 수가 작은 것 부터 묶을 수 있다.
        }

        System.out.println(sum);

    }
}