import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Review {

    static boolean[] visited; // 방문 배열
    static ArrayList<Integer>[] adjList; // 인접 리스트
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {


        int N = 6;
        adjList = new ArrayList[N + 1]; // 인접 리스트
        initAdjList();
        visited = new boolean[N + 1];
        queue = new LinkedList<>();

        adjList[1].add(2);
        adjList[1].add(3);
        adjList[2].add(5);

        adjList[3].add(4);
        adjList[4].add(6);
        adjList[5].add(6);

//        BFS(1);
        DFS(1);

    }

    private static void initAdjList() {
        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    private static void BFS(int s) {

        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int linked : adjList[curr]) {
                if (!visited[linked]) {
                    queue.add(linked);
                    visited[linked] = true;
                }
            }
        }
    }

    private static void DFS(int start) throws IOException {
        if (visited[start]) return; // 시작점

        visited[start] = true;
        System.out.print(start + " ");

        for (int i : adjList[start]) { // 시작점에 연관되어 있는 노드들 ⭐️
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
