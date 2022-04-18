import kr.TPC.A;
import kr.TPC.B;
import kr.inflearn.ObjectArray;

import java.util.ArrayList;

public class TPC37 {
    public static void main(String[] args) {
        // 직접 설계한 ObjectArray class(API)에 kr.TPC의 A, B 클래스와 정수 '12'를 원소로 삽입하고, 출력해보기
        // size 확장 X -> ArrayList 자바에서 제공해주는 API 사용시 자동 확장 가능
        ObjectArray arr1 = new ObjectArray(3);
        arr1.add(new A()); // kr.TPC의 A 클래스를 생성(new)하고 파라미터로 넣어줘야 한다.
        arr1.add(new B()); // Upcasting
        for (int i = 0; i < arr1.size(); i++) {
            if(arr1.get(i) instanceof A){
                ((A)arr1.get(i)).Go(); // Downcasting
            }else {
                ((B)arr1.get(i)).Go();
            }
        }
    }
}
