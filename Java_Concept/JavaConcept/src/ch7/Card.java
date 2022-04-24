package ch7;

public class Card {
    public final int NUMBER; // 상수지만 선언과 함께 초기화 하지 않고, 생성자에서 단 한번만 초기화 할 수 있다.
    public final String KIND;
    public static int width = 100;
    public static int height = 250;

    public Card(int num, String kind){
        this.NUMBER = num;
        this.KIND = kind;
    }
    public Card() {
        this(1, "HEART");
    }
    public String toString() {
        return KIND + " " + NUMBER;
    }
}

class FinalCardTest {
    public static void main(String[] args) {
        Card c = new Card(3, "TRIANGLE");
        System.out.printf("c.KIND: %s, c.NUMBER: %d, c.toString(): %s%n",c.KIND, c.NUMBER, c.toString());
        Card c2 = new Card();
        System.out.printf("c2.KIND: %s, c2.NUMBER: %d, c2.toString(): %s%n",c2.KIND, c2.NUMBER, c2.toString());

    }   
}
