package ch8;

public class ExceptionEx7 {
    public static void main(String[] args) {
        try {
            Exception e = new Exception("고의로 발생시킨 예외사항");
            throw e; // 예외를 발생시킴
        } catch (Exception e) {
            System.out.println("에러메시지: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료");
    }
}
