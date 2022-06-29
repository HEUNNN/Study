package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q25DfsEx1 {
    static int N;
    static int M;
    static boolean[] visited;
    static int cnt; // DFS 길이 count
    static ArrayList<Integer>[] linkedList;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 1;
        int result = 0;

        visited = new boolean[N];
        linkedList = new ArrayList[N];

        for (int i = 0; i < N; i++) { // 인접 리스트 초기화
            linkedList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 친구사이는 양쪽
            linkedList[s].add(e);
            linkedList[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                DFS(i, 1);
                if (arrive) break; // arrive가 true라서 DFS에서 return 이 됐으면 해당 if 문 break하고 if(arrive)로 넘어간다.
            }
        }
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    private static void DFS(int n, int depth) {
        if (depth >= 5 || arrive) {
            arrive = true;
            return;
        }
        if (visited[n]) return;
        visited[n] = true;
        for (Integer integer : linkedList[n]) {
            if (!visited[integer]) { // false이면 DFS 부르고, true이면 해당 노드에 연결된 다음 노드를 탐색, 끝까지 탐색 다 하면 위의 for문의 DFS가 끝나게되어 if(arrive)인지 판단하고 break하는 과정이 수행된다.
                DFS(integer, depth + 1);
            }
        }
        visited[n] = false;
    }

}
