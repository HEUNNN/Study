package ch9;

public class EqualsEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);
        if (v1.equals(v2)) {
            System.out.println("v1과 v2는 같습니다.");
        } else {
            System.out.println("v1과 v2는 다릅니다.");
        }
        v2 = v1; // v1 인스턴스의 주소를 v2 참조변수에 복사
        if (v1.equals(v2)) { // 인스턴스간의 메모리 주소를 비교한다. 실제 인스턴스 내부의 내용을 비교하는 것이 아니다.
            System.out.println("v1과 v2는 같습니다.");
        } else {
            System.out.println("v1과 v2는 다릅니다.");
        }
    }
}
class Value {
    int value;
    Value(int value) {
        this.value = value;
    }
}
