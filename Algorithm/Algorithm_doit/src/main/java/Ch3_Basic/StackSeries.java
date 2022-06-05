package Ch3_Basic;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackSeries {
    // 백준 1874
    //  stack에 오름 차순으로 숫자를 저장할 떄(1, 2, 3, 4...) 어떻게 push, pop 해야 주어진 수열이 출력되는지 알아내는 문제이다.
    // 주어진 수열을 출력하지 못하는 케이스에는 NO를 출력한다.
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 주어질 수열의 원소 개수
        int[] arr = new int[N];
        int num = 1; // 자연수
        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer(); // +, -를 저장해둘 곳

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int curr = arr[i];
            if (curr >= num) {
                while (curr >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > curr) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}

