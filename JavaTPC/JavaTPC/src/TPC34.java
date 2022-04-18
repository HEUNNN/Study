public class TPC34 {
    public static void main(String[] args) {
        // java.lang의 String class 사용해보기
        String str = new String("apple");
        System.out.println(str);
        System.out.println(str.toUpperCase());
        System.out.println(str.charAt(3));
        System.out.println(str.indexOf("pl")); // "pl"이 있는 start position
        System.out.println(str.replaceAll("p", "P"));
        String s = "banana";
        System.out.println(s);
        System.out.println(s.toUpperCase());
    }
}
