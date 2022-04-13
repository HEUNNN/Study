public class TPC08 {
    public static void main(String[] args) {
        int a=10;
        int b=23;
        int sum=add(a,b); // static method call
        System.out.println("result is "+sum);
    }
    public static int add(int x, int y){
        return x+y;
    }
    // static keyword는 프로그램을 실행하기 전
    // 메서드의 기계어 코드를 자동으로 메모리의 static zone에 로딩하기 위해 사용한다.

}
