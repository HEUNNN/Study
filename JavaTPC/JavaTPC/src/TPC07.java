public class TPC07 {
    public static void main(String[] args) {
        // 매개변수 전달기법 실습
        int a=10;
        float b=34.5f;

        float[] arr={12.3f, 4};
        // a와 b의 합을 구하는 메서드를 작성
        System.out.println("sum1, "+ sum1(a, b));
        System.out.println("sum2, "+ sum2(arr));

    }
    public static float sum1(int a, float b){
        return a+b;
    }
    public static float sum2(float[] array){
        float sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum;
    }
}
