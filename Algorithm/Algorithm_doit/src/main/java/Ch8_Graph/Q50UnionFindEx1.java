package Ch8_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q50UnionFindEx1 {
    // 집합 표현하기
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        array = new int[N + 1];
        initArray(N);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (question == 0) {
                union(x, y);
            } else {
                int i1 = find(x);
                int i2 = find(y);
                if (i1 == i2) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }

    }
    private static void initArray(int n) {
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
    }

    private static void union(int a, int b) { // a, b의 대표 노드를 찾아서 연결하기
        int node1 = find(a);
        int node2 = find(b);
        if (node1 != node2) {
            array[node2] = node1; // node2의 대표 노드를 node1으로 설정해준다.
        }

    }

    private static int find(int a) { // 특정 노드의 대표 노드를 찾는다.
        if (array[a] == a) {
            return a;
        } else {
            return array[a] = find(array[a]);
        }
    }
}
