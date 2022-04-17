import kr.TPC.BookVO;

public class TPC12 {
    public static void main(String[] args) {
        // 생성자 ->  객체 생성 & 초기화
        // 생성자를 2개 이상 정의하여 구현하는 중복정의 가능 = overloading
        BookVO b1 = new BookVO();
        BookVO b2 = new BookVO("Hello", 10000);
        // 생성 & 초기화
        BookVO b3 = new BookVO("World", 20000, "Acompany", 200);

        System.out.println(b3.title);
    }
}
