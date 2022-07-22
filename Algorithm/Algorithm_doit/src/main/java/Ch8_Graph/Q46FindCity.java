package Ch8_Graph;

import java.io.*;
import java.util.*;

public class Q46FindCity {
    static ArrayList<Integer>[] list; // 인접 리스트
    static int[] result; // 출발 노드에서 특정 노드까지 거리 측정 결과
    static ArrayList answerList; // 정답 리스트

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int S = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        list = new ArrayList[N + 1];
        initList(); // 인접 리스트 초기화

        result = new int[N + 1];
        initResult(); // 거리 측정 배열 초기화

        answerList = new ArrayList(); // K 거리만큼 걸리는 노드를 담을 정답 리스트 초기화

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 단방향 도로
            list[start].add(end);
        }

        BFS(S);

        for (int i = 1; i < result.length; i++) {
            if (result[i] == K) {
                answerList.add(i);
            }
        }
        if (answerList.isEmpty()) {
            System.out.println("-1");
            return;
        }

        Collections.sort(answerList);

        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }

    }

    private static void initList() {
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
    }

    private static void initResult() {
        Arrays.fill(result, -1);
    }

    private static void DFS(int startNode, int distance) {

        for (int i = 0; i < list[startNode].size(); i++) {

            int idx = list[startNode].get(i);

            if (result[idx] >= 0) return;

            result[idx] = distance;
            DFS(idx, distance + 1);
        }
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        result[startNode] = result[startNode] + 1;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            for (int i : list[currNode]) {
                if (result[i] == -1) {
                    int dis = result[currNode] + 1;
                    result[i] = dis;
                    queue.add(i);
                }
            }
        }
    }
}