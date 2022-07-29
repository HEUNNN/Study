package Ch8_Graph;

import java.io.*;
import java.util.StringTokenizer;

public class Q51UnionFindEx2 {
    static int[] nodeArr; // 대표 노드 표시할 배열

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수

        nodeArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeArr[i] = i; // 각 노드의 대표 배열을 메모할 배열을 일단 초기화
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    union(i, j);
                }
            }
        }
        // 여행할 경로 → 대표 노드를 찾을 때는 find 메서드 항상 사용하기
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (start != find(tmp)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    private static void union(int a, int b) {
        int node1 = find(a); // a의 대표 노드
        int node2 = find(b); // b의 대표 노드

        if (node1 > node2) {
            nodeArr[node2] = node1;
        } else if (node1 < node2) {
            nodeArr[node1] = node2;
        }
    }

    private static int find(int a) { // 대표 노드 찾기
        if (nodeArr[a] == a) return a;
        else {
            return nodeArr[a] = find(nodeArr[a]);
        }
    }

}
