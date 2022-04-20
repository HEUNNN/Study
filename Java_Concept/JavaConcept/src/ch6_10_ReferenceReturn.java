public class ch6_10_ReferenceReturn {
    // 참조형 반환 타입
    public static void main(String[] args) {
        Data d = new Data(); // ch6_7 부분에서 생성한 Data class
        d.x = 10;

        Data d2 = copy(d);
        System.out.println("d.x = " + d.x);
        System.out.println("d2.x = " + d2.x);

        d.x = 100;
        System.out.println("change d.x = " + d.x); // 100
        System.out.println("change d.x 일 때 d2.x = " + d2.x); // 10

        // 인스턴스(객체)를 복사 ->  원본 인스턴스의 주소를 참조하게 된다. (진정 복사되는 것이 아님)
        Data d3 = copyInstance(d);
        System.out.println("원본 인스턴스 d.x = " + d.x); // 100
        System.out.println("원본 인스턴스의 주소를 참조하고 있는 d3.x = " + d3.x);
        //원본 인스턴스값 변경시 원본 인스턴스를 참조하는 인스턴스의 변화
        d.x = 2;
        System.out.println("원본 인스턴스 d.x 변경 = " + d.x); // 2
        System.out.println("원본 인스턴스 변화에 따른 d3.x = " + d3.x); // 2
        // 원본 인스턴스와 참조한 인스턴스의 주소 비교
        System.out.println("원본 인스턴스 주소: " + d);
        System.out.println("원본 인스턴스를 참조한 인스턴스의 주소: " + d3);
    }
    static Data copy(Data d) { // 새로운 객체를 생성한 다음, 매개변수로 넘겨받은 객체에 저장된 값을 복사해서 반환한다.
        Data tmp = new Data(); // tmp에 Data type의 인스턴스 저장 공간 주소를 대입한다.
        tmp.x = d.x;
        return tmp; // 반환하는 값이 Data 객체의 주소이므로 반환 타입이 Data이다.
    }
    static Data copyInstance(Data d) {
        Data copy = new Data();
        copy = d;
        return copy;
    }
}
