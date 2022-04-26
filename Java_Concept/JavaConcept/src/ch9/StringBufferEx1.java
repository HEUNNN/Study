package ch9;

public class StringBufferEx1 {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println("sb1 == sb2 ? " + (sb1 == sb2));
        System.out.println("sb1.equals(sb2) ? " + sb1.equals(sb2));

        // StringBuffer의 내용을 String으로 변경
        String s1 = sb1.toString(); // StringBuffer는 String 클래스와 다르게 toString()이 overriding 되어 있다.
        String s2 = sb2.toString(); // StringBuffer에서 toString()은 담고있는 문자열을 String 타입으로 반환한다.
        System.out.println("s1 == s2 ? " + (s1 == s2));
        System.out.println("s1.equals(s2) ? " + s1.equals(s2));
    }
}
