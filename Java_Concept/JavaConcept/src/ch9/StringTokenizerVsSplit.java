package ch9;

import java.util.StringTokenizer;

public class StringTokenizerVsSplit {
    // StringTokenizer와 Split의 차이 -> split은 빈 문자열도 토큰으로 인식하는 반면, StringTokenizer는 빈 문자열을 토큰으로 인식하지 않는다.
    public static void main(String[] args) {
        String data = "100,,,200,300";

        String[] result = data.split(",");
        StringTokenizer st = new StringTokenizer(data, ",");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + "|");
        }

        System.out.println("split으로 자른 result의 개수: " + result.length);

        int count = 0;
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken() + "|");
            count ++;
        }
        System.out.println("StringTokenizer로 자른 result의 개수: " + count);
    }
}
