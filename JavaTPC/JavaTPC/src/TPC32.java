import kr.TPC.A;
import kr.TPC.B;

public class TPC32 {

    public static void main(String[] args) {
        // Object class와 다형성 배열
        Object[] objArr = new Object[2];
        objArr[0] = new A();
        objArr[1] = new B();
        prinGo(objArr);
    }
    public static void prinGo(Object[] objArr) {
        for (int i = 0; i < objArr.length; i++) {
            if(objArr[i] instanceof A){
                ((A)objArr[i]).Go();
            }else {
                ((B)objArr[i]).Go();
            }
        }
    }
}
