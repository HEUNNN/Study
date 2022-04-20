public class ch6_8_PrimitiveParam2 {
    public static void main(String[] args) {
        // 배열도 객체와 같이 참조변수를 통해 데이터가 저장된 공간에 접근한다.
        int[] x = {10}; // 크기가 1인 배열 -> x[0] = 10
        System.out.println("main() : x = " + x[0]); // 10
        change(x); // 1000
        System.out.println("main() : x = " + x[0]); // 1000

    }
    static void change(int[] x) {
        x[0] = 1000;
        System.out.println("change() : x = " + x[0]);
    }
}
