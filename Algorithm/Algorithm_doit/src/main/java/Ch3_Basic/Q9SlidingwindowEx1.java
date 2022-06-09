package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9SlidingwindowEx1 {
    // 백준 12891
    // 슬라이딩 윈도우 알고리즘: 2개의 포인터로 범위를 지정한 다음 범위를 유지한채로 이동하며 문제를 해결합니다.

    static int[] conditionArr = new int[4]; // A, C, G, T 최소 개수 조건 배열
    static int[] currConditionArr = new int[4]; // 윈도우 범위 내의 비밀번호 A, C, G, T 개수 배열
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // DNA 문자열의 길이
        int M = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이

        int result = 0;

        char[] dnaArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            conditionArr[i] = Integer.parseInt(st.nextToken());
            if (conditionArr[i] == 0) cnt++; // 이게 없어서 결과가 계속 0으로 나왔다. 이 코드가 없으면 0개만 있어도 되는 조건을 빼먹게 된다.
        }

        for (int i = 0; i < M; i++) {
            Add(dnaArr[i]);
        }
        if (cnt >= 4) result++;


        for (int i = M; i < N; i++) {
            int end = i - M;
            Add(dnaArr[i]);
            Minus(dnaArr[end]);
            if (cnt >= 4) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static void Add(char c) {
        switch (c) {
            case 'A':
                currConditionArr[0]++;
                if (currConditionArr[0] == conditionArr[0]) cnt++;
                break;
            case 'C':
                currConditionArr[1]++;
                if (currConditionArr[1] == conditionArr[1]) cnt++;
                break;
            case 'G':
                currConditionArr[2]++;
                if (currConditionArr[2] == conditionArr[2]) cnt++;
                break;
            case 'T':
                currConditionArr[3]++;
                if (currConditionArr[3] == conditionArr[3]) cnt++;
                break;
        }
    }

    public static void Minus(char c) {
        switch (c) {
            case 'A':
                if (currConditionArr[0] == conditionArr[0]) cnt--;
                currConditionArr[0]--;
                break;
            case 'C':
                if (currConditionArr[1] == conditionArr[1]) cnt--;
                currConditionArr[1]--;
                break;
            case 'G':
                if (currConditionArr[2] == conditionArr[2]) cnt--;
                currConditionArr[2]--;
                break;
            case 'T':
                if (currConditionArr[3] == conditionArr[3]) cnt--;
                currConditionArr[3]--;
                break;
        }
    }
}
