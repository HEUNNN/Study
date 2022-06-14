package Ch3_Basic;

import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        // Student의 id 값이 작을수록 우선 순위 high, id 가 같으면 나이가 많을수록 우선순위 high → o2의 우선순위를 매기는 것이다. !!
        // 익명 객체인가?
        PriorityQueue<Student> pq = new PriorityQueue<Student>((o1, o2) ->
        {
            if (o1.id > o2.id) {
                return 1;
            } else if (o1.id == o2.id) {
                return o2.age - o1.age; // 나이가 많을수록 우선순위 high가 되도록 한다. 만약 o1.age = 4, o2.age = 2 이면 +2(양수)가 나와서 o2의 우선순위가 더 높아진다.
            } else {
                return -1;
            }
        });
        pq.add(new Student(10, 3));
        pq.add(new Student(12, 20));
        pq.add(new Student(11, 1));
        pq.add(new Student(14, 3));
        pq.add(new Student(25, 2));

        while (pq.size() > 0) {
            Student st = pq.poll();
            System.out.println("Student age: " + st.age + ", Student id: " + st.id);
        }
    }

    public static class Student {
        int age;
        int id;

        public Student(int age, int id) {
            this.age = age;
            this.id = id;
        }
    }
}
