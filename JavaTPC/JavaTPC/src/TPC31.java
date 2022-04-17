import kr.TPC.A;
import kr.TPC.B;

public class TPC31 {
    public static void main(String[] args) {
        Object objA = new A();
        Object objB = new B();

        //Object의 toString은 override 되지 않아서 주소(번지)값이 String으로 반환된다.
        System.out.println(objA.toString());
        System.out.println(objB.toString());

        //objA, objB는 Object class에 없기 때문에 downcasting 해줘서 사용한다.
        ((A)objA).Go();
        ((B)objB).Go();

        // 다형성 인수
        display(new A());
        display(new B());

//        // display method에 static을 없애고 사용하는 방법
//        TPC31 tpc = new TPC31(); // class를 객체로 생성, 즉 인스턴스로 만든다.
//        tpc.display(new A());
//        tpc.display(new B());

    }
    public static void display(Object o) {
        if(o instanceof A){
            ((A)o).Go();
        }else {
            ((B)o).Go();
        }
    }
}
