package ch12;

enum Transportaion {
    BUS(100) { int fare(int distance) { return distance * BASIC_FARE;}},
    TRAIN(150) { int fare(int distance) { return distance * BASIC_FARE;}},
    SHIP(100) { int fare(int distance) { return distance * BASIC_FARE;}},
    AIRPLANE(300) { int fare(int distance) { return distance * BASIC_FARE;}};

    protected final int BASIC_FARE; // 원래는 private인데, 각 상수(BUS, TRAIN..)에서 접근하기 위해 Protected로 선언
    Transportaion(int basicFare) {
        BASIC_FARE = basicFare;
    }

    public int getBasicFare() { return BASIC_FARE; }
    abstract int fare(int distance); // 거리에 따른 요금 계산 -> 각 열거형 상수가 이 추상 메서드를 반드시 구현해야 한다.
}

public class EnumEx3 {
    public static void main(String[] args) {
        System.out.println("bus fare: " + Transportaion.BUS.fare(100) + "( bus's basic fare: " + Transportaion.BUS.getBasicFare() + " )");
        System.out.println("train fare: " + Transportaion.TRAIN.fare(100) + "( train's basic fare: " + Transportaion.TRAIN.getBasicFare() + " )");
        System.out.println("ship fare: " + Transportaion.SHIP.fare(100) + "( ship's basic fare: " + Transportaion.SHIP.getBasicFare() + " )");
        System.out.println("airplane fare: " + Transportaion.AIRPLANE.fare(100) + "( airplane's basic fare: " + Transportaion.AIRPLANE.getBasicFare() + " )");
        System.out.println();
    }
}
