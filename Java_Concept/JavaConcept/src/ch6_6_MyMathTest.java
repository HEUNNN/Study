public class ch6_6_MyMathTest {
    // 같은 곳에서 내부 클래스를 사용하려면 static 이여야 한다.
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long res1 = mm.add(5L, 3L);
        long res2 = mm.subtract(5L, 3L);
        long res3 = mm.multiply(5L, 3L);
        double res4 = mm.divide(5L, 3L);

        System.out.printf("Add res: %d, Subtract res: %d, Multiply res: %d, Divide res: %f", res1, res2, res3, res4);
    }
    public static class MyMath {
        long add(long a, long b){
            return a + b;
        }
        long subtract(long a, long b){
            return a - b;
        }
        long multiply(long a, long b) {
            return a * b;
        }
        double divide(double a, double b) {
            return a / b;
        }
    }
}
