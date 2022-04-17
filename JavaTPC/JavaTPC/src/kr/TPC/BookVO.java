package kr.TPC;
// 책(Object)를 class로 설계 -> 제목, 가격, 출판사, 페이지 수
public class BookVO {
    public String title;
    public int price;
    public String company;
    public int page;
    // overloading: 하나의 클래스에 이름이 같은 메서드를 여러개 정의하는 것이다.
    // 객체지향에서는 메서드 이름은 같아도 매개변수의 개수, 타입이 다르면 다른 메서드로 인정된다.
    public BookVO(){ // 생성자를 overloading 하면 default 생성자가 자동으로 생성되지 않기에 따로 정의함
        super();
    }
    public BookVO(String title, int price){
        // title, price 멤버변수만 초기화하는 생성자
        this.title = title;
        this.price = price;
    }
    public BookVO(String title, int price, String company, int page){
        // title, price, company, page 모두 초기화 하는 생성자
        this.title = title;
        this.price = price;
        this.company = company;
        this.page = page;
    }
}
