package ch8;

public class FinallyTest1 {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            deleteTempFiles(); // 프로그램 설치에 사용된 임시파일들을 예외에 상관없이 무조건 삭제하기 위해 finally 사용
        }
    }
    static void startInstall() {
        /* 프로그램 설치에 필요한 준비를 하는 코드를 적는다. */
    }
    static void copyFiles() {
        /* 파일들을 복사하는 코드를 적는다. */
    }
    static void deleteTempFiles() {
        /* 임시파일들을 삭제하는 코드를 적는다. */
    }
}
