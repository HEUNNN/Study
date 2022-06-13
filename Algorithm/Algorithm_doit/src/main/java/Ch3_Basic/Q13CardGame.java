package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13CardGame {
    // 백준 2164
    // 1번 카드가 가장 위, N번 카드가 가장 아래인 상태로 놓여 있고, 아래의 동작을 카드가 1장 남을 때 까지 반복한다.
    // 가장 위에 있는 카드를 버린다.
    // 그 다음 가장 위에 있는 카드를 가장 아래의 카드 밑으로 옮긴다.
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Scanner 보다 훨씬 빠르다.
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i); // 뒤에서 add
        }

        // q.remove() : Queue의 제일 앞 원소를 제거 후 반환

        while (q.size() > 1) {
            q.remove();
            // int tmp = q.remove();
            q.add(q.remove());
        }

        System.out.println(q.remove());

    }
}
