package Ch2_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DnaPasswordSlidingwindow {
    // 백준 12891
    // 슬라이딩 윈도우 알고리즘: 2개의 포인터로 범위를 지정한 다음 범위를 유지한채로 이동하며 문제를 해결합니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // DNA 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분 문자열의 길이

        st = new StringTokenizer(br.readLine());
        char[] charArr = st.nextToken().toCharArray();

        // [A, C, G, T] 최소 개수 배열 -> checkArr
        st = new StringTokenizer(br.readLine());
        int[] checkArr = new int[4];
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        
    }
}
