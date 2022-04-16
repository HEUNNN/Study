package kr.UDDT;

public class Dog extends Animal {
    // 이름, 나이, 종: 객체의 상태 정보
    // 상속은 행위 정보 측면에서 바라봐야한다.
    // Dog는 Animal 클래스를 상속받기 때문에 Animal에서 정의한 메서드를 본인의 것처럼 사용할 수 있다.
    public Dog() {
        super();
    }
    @Override
    public void eat() {
        System.out.println("강아지처럼 먹다."); // Animal class의 eat()을 override
    }
}
