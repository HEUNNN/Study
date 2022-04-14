import kr.UDDT.BookDTO;

public class TPC10 {
    public static void main(String[] args) {
        // int, float, char, boolean -> PDT
        int a=10;
        // BookDTO이라는 자료형을 class를 사용하여 만든다.
        BookDTO book=new BookDTO(); // 객체 생성
        book.title="책 제목입니다.";
        book.price=15000;
        book.company="A출판사";
        book.page=100;
    }
}
