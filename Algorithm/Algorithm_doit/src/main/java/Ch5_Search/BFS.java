package Ch5_Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static boolean[] visited;
    static ArrayList<Integer>[] linkedList;

    public static void main(String[] args) {
        int N = 6;
        visited = new boolean[N + 1];
        linkedList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) { // 인접 리스트 초기화
            linkedList[i] = new ArrayList<>();
        }

        int[][] arr = {{1, 2}, {1, 3}, {2, 5}, {2, 6}, {3, 4}, {4, 6}};
        makeLinkedList(arr);
        BFS(1);

    }

    private static void makeLinkedList(int[][] arr) { // linkedList 완성하기
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            int s = arr[i][0];
            int e = arr[i][1];
            // 한 방향
            linkedList[s].add(e);
        }
    }

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();

        // 시작 node
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) { // q가 empty가 되면 while문 중단
            int nextNode = q.poll(); // while문 끝나게 되는거 아닌가? No, 다음 회차 반복문 돌릴때 q가 비었는지만 판단한다.
            System.out.print(nextNode + " ");

            for (Integer integer : linkedList[nextNode]) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    q.add(integer);
                }
            }


        }

    }
}
