package Ch2_Basic;

import java.util.Scanner;

public class sumOfNumber {
    // 백준 11720
    // 숫자의 합 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int result = 0;
        for (char elem : arr) {
            result += (elem - '0');
        }
        System.out.println(result);
//
//        String sNum = "123"; // parseInt는 String인 숫자열을 정수형으로 변환할 때 사용한다.
//        System.out.println("String 123을 int로 변환 후 + 10: " + (Integer.parseInt(sNum) + 10)); // 133
//        System.out.println("String 123을 int로 변환하지 않고 + 10: " + (sNum + 10)); // 12310
//
//        char c = '1';
//        int charToInt = c - '0'; // '0' 숫자 문자의 아스키 코드는 숫자가 1씩 증가할때마다 아스키코드 숫자도 1씩 증가한다. 그래서 '0'의 아스키 코드를 빼주면 숫자 문자열에 해당하는 것의 int형이 반환된다.
//        System.out.println("char 1을 int로 변환 후 + 10: " + (charToInt + 10)); // 11
//        System.out.println("char 1을 int로 변환하지 않고 + 10: " + (c + 10)); // '1'에 대한 아스키 코드 값은 49이다. 그래서 49 + 10인 59가 나왔다.
    }

    /*
     * String -> int (String은 문자열)
     * Integer.parseInt("123")
     * Char ->  int (Char은 문자 1개)
     * 특정 문자에서 '0'을 빼준다.(아스키 코드를 활용한 것이다.)
     * */
}
