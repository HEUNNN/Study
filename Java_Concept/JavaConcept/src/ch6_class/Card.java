package ch6_class;

public class Card {
    private String kind;
    private int number;
    public static int width = 100;
    public static int height = 250;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if(number < 0 || number > 10) return;
        this.number = number;
    }
}
