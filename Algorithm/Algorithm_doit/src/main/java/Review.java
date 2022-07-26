import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Review {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        count = 0;
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start); // 양방향으로 인접 리스트 채운다.
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
//                DFS(i);
                BFS(i);
                count++;

            }
        }
        System.out.println(count);
    }
    private static void DFS(int startNode) {
        visited[startNode] = true;

        for(int i : list[startNode]) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i);
            }
        }
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int prevNode = queue.poll();
            for(int i : list[prevNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}