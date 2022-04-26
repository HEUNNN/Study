package ch9;

public class StringEx1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");

        System.out.println("str1, str2는 문자열 리터럴로 정의");
        System.out.println("str1 == str2 : " + (str1 == str2));
        System.out.println("str1.equals(str2) : " + str1.equals(str2) );
        System.out.println("str3, str4는 new String으로 인스턴스 생성");
        System.out.println("str3 == str4 : " + (str3 == str4));
        System.out.println("str3.equals(str4) : " + str3.equals(str4) );
        // String class에서 equals는 인스턴스의 주소를 비교하지 않고, 주소에 담겨있는 내용을 비교하도록 Overriding 되어있다.
    }
}
