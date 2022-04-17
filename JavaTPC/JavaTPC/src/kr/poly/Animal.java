package kr.poly;
public abstract class Animal { // 추상클래스(불완전한객체), 추상 클래스는 스스로의 객체는 생성할 수 없음 Animal ani = new Animal(); X
    // Dog, Cat의 공통 부분을 Animal(부모)로 옮김
    public Animal() {
        super();
    }
    public abstract void eat(); // 추상메서드(불완전한메서드) -> 추상클래스 & 추상메서드는 다형성을 일부 보장한다.
    // 기능이 비슷한 클래스들은 하나의 추상 클래스로 묶는것이 좋다. why? 자식 클래스들이 갖는 공통 부분을 구현메서드로도 구현이 가능하기 때문이다.

    // 추상클래스에도 구현부분이 있는 완전한 메서드 정의가 가능하다.
    public void move(){ // 구현메서드, 상속을 받는 자식 클래스가 override 하지 않아도 된다.
        System.out.println("무리를 지어 다닌다.");
    }
}
