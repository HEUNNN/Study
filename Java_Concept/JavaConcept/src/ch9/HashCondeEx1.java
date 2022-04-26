package ch9;

public class HashCondeEx1 {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        /*
        * String class에서 hashCode()는 문자열의 내용이 같으면 동일한 해시코드를 반환하도록 오버라이딩 되어있다.
        * System.identityHashCode(Object obj)는 Object 클래스의 hashCode 메서드 처럼 객체의 주소값으로 해시코드를 생성하기 때문에 모든 객체에 대해 항상 다른 해시코드값을 반환한다.
        * */
    }
}
