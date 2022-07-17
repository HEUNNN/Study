import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";

        String answer = solution(new_id5);
        System.out.println(answer);
    }

    public static String solution(String new_id) {

        String answer = "";

        // 1단계
        String lowerCase = new_id.toLowerCase();

        // 2단계
        String check = "~!@#$%^&*()=+[{]}:?,<>/";

        Deque<Character> dq1 = new LinkedList<>();
        Deque<Character> dq2 = new LinkedList<>();

        for (int i = 0; i < lowerCase.length(); i++) {
            if (check.indexOf(lowerCase.charAt(i)) == -1) {
                dq1.add(lowerCase.charAt(i));
            }
        }

        // 3단계
        while (!dq1.isEmpty()) { // poll == pollFirst
            Character tmp = dq1.pollFirst();
            if (tmp == '.') {
                while (dq1.size() >= 1 && dq1.peekFirst() == '.') {
                    dq1.pollFirst();
                }
                dq2.addLast(tmp);
            } else {
                dq2.addLast(tmp);
            }
        }

        dq1 = copyDQ(dq2);

        // 4단계

        if (dq1.size() >= 1 && dq1.peekFirst() == '.') {
            dq1.pollFirst();
        } else if (dq1.size() >= 1  && dq1.peekLast() == '.') {
            dq1.pollLast();
        }

        // 5단계
        if (dq1.isEmpty()) {
            dq1.add('a');
        }

        // 6단계
        if (dq1.size() >= 16) {
            while (dq1.size() >= 16) {
                dq1.pollLast();
            }
        }

        while (dq1.peekLast() == '.') {
            dq1.pollLast();
        }

        // 7단계
        if (dq1.size() <= 2) {
            while (dq1.size() < 3) {
                dq1.add(dq1.peekLast());
            }
        }

        while (!dq1.isEmpty()) {
            answer += dq1.poll();
        }

        return answer;
    }
    public static Deque<Character> copyDQ(Deque<Character> dq) {
        Deque<Character> newDq = new LinkedList<>();
        while (!dq.isEmpty()) {
            newDq.addLast(dq.pollFirst());
        }

        return newDq;
    }
}