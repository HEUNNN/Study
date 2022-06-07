package Ch3_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5SumOfRemainder {
    // 백준 10986
    // 나머지 합 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = converInt(st.nextToken());
        int M = converInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sNum = new int[N + 1]; // 합 배열
        long[] cntArr = new long[M];
        long result = 0;

        for (int i = 1; i <= N; i++) {
            sNum[i] = (sNum[i - 1] + converInt(st.nextToken())) % M; // 합 배열
            cntArr[sNum[i]] ++;
        }

        for (int i = 0; i < M; i++) {
            if(cntArr[i] != 0) {
                result += combi(cntArr[i]);
            }
        }
        result += cntArr[0];
        System.out.println(result);

    }

    public static int converInt(String str) {
        return Integer.parseInt(str);
    }

    public static long combi(long n) { // nC2 = (n * (n-1)) / 2
        return (n * (n - 1)) / 2;
    }
}
