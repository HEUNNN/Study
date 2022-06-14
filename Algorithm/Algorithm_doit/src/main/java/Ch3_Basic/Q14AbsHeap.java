package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q14AbsHeap {
    // 백준 11286
    // 절댓값 Heap 구현하기
    // 우선순위 큐 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue pq = new PriorityQueue<Integer>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return o1 - o2;
            } else {
                return abs1 - abs2; // abs2가 작아야 우선순위가 높음, abs1 = 1이고 abs2 = 2이면 abs2의 우선순위가 abs1보다 낮다.
            }
        });

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(tmp);
            }
        }
    }
}
