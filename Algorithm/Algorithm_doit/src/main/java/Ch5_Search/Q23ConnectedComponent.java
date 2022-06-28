package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q23ConnectedComponent {
    // 백준 11724
    // 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 문제이다.

    static ArrayList<Integer>[] arr; // 그래프를 인접 리스트로 표현
    static boolean[] visited; // 방문 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int E = Integer.parseInt(st.nextToken()); // 에지 개수

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1]; // 각 index의 원소가 false로 초기화 된다.

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) { // 인접 리스트
            st = new StringTokenizer(br.readLine());
            // 방향이 없는 그래프라서 s, e를 정의한다.
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        int cnt = 0;


        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i); // 여기서 DFS 재귀가 1번 끝나면, i++되고 cnt ++
            }
        }

        System.out.println(cnt);

    }

    private static void DFS(int n) {
        if (visited[n]) { // 재귀를 멈추게 해준다.
            return;
        }

        visited[n] = true;
        System.out.println("탐색 순서:" + n);
        for (Integer integer : arr[n]) {
            if (visited[integer] == false) {
                // 연결 노드 중 방문하지 않았던 노드만 탐색하기
                // visited[integer] == true 이면 다음 for 문
                DFS(integer);
            }
        }
    }
}
