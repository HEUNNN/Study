package ch8;

public class ChainedExceptionEx {
    public static void main(String[] args) {
        try {
            install();
        } catch (InstallException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void install() throws InstallException {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException se) {
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(se); // 원인 예외로 설정
            throw ie;
        } catch (MemoryException me) {
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(me);
            throw ie;
        } finally {
            deleteTempFiles();
        }
    }
    public static void startInstall() throws SpaceException, MemoryException { // startInstall()의 예외처리는 startInstall()을 호출한 install()에서 try-catch로 예외처리를 해준다.
        if (!enoughSpace()) {
            throw new SpaceException("설치할 공간이 부족합니다.");
        }
        if (!enoughMemory()) {
            throw new RuntimeException(new MemoryException("메모리가 부족합니다."));
        }
    }
    public static void copyFiles() {
        /* 파일들을 복사하는 코드를 작성 */
    }
    public static void deleteTempFiles() {
        /* 임시 파일들을 삭제하는 코드 작성 */
    }
    public static boolean enoughSpace() {
        return false;
    }
    public static boolean enoughMemory() {
        return true;
    }
}
class InstallException extends Exception {
    public InstallException(String msg) {
        super(msg);
    }
}
