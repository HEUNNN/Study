package ch9;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {
    public static void main(String[] args) {
        String source = "100,200,300,400";
        StringTokenizer st = new StringTokenizer(source,","); // 구분자를 정규표현식 형태로 넣어주지 않아도 된다.

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
