public class ch6_11_Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(13));
    }
    static int factorial(int n) {
        // 유효성 검사 필요
        if(n <=0 || n > 12) return -1;
        int result = 0;
        if(n == 1){
            result = 1;
        }else {
            result = n * factorial(n - 1);
        }
        return result;
    }
}
