package ch8;

public class ExceptionEx4 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        } catch(Exception e) {
            System.out.println("정수 0 으로 나눌 수 없습니다.");
            // Eception은 모든 예외 클래스의 root 조상이므로, Exception 클래스 타입의 참조변수를 선언해 놓으면 어떤 종류의 예외가 발생하더라도 catch로 예외처리가 가능하다.
        }
        System.out.println(5);
    }
}
