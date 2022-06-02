package hello.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드 -> 공유되는 필드

    /*
    * 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야한다.
    * */
    public int order(String name, int price) {
        System.out.println("name: " + name + ", price: " + price);
//        this.price = price; // 이곳에서 문제가 생긴다.
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
