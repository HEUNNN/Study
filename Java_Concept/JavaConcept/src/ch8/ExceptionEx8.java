package ch8;

public class ExceptionEx8 {
    // method 예외처리 -> throws
    public static void main(String[] args) throws Exception {
        try {
            method1(); // 같은 클래스내의 static 멤버이므로 객체생성 없이 직접 호출 가능
        }catch (Exception e) {
            // method1(), method2(), main 중 어느 한곳에서라도 try-catch로 예외처리를 헤주어야 한다.
            System.out.println("Exception 발생");
        }
    }
    static void method1() throws Exception {
        method2();
    }
    static void method2() throws Exception {
        throw new Exception(); //예외를 강제로 발생시킴
    }
}
