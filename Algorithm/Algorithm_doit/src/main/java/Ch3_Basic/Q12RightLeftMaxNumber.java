package Ch3_Basic;

import java.io.*;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q12RightLeftMaxNumber {
    // 백준 17298
    // 오큰수 구하기
    // Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중 가장 왼쪽에 있는 수를 의미한다. 오큰수가 없을 경우 오큰수는 -1이다. ( 가장 큰 수 아니다.)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            stack.push(num);
            for (int j = i + 1; j < N; j++) {
                if (stack.peek() < arr[j]) {
                    stack.pop();
                    stack.push(arr[j]);
                    break;
                }
            }
            if (stack.peek() == num) {
                result[i] = -1;
            } else {
                result[i] = stack.pop();
            }

        }
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
