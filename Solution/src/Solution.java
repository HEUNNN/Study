
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 1, 3, 3, 0, 1, 1};
        int[] solution = new Solution().solution2(array);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    public int[] solution(int[] arr) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (!st.isEmpty() && st.peek() == arr[i]) {
                continue;
            }
            st.add(arr[i]);
        }

        int[] answer = new int[st.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }

        return answer;
    }

    public int[] solution2(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        int preNumber = 10;
        for (int i = 0; i < arr.length; i++) {
            if (preNumber != arr[i]) {
                list.add(arr[i]);
                preNumber = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

}