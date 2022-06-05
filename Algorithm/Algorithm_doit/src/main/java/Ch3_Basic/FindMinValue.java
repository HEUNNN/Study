package Ch3_Basic;


import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class FindMinValue {
    // 백준 11003
    // N개의 수 A1, A2, ..., An과 L이 주어진다. Ai-L+1 ~ Ai 중 최솟값을 Di라고 할 때 D에 저장된 수를 출력하는 문제이다.
    // i <= 0인 Ai는 무시하고 D를 구해야한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int L = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우의 크기
        int[] result = new int[N];
        int startIdx;

        Deque<int[]> myDeque = new ArrayDeque<>(); // [{val, idx} , {val, idx} , ... , {val, idx}]

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!myDeque.isEmpty() && myDeque.peekLast()[0] > now) {
                myDeque.pollLast();
            }
            myDeque.offer(new int[] {now, i});
            if ((i - myDeque.peek()[1]) >= L) {
                myDeque.poll();
            }
            bw.write(myDeque.peek()[0] + " ");
        }
        bw.flush();
        bw.close();
    }

}
