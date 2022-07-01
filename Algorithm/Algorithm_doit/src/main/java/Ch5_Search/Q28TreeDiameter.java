package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q28TreeDiameter {
    // 백준 1167
    static int N;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Node>[] linkedList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        linkedList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {

            linkedList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {

                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break;
                int w = Integer.parseInt(st.nextToken());
                linkedList[node].add(new Node(num, w));
            }
        }

        // 완성된 linkedList 출력
/*        for (int i = 1; i <= N; i++) {

            System.out.print(i + ": ");
            for (int j = 0; j < linkedList[i].size(); j++) {
                linkedList[i].get(j).print();
            }
            System.out.println();
        }*/

        // 특정 노드에서 가장 멀리 떨어진 노드 찾기 → 트리 지름을 구성하는 2개의 노드 중 하나가 된다.
        BFS(1); // 노드의 개수가 2개일 수도 있으니 무조건 존재하는 1번 노드를 갖고 max 찾기
        int max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];

        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;


        while (!queue.isEmpty()) {

            int currNode = queue.poll();

            for (Node node : linkedList[currNode]) {

                int num = node.num; // curr 노드에 에지로 연결된 특정 노드의 숫자

                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                    distance[num] = distance[currNode] + node.w; // 가중치 == 길이
                }
            }

        }
    }

    private static class Node {
        int num;
        int w; // 가중치

        public Node(int num, int w) {
            this.num = num;
            this.w = w;
        }

        public void print() {
            System.out.print("(" + num + ", " + w + ") ");
        }
    }
}
