package ch7;

public class InnerEx2 {
    class InstanceInner {}
    static class StaticInner {}
    void myMethod() {
        class LocalInner {}
        LocalInner lv = new LocalInner();
    }

    static void staticMethod() {
        // static 멤버는 인스턴스 멤버에 직접 접근할 수 없다.
        // InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        // 굳이 InstanceInner 메서드에 접근하고자 한다면, InnerEx2 객체를 생성해야한다.
        InnerEx2 outer = new InnerEx2();
        InstanceInner obj1 = outer.new InstanceInner();
    }
    void instanceMethod() {
        // 인스턴스메서드에서는 인스턴스 멤버와 static 멤버 모두 접근이 가능
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();
        // 메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근할 수 없다.
        // LocalInner lv = new LocalInner();
    }
}
