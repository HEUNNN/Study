package Ch7TheoryOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q44EuclideanEx3 {

    static ArrayList<Node>[] likedList;
    static boolean[] visited;
    static long lcm; // 최소 공배수
    static long[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken()); // 재료 개수
        lcm = 1;

        MakeLinkedList(N);

        result = new long[N]; // 각 재료의 질량을 저장할 배열
        visited = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            likedList[start].add(new Node(end, p, q));
            likedList[end].add(new Node(start, q, p));

            lcm *= ( p * q / GCD(p, q)); // 비율과 관련된 숫자들의 최소 공배수 구하기, long인지 int인지 고민해보기

        }

        result[0] = lcm; // ?
        DFS(0);

        long tmp = result[0];

        for (int i = 1; i < N; i++) {
            tmp = GCD(tmp, result[i]);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] / tmp + " ");
        }


    }

    private static void DFS(int s) {

        visited[s] = true;

        for (Node node : likedList[s]) {
            int next = node.getDesti();

            if (!visited[next]) { // 방문한적이 없으면
                result[next] = result[s] * node.getQ() / node.getP();
                DFS(next);
            }
        }
    }

    private static long GCD(long x, long y) {
        if (y == 0) return x;
        else return GCD(y, x % y);
    }

    private static void MakeLinkedList(int N) { // linkedList 만들기

        likedList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            likedList[i] = new ArrayList<>();
        }
    }

    private static class Node {
        int destination;
        int p;
        int q;

        public Node(int destination, int p, int q) {
            this.destination = destination;
            this.p = p;
            this.q = q;
        }

        public int getDesti() {
            return destination;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
