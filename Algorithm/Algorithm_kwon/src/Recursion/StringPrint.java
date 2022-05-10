package Recursion;

public class StringPrint {
    // 하나의 문자열을 화면에 출력하는 메서드
    public static void main(String[] args) {
        String str = "apple";
        print(str);
    }
    public static void print(String str) {
        if (str.equals("")) { // str.length() == 0도 가능
            return;
        }
        System.out.print(str.charAt(0) + " ");
        print(str.substring(1));
    }
}
