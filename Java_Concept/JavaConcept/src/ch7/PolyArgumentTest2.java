package ch7;

import java.util.*;

public class PolyArgumentTest2 {
    public static void main(String[] args) {
        Buyer2 b2 = new Buyer2();
        Tv tv = new Tv();
        Computer com = new Computer();
        Audio aud = new Audio();

        b2.Buy2(tv);
        b2.Buy2(com);
        b2.Buy2(aud);
        b2.Summary2();
        System.out.println();
        b2.Refund(com);
        b2.Summary2();
    }
}
class Buyer2 {
    // Vector 클래스로 객체 생성하여 사용하기
    // Vector: 동적으로 크기가 관리되는 개체배열
    int money = 1000;
    int point = 0;
    Vector item = new Vector();
    public void Buy2(Product p) {
        if(money < p.price) {
            System.out.println("잔액 부족, 구매 불가");
            return;
        }
        money -= p.price;
        point += p.point;
        item.add(p); // add(Object o): Vector에 객체를 추가하는 Vector 클래스의 메서드이다. 추가에 성공하면 true, 실패하면 false를 반환한다.
        System.out.println(p + "를 구입하였습니다.");
    }
    public void Refund(Product p) {
        if(item.remove(p)) {
            money += p.price;
            point -= p.point;
            System.out.println(p + "를 반품하였습니다.");
        }else {
            System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
        }
    }
    public void Summary2() {
        int sum = 0;
        String itemList = "";
        if(item.isEmpty()) {
            System.out.println("구입하신 제품이 없습니다.");
            return;
        }
        for (int i = 0; i < item.size(); i++) {
            Product tmp = (Product)item.get(i);
            sum += tmp.price;
            itemList += (i==0) ? "" + tmp : ", " + tmp;
        }
        System.out.println("구입하신 물품의 총금액은 " + sum + "만원 입니다. 잔액은 " + money + "이고, 적립된 포인트는 " + point + "입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}