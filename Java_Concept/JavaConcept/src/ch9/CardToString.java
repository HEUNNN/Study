package ch9;

import java.util.Date;

public class CardToString {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        String str1 = new String("apple");
        String str2 = new String("apple");
        System.out.println(str1.toString());
        System.out.println(str2.toString());

        Date d1 = new Date();
        System.out.println(d1.toString());

        Card2 cc1 = new Card2();
        Card2 cc2 = new Card2();
        System.out.println(cc1.toString());
        System.out.println(cc2.toString());
    }
}
class Card {
    String kind;
    int number;
    public Card() {
        this("SPADE", 1);
    }
    public Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }
}
class Card2 {
    String kind;
    int number;
    public Card2() {
        this("SPADE", 1);
    }
    public Card2(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }
    @Override
    public String toString() {
        return "kind: " + kind + ", number: " + number;
    }
}