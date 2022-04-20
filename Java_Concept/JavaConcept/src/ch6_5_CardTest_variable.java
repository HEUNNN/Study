import ch6_class.Card;

public class ch6_5_CardTest_variable {
    // 클래스 변수, 인스턴스 변수, 지역변수
    // 클래스 변수와 인스턴스 변수는 클래스 내에 선언되는 변수이고, 클래스 이외의 영역(메서드, 생성자, 초기화 블럭 내부 등..)에서 생성되는 변수는 지역변수이다.
    // 인스턴스 변수: 인스턴스가 생성되어야 생성되는 변수이다. 인스턴스마다 각기 다른 값을 가질 수 있다.
    // 클래스 변수: 인스터스를 생성하지 않아도 바로 사용할 수 있는 변수이다. static 키워드를 사용하며, 클래스명.클래스변수 형태로 사용이 가능하다.
    //           클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로, 항상 공통된 값을 갖는다.
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        c1.setNumber(8); // 인스턴스 변수 -> new로 인스턴스를 생성해야 사용할 수 있다.
        c1.setKind("star");
        // c1 카드의 면적
        int areaC1 = Card.width * Card.height; // class 변수 -> new로 인스턴스를 생성하지 않아도 된다.
        System.out.printf("c1 card's number: %d, c1 card's kind: %s, c1 card's area: %d%n", c1.getNumber(), c1.getKind(), areaC1);

        c2.setNumber(5);
        c2.setKind("circle");
        // c2 카드의 면적
        int areaC2 = Card.width * Card.height;
        System.out.printf("c2 card's number: %d, c2 card's kind: %s, c2 card's area: %d", c2.getNumber(), c2.getKind(), areaC2);

    }
}
