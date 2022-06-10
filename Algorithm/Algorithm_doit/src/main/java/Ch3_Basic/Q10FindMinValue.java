package Ch3_Basic;


import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10FindMinValue {
    // 백준 11003
    // N개의 수 A1, A2, ..., An과 L이 주어진다. Ai-L+1 ~ Ai 중 최솟값을 Di라고 할 때 D에 저장된 수를 출력하는 문제이다.
    // i <= 0인 Ai는 무시하고 D를 구해야한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Node currNode = new Node(i, Integer.parseInt(st.nextToken()));
            while (!deque.isEmpty() && deque.getLast().value > currNode.value) {
                deque.removeLast();
            }
            deque.add(currNode);
            if (currNode.index - deque.getFirst().index >= L) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
