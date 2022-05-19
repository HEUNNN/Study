package Ch2_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfIntervalsWithBuffer {
    // Scanner 보다 속도가 빠른 Buffer Reader 사용하여 구간 합 구하기
    /*
     * 문제
     * 첫 번째 줄에 수의 개수 N, 질의 횟수 M이 주어진다.
     * 두 번째 줄에 N개의 수가 주어진다.
     * 세 번째 줄에 M개의 질의 구성인 구간 i, j 가 주어진다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader의 redLine()을 사용하면 line 단위로 입력을 받아 String 타입으로 반환
        // StringTokenizer는 긴 문자열을 지정된 구분자를 기준으로 토큰이라는 여러 개의 문자열로 잘라내는 데 사용된다.(split은 구분자로 정규표현식을 넣어줘야한다.)
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1]; // 구간 합을 구할 때는 index를 1부터 시작하도록 하게 하기 위해서
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine()); // " " default
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(arr[j] - arr[i-1]);
        }


    }

}
