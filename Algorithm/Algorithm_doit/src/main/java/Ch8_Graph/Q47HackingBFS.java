package Ch8_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q47HackingBFS {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 신뢰 관계 개수(에지 개수)
        ArrayList<Integer> answer = new ArrayList<>();

        initList(N);
        initResult(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }

        for (int i = 1; i <= N; i++) {
            initVisited(N);
            BFS(i);
        }

        Integer max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }


    }

    public static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            Integer prevNode = queue.poll();
            for (int i: list[prevNode]) {
                if (!visited[i]) {
                    queue.add(i);
                    result[i]++;
                    visited[i] = true;
                }
            }
        }

    }

    public static void initList(int N) {
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public static void initVisited(int N) {
        visited = new boolean[N + 1];
    }
    public static void initResult(int N) {
        result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = 0;
        }
    }
}