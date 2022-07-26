package Ch8_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q48BipartiteGraph {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] setCheck;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // Test case 개수

        for (int i = 0; i < T; i++) {
            String[] strings = br.readLine().split(" ");
            int N = Integer.parseInt(strings[0]); // Node 개수
            int E = Integer.parseInt(strings[1]); // Edge 개수

            flag = true;

            visited = new boolean[N + 1];
            setCheck = new int[N + 1]; // 각 노드가 어느 집합인지 표시할 배열

            list = new ArrayList[N + 1];

            for (int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) { // 인접 리스트로 그래프 표현하기
                strings = br.readLine().split(" ");
                int start = Integer.parseInt(strings[0]);
                int end = Integer.parseInt(strings[1]);
                list[start].add(end);
                list[end].add(start); // 왜 양쪽 ? ⭐️
            }

            for (int j = 1; j <= N; j++) { // 주어진 그래프가 1개로 연결되어 있다는 보장이 없기 때문에 모든 노드에 DFS 탐색을 해봐야한다.
                if (flag) { // flag가 true일 때
//                    DFS(j);
                    BFS(j);
                } else {
                    break;
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

    private static void DFS(int startNode) {

        visited[startNode] = true;

        for (int a : list[startNode]) {
            if (!visited[a]) {
                setCheck[a] = (setCheck[startNode] + 1) % 2;
                DFS(a);
            } else if (setCheck[startNode] == setCheck[a]) {
                // visited[a] == true && setCheck[startNode] == setCheck[a]
                flag = false;
            }
        }

    }

    private static void BFS(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int prevNode = q.poll();
            for (int i : list[prevNode]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    setCheck[i] = (setCheck[prevNode] + 1) % 2;
                } else if (setCheck[i] == setCheck[prevNode]) {
                    flag = false;
                }

            }

        }
    }

}
