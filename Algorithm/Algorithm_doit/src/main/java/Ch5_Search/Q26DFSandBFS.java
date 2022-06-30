package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q26DFSandBFS {
    // 백준 1260

    static boolean[] visited;
    static ArrayList<Integer>[] linkedList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // node 개수
        int E = Integer.parseInt(st.nextToken()); // edge 개수
        int startNode = Integer.parseInt(st.nextToken());

        linkedList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            linkedList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            linkedList[s].add(e);
            linkedList[e].add(s);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(linkedList[i]); // 번호가 작은 것을 먼저 방문하기 위해 정렬
        }


        visited = new boolean[N + 1]; // 방문 배열 초기화
        DFS(startNode);
        System.out.println();

        visited = new boolean[N + 1];
        BFS(startNode);
        System.out.println();


    }

    private static void DFS(int node) {

        if (visited[node]) {
            return;
        }

        visited[node] = true;
        System.out.print(node + " "); // 탐색과정 출력

        for (Integer integer : linkedList[node]) {
            if (!visited[integer]) {
                DFS(integer);
            }
        }
    }

    private static void BFS(int node) {

        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);


        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.print(currNode + " ");

            for (Integer integer : linkedList[currNode]) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.add(integer);
                }
            }
        }

    }
}
