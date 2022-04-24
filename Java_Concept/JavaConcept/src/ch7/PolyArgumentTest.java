package ch7;
import java.lang. *;
import java.lang.Override;

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.Buy(new Tv());
        b.Buy(new Computer());
        b.Buy(new Audio());
        b.Summary();
    }
}
class Product {
    int price;
    int point;

    public Product(int price) {
        this.price = price;
        this.point = (int)(price / 10.0);
    }
    public Product() {
        // 기본 생성자
   }
}
class Tv extends Product {
        public Tv() {
            super(100); // 조상 클래스의 생성자 Product(100)을 호출한다.
        }
        @Override
        public String toString() {
            return "Tv"; // Override
        }
}
class Computer extends Product {
        public Computer() {
            super(200);
        }
        @java.lang.Override
        public String toString() {
            return "Computer";
        }
}
class Audio extends Product {
        public Audio() {
            super(50);
        }
        @Override
        public String toString() {
            return "Audio";
        }
}
class Buyer {
    int money = 1000;
    int point = 0;
    Product[] item = new Product[10]; // 구입한 제품을 저장하기 위한 배열
    int i = 0;
    public void Buy(Product p) {  // 조상 타입의 참조변수 p로 자손타입의 객체를 참조
        if(money < p.price) {
            System.out.println("잔액 부족, 구매 불가");
            return;
        }
        money -= p.price;
        point += p.point;
        item[i++] = p; // 구매한 제품을 Product[] item에 저장
        System.out.println(p + "을/를 구입하였습니다."); // toString() 생략해도 괜찮다.
    }
    public void Summary() { // 구매한 물품에 대한 정보를 요약해서 보여준다.
         int sum = 0;
        StringBuilder itemList = new StringBuilder(); // 구입한 물품 목록
        for (Product product : item) {
            if (product == null) break;
            sum += product.price;
            itemList.append(product).append(", "); // .toString() 생략
        }
        System.out.println("구입하신 물품의 총금액은 " + sum + "만원 입니다. 잔액은 " + money + "이고, 적립된 포인트는 " + point + "입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}