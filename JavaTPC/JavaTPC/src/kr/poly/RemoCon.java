package kr.poly;

public interface RemoCon { // 기능이 없는 정의용 클래스이다. 인터페이스도 자체로 객체를 생성할 수 없다. RemoCon re = new RemoCon(); X
    // 인터페이스 클래스에는 "상수"를 정의할 수 있다.
    public static final int MAXCH = 100; // public static final 이 생략된다.
    int MINCH = 1; // RemoCon.MINCH 로 접근이 가능 -> static이기 때문
    // 인터페이스는 객체를 생성할 수 없기 때문에, 객체를 생성하지 않고도 접근할 수 있도록 static을 사용한다.
    // 한번 할당한 값을 변경하면 안되기 때문에 final 사용한다. (변수는 값을 변경할 수 있지만, 상수는 값을 변경하면 안된다.)

    // 추상메서드
    public abstract void chUp();
    public void chDown(); // abstract는 생략된다.
    public void internet();
    // 자식 클래스에서 implement해주면 부모 클래스가 된다.
}
