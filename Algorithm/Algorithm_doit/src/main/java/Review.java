import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Review {
    static ArrayList<Integer>[] list;
    static int[] distanceInfo;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 찾아야 하는 거리 정보
        int S = Integer.parseInt(st.nextToken()); // 출발 도시 번호


        initList(N);
        initDistanceInfo(N);
        result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }

        BFS(S);

        for (int i = 0; i < distanceInfo.length; i++) {
            if (distanceInfo[i] == K) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println("-1");
            return;
        }
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    public static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        distanceInfo[startNode] = 0;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int i : list[currNode]) {
                if (distanceInfo[i] == -1) {
                    queue.add(i);
                    distanceInfo[i] = distanceInfo[currNode] + 1;
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

    public static void initDistanceInfo(int N) {
        distanceInfo = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            distanceInfo[i] = -1;
        }
    }
}