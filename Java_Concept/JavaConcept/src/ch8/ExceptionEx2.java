package ch8;

public class ExceptionEx2 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(4);
        } catch(Exception e) {
            System.out.println(5); // try 내부에서 예외가 발생하지 않았으므로 catch 블럭의 문장이 실행되지 않음
        }
        System.out.println(6);
    }
}
