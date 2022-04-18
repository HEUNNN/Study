public class TPC35 {
    public static void main(String[] args) {
        // new Keyword로 String 객체 생성 -> Heap Area에 String 객체가 생성
        String str1 = new String("apple");
        String str2 = new String("apple");
        System.out.println("str1: " + str1 + ", str2: " + str2);
        System.out.println(str1 == str2); // false , '=='으로 비교하면 번지를 비교하여 false가 출력
        System.out.println(str1.equals(str2)); // true, equals()는 번지수에 담겨있는 value를 비교하기 때문에 true가 출력

        // Literal Keyword로 생성 -> Literal Pool 에 String 객체가 생성됨, 재활용 가능
        String str3 = "apple";
        String str4 = "apple";
        System.out.println("str3: " + str3 + ",str4: " + str4);
        System.out.println(str3 == str4); // true
        System.out.println(str3.equals(str4)); // true

        System.out.println(str1.equals(str4)); // true
    }
}
