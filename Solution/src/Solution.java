import java.util.Vector;

public class Solution {
    public static int solution(String s) {
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

    public static String pressedString(String s, int length) {

        Vector<String> v = new Vector();
        String tmp = ""; // 길이: 0

        // vector에 length 만큼씩 잘라서 넣기
        for (int i = 0; i < s.length(); i++) {
            tmp += s.charAt(i);

            if (tmp.length() == length) {
                v.add(tmp);
                tmp = "";
            }
        }
        if (tmp.length() >= 1) {
            v.add(tmp);
        }

        String res = "";
        while (v.size() != 0) {

            Integer cnt = 0;

            for (int i = 1; i < v.size(); i++) {
                if (v.get(0).equals(v.get(i))) {
                    cnt++;
                } else {
                    break;
                }
            }

            if (cnt == 0) {
                res += v.get(0);
            } else {

                res += ((cnt + 1) + v.get(0));
            }

            for (int i = 0; i <= cnt; i++) {
                v.remove(0);
            }
        }

        return res;
    }

    public int solution2(String s) {
        int answer = 0;

        if (s.length() == 1) {
            return 1;
        }
        for (int i = 1; i <= (s.length() / 2); i++) {
            int result = getSplitedLength(s, i, 1).length();
            answer = i == 1 ? result : (Math.min(answer, result));
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat) {
        if (s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if (!postString.startsWith(preString)) {
            if (repeat == 1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat + 1);
    }

}






