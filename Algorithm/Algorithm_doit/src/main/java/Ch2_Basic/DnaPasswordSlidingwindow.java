package Ch2_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DnaPasswordSlidingwindow {
    // 백준 12891
    // 슬라이딩 윈도우 알고리즘: 2개의 포인터로 범위를 지정한 다음 범위를 유지한채로 이동하며 문제를 해결합니다.
    static int[] currArr = new int[4]; // A, C, G, T가 현재 P개의 원소 중 몇개가 있는지 나타내는 배열
    static int[] checkArr = new int[4];
    static int cnt = 0; // A, C, G, T 최소 만족 조건을 현재 몇개를 충족했는지 나타냄, cnt가 4가 되면 조건이 모두 만족되었다는 의미이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] strArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) cnt++;
        }

        int result = 0; // A, C, G, T 조건을 만족하는 부분 배열의 개수
        for (int i = 0; i < P; i++) { // 초기 부분 배열 만들기
            Add(strArr[i]);
        }
        if (cnt == 4) result++;

        for (int addIdx = P; addIdx < N; addIdx++) {
            int removeIdx = addIdx - P;
            Remove(strArr[removeIdx]);
            Add(strArr[addIdx]);
            if (cnt == 4) result++;
        }
        System.out.println(result);
    }

    public static void Add(char c) {
        switch (c) {
            case 'A':
                currArr[0]++;
                if (currArr[0] == checkArr[0]) cnt++;
                break;
            case 'C':
                currArr[1]++;
                if (currArr[1] == checkArr[1]) cnt++;
                break;
            case 'G':
                currArr[2]++;
                if (currArr[2] == checkArr[2]) cnt++;
                break;
            case 'T':
                currArr[3]++;
                if (currArr[3] == checkArr[3]) cnt++;
                break;
        }
    }

    public static void Remove(char c) {
        switch (c) {
            case 'A':
                if (currArr[0] == checkArr[0]) cnt--;
                currArr[0]--;
                break;
            case 'C':
                if (currArr[1] == checkArr[1]) cnt--;
                currArr[1]--;
                break;
            case 'G':
                if (currArr[2] == checkArr[2]) cnt--;
                currArr[2]--;
                break;
            case 'T':
                if (currArr[3] == checkArr[3]) cnt--;
                currArr[3]--;
                break;
        }
    }
}
