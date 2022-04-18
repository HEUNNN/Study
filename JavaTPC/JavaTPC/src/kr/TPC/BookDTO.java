package kr.TPC;
// 책(객체)는 제목, 가격, 출판사, 페이지수 .. (상태정보)와 (행위정보: 동작 = 메서드)로 구성된다.
// 사용자 정의 자료형 UDDT
public class BookDTO { // 객체 정의, 설계
    public String title; // 상태정보
    public int price;
    public  String company;
    public int page;
    // 디폴트 생성자 메서드(거의 생략함), overloading 시에는 자동으로 생성되지 않는다.
    public BookDTO() {
        // 생성자는 객체를 생성하는 작업을 한다.
        // 생성자 메서드를 사용하면 객체가 메모리에 만들어지며, 동시에 자기 자신을 가리키는 this 객체가 생성된다.
       super();
    }
    public BookDTO(String title,int price ,String company,int page){
        this.title = title;
        this.price = price;
        this.company = company;
        this.page = page;
    }

    @Override
    public String toString() {
        return "[title: " + title + ", price: " + price + ", company: " + company + ", page: " + page + "]";
    }
}
