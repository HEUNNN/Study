import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

    }
    public int solution(String s) {
        int n = s.length();
        int answer = n;

        for (int i = 1; i <= n / 2; i++) {
            String newStr = pressedString(s, i);
            if (answer > newStr.length()) {
                answer = newStr.length();
            }
        }

        return answer;
    }

    public String pressedString(String s, int length) {

        Queue<String> q = new LinkedList<>();
        String tmp = ""; // 길이: 0

        // queue에 length 만큼씩 잘라서 넣기
        for (int i = 0; i < s.length(); i++) {
            tmp += s.charAt(i);

            if (tmp.length() == length) {
                q.add(tmp);
                tmp = "";
            }
        }
        if (tmp.length() >= 1) {
            q.add(tmp);
        }

        String res = "";
        while (!q.isEmpty()) {
            int cnt = 0;
            String cur = q.poll(); // 큐에서 한개 뽑기
            while (!q.isEmpty()) {
                if (cur.equals(q.peek())) {
                    cnt++;
                    q.poll(); // cur 이랑 같으므로 cnt++ 후 큐에서 뽑기
                } else {
                    break;
                }
            }
            if (cnt == 0) {
                res += cur;
            } else {
                res += ((cnt + 1) + cur);
            }
        }
        return res;
    }
}