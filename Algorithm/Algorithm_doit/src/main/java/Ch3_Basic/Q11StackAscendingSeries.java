package Ch3_Basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Stack;

public class Q11StackAscendingSeries {
    // 백준 1874
    //  stack에 오름 차순으로 숫자를 저장할 떄(1, 2, 3, 4...) 어떻게 push, pop 해야 주어진 수열이 출력되는지 알아내는 문제이다.
    // 주어진 수열을 출력하지 못하는 케이스에는 NO를 출력한다.
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedWriter sb = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer(); // BufferWriter 사용하면 시간초과됨
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        int num = 1;
        boolean result = true;
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            if (num <= target) {
                while (num <= target) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else { // target < num
                int n = stack.pop();
                if (n != target) {
                    result = false;
                    System.out.println("NO");
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(sb.toString());
        }

    }
}

