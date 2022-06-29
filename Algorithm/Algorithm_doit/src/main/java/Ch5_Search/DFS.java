package Ch5_Search;

import java.util.ArrayList;

public class DFS {
    static ArrayList<Integer>[] linkedList;
    static boolean[] visited;

    public static void main(String[] args) {
        // 인접 리스트(그래프) 만들기
        int N = 6;
        MakeLikedList(N);
        addEdge(1, 2);
        addEdge(2, 5);
        addEdge(5, 1);
        addEdge(3, 4);
        addEdge(4, 6);
        // 방문 배열
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                System.out.println();
            }
        }

    }

    private static void DFS(int n) {
        if (visited[n]) return;

        visited[n] = true;
        System.out.print(n + " ");

        for (Integer integer : linkedList[n]) {
            if (visited[integer] == false) {
                DFS(integer);
            }

        }
    }

    private static void MakeLikedList(int n) {
        linkedList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            linkedList[i] = new ArrayList<>();
        }
    }

    private static void addEdge(int start, int destination) {
        linkedList[start].add(destination);
    }

}
