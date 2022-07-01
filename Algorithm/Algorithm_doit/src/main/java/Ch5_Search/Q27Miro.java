package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q27Miro {
    // 백준 2178
    static boolean[][] visited;
    static int[][] arr;

    // 우하좌상 순으로 BFS
    static int[] dx = {0, 1, 0, -1}; // column
    static int[] dy = {1, 0, -1, 0}; // row
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // N X M 이중 배열
        visited = new boolean[N][M];
        arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }


        BFS(0, 0);

//        System.out.println(arr[N-1][M-1]);

        for (int i = 0; i < N; i++) { // col
            for (int j = 0; j < M; j++) { // row
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void BFS(int i, int j) {

        Queue<int[]> queue = new LinkedList<>(); // (i,j)가 담긴다.
        visited[i][j] = true;
        queue.add(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) { // 좌표 유효성 검사
                    // 갈 수 있는 칸인지 확인
                    if (arr[x][y] != 0 && !visited[x][y]) {
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                        arr[x][y] = arr[now[0]][now[1]] + 1;
                    }
                }

            }

        }

    }
}
