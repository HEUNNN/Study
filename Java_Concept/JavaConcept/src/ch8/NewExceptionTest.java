package ch8;
import java.lang. *;

public class NewExceptionTest {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException se) {
            System.out.println("에러 메시지: " + se.getMessage());
            se.printStackTrace();
            System.out.println("공간을 확보한 후에 다시 설치해주세요.");
        } catch (MemoryException me) {
            System.out.println("에러 메시지: " + me.getMessage());
            me.printStackTrace();
            System.gc(); // Garbage Collection을 수행하여 메모리를 늘려준다.
            System.out.println("다시 설치해주세요.");
        } finally {
            deleteTempFiles(); // 프로그램 설치에 사용된 임시파일들을 모두 삭제한다.
        }
    }
    public static void startInstall() throws SpaceException, MemoryException { // SpaceException, MemoryException은 사용자 정의 예외
        if(!enoughSpace()) {
            throw new SpaceException("설치할 공간이 부족합니다.");
        }
        if(!enoughMemory()) {
            throw new MemoryException("설치할 메모리 공간이 부족합니다.");
        }
    }
    public static void copyFiles() { /* 파일들을 복사하는 코드 */ };
    public static void deleteTempFiles() { /* 임시파일들을 삭제하는 코드 */}
    public static boolean enoughSpace() {
        // 설치하는데 필요한 공간이 있는지 확인하는 코드
        return false;
    }
    public static boolean enoughMemory() {
        // 설치하는데 필요한 메모리 공간이 있는지 확인하는 코드
        return true;
    }
}
class SpaceException extends Exception {
    public SpaceException(String msg) {
        super(msg);
    }
}
class MemoryException extends Exception {
    public MemoryException(String msg) {
        super(msg);
    }
}
