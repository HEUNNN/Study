package ch8;

public class FinallyTest2 {
    public static void main(String[] args) {
        // method1()은 static 메서드이므로 인스턴스 생성없이 직접 호출이 가능하다.
        FinallyTest2.method1();
        System.out.println("method1()의 수행을 마치고 main 메서드로 돌아왔습니다.");
    }
    public static void method1() {
        try {
            System.out.println("method1()이 호출되었습니다.");
            return; // 현재 실행중인 메서드를 종료한다.
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("method1()의 finally 블럭이 실행되었습니다.");
        }
    }
}
/*
 * try 블럭에서 return 문이 실행되는 경우에도 finally 블럭의 문장들이 먼저 실행된 후에, 현재 실행 중인 메서드를 종료한다.
 * catch 블럭의 문장 수행 중에 return 문을 만나도 finally 블럭의 문장들은 수행된다.
 */
