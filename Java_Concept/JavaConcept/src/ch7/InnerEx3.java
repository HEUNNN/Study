package ch7;

public class InnerEx3 {
    private int outerlv = 0;
    static int outerCv = 0;
    // 내부 클래스에서 외부 클래스의 멤버 변수들에 대한 접근성을 보여주는 Example
    class InstanceInner {
        int iiv = outerlv; // 외부 클래스의 private 멤버도 접근 가능
        int iiv2 = outerCv;
    }
    static class StaticInner {
        // static 내부 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
        // int siv = outerlv;
        static int scv = outerCv;
    }
    public void myMethod() {
        int lv = 0;
        final int LV = 0;
        class LocalInner {
            int liv = outerlv;
            int liv2 = outerCv;
            // 외부 클래스의 지역변수는 final이 붙은 상수만 접근 가능하다. -> JDK1.8 부터 에러가 아니다.
            int liv3 = lv;
            int liv4 = LV;
        }
    }
}
