import kr.TPC.BookVO;

public class TPC11 {
    public static void main(String[] args) {
        // 책 1권을 저장하기위해 객체를 생성한다.
        BookVO b =new BookVO();
        b.title="Python";
        b.price=12000;
        b.company="한빛";
        b.page=200;
        System.out.print(b.title+"\t");
        System.out.print(b.price+"\t");
        System.out.print(b.company+"\t");
        System.out.print(b.page+"\t");

    }
}
