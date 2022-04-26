package ch9;

public class ClassEx1 {
    public static void main(String[] args) {
        Card3 c = new Card3("HEART", 3); // new 연산자로 객체 생성
//        try {
//            Card3 c2 = Card3.class.newInstance(); // Class 객체를 통해서 객체 생성 , newInstance()는 폐지됨
//        } catch (IllegalAccessException e ) {
//
//        } catch (InstantiationException e2) {
        Class cObj = c.getClass();
        System.out.println(c);
        System.out.println(cObj.getName());
        System.out.println(cObj.toGenericString());
        System.out.println(cObj.toString());


    }
}
final class Card3 {
    String kind;
    int num;

    public Card3() {
        this("SPADE", 1);
    }
    public Card3(String kind, int num) {
        this.kind = kind;
        this.num = num;
    }
    public String toString() {
        return kind + " : " + num;
    }
}
