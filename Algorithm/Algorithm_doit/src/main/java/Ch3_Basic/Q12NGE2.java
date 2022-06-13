package Ch3_Basic;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q12NGE2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputArr = new int[N];
        int[] resultArr = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0); // index를 push

        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && inputArr[stack.peek()] < inputArr[i]) {
                resultArr[stack.pop()] = inputArr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            resultArr[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(resultArr[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
