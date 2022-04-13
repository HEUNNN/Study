public class TPC06 {
    public static void main(String[] args) {
        // 메서드의 매개변수 전달기법(parameter passing)
        // 1. Call By Value(값 전달 기법) -> 기억공간 개별
        // 메서드가 호출되기 위한 조건: 실인수의 개수와 가인수의 개수가 같아야하고, 자료형이 같아야한다.
        int a=10;
        int b=2;
        int res=cbv(a,b); // int a, int b 는 실인수
        System.out.println("Call By Value, "+res);
        // 2. Call By Reference(번지, 주소 전달 기법) -> 기억공간 공유
        int[] arr={1, 2};
        System.out.println("Call By Reference, "+cbr(arr));
    }
    public static int cbv(int x, int y){ // 값 전달 기법 method 정의 ( int x, int y 는 가인수)
        return x + y;
    }
    public static int cbr(int[] array){ // 번지 전달 기법 method 정의
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum += array[i];
        }
        return sum;
    }
}
