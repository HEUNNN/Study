package ch11;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        Queue priorityQ = new PriorityQueue();
        priorityQ.offer(3); // priorityQ.off(new Integer(3)); -> 오토박싱
        priorityQ.offer(1);
        priorityQ.offer(5);
        priorityQ.offer(2);
        priorityQ.offer(4);
        System.out.println(priorityQ);
        // 우선순위는 숫자가 작을수록 높다.

        Object obj = null;
        // PriorityQueue에 저장된 요소를 하나씩 꺼낸다.
        while ((obj = priorityQ.poll()) != null) {
            System.out.println(obj);
        }
    }
}
