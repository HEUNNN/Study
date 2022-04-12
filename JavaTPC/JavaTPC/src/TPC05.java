import java.util.Arrays;

public class TPC05 {
    public static void main(String[] args) {
        // 변수: 데이터를 한 개만(한 개의 형태) 저장 가능하다. -> 저장만 한다.
        // 메서드: 동작을 한 후에 데이터를 한 개만(한 개의 형태) 만들어 낸다. ->  동작 후 저장한다.
        // * 메서드에서 리턴하는 값을 메서드 이름에 저장한다. (메서드 이름이 변수 역할을 한다.)
        // * 메서드는 정의부와 구현부로 구성된다. -> 정의부(매개변수){ 처리부분&리턴여부 }
        int a=7;
        int b=5;
        int res = sum(a,b);
        System.out.println("sum result:" + res);
        int[] x=makeArr();
        System.out.println(sum(x[0], x[1]));
        System.out.println(Arrays.toString(x));
        // x 변수가 가리키고 있는 값은 배열이 들어있는 메모리의 주소값이기 때문에, 반복문을 사용하거나 배열을 출력할 수 있는 메소드인 Arrays.toString()을 사용해야한다.
    }
    // static main 함수에서 외부에 정의한 메서드를 호출하려면 외부 메서드가 메모리에 로딩이 되어있어야 한다.
    // => 즉, static 함수 안에서 다른 메서드를 호출하여 사용하려면 다른 메서드도 static 이어야 호출하기 쉽다.
    public static int sum(int x, int y){ // 메서드에서 return을 하지 않을 때는 void 사용, 매개변수로 배열의 형태를 받을 수 있음
        return x+y;
    }
    public static int[] makeArr(){
        int[] arr=new int[2];
        arr[0]=1;
        arr[1]=2;
        return arr;
    }
}