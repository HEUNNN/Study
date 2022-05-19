package ch9;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerEx2 {
    public static void main(String[] args) {
        // String Tokenizer의 구분자는 단 한 문자의 구분자만 사용할 수 있다.
        // 예를 들어 구분자라 "+-*/=()"일 때 전체가 하나의 구분자가 아니라 각각의 문자가 모두 구분자이다.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), "+-*/=()", true); // true는 구분자도 토큰으로 간주하겠다는 의미이다.
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
