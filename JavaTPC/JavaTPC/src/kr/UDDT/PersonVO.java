package kr.UDDT;

public class PersonVO {  // Person class 설계 -> 객체를 생성해야 실제 메모리에 객체(인스턴스)가 만들어진다.
    public String name; // 상태정보 = 속성 = 멤버변수
    public  int age;
    public float weight;
    public float height;
    // 배열은 아니다. 배열은 기억 공간의 데이터가 동일한 자료형이여야 하지만, 위 PersonVO는 각 데이터마다 자료형이 다르다.
    // 배열로 PersonVO 를 구현하기에는 어려움이 있다. 따라서 class로 직접 설계해서 사용한다.
}
