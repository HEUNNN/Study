import java.util.ArrayList;
import java.util.Arrays;

public class Review {
    static int cnt = 0;

    public int solution(int[] array, int target) {
        int answer = 0;
        int originSum = 0;
        for (int i = 0; i < array.length; i++) {
            originSum += array[i];
        }


        DFS(array, target, 0, originSum);


        return answer;
    }

    public void DFS(int[] array, int target, int s, int sum) {
        if (s > array.length - 1) {
             return;
        }
        sum -= (array[s] * 2);
        if (sum < target) {
            return;
        } else if (sum > target) {
            s++;
            DFS(array, target, s, sum);
        } else {
            cnt++;
            return;
        }
    }
}