package ch8;

public class ExceptionEx1 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;
        for (int i = 0; i < 10; i++) {
            try {
                result = number / (int)(Math.random() * 10);
                System.out.println(result);
            } catch (ArithmeticException e) { // ArithmeticException 은 산술연산과정에서 오류가 있을 때 발생하는 예외이다.
                System.out.println("0");
            }// try-catch의 끝
        } // for 문의 끝

    }
}
