import kr.TPC.BookDTO;

public class TPC14 {
    public static void main(String[] args) {
        // 책-> class BookDTO 설계 -> 객체 -> 인스턴스

        // 개별로 된 4개의 변수에 데이터를 넣어준 경우
        String title="스프링";
        int price=10000;
        String company="한빛";
        int page=200;
        // 다른 메서드로 이동시킬 경우 -> 하나로 묶어진 기억공간이 필요
        // 배열 or 직접 설계(class로 객체 설계)
        // 데이터의 자료형이 다르면 배열로 담을 수 없다.

        //DTO: Data Transfer Object, 이동을 위한 Object
        BookDTO dto; // dto = object(객체 변수), 아직 구체적으로 데이터를 가리키고 있지 않다.
        dto=new BookDTO(title, price, company, page); // dto = instance, 구체적인 메모리의 기억공간(실체)를 가리키고 있다.
        // 개별로 된 4개의 데이터가 dto로 하나로 묶어짐
        // 하나로 묶은 dto를 다른 메서드로 이동,
        bookPrint(dto);
    }
    public static void bookPrint(BookDTO dto) {
        System.out.println("Title: "+ dto.title);
        System.out.println("Price: "+dto.price);
        System.out.println("Company: "+dto.company);
        System.out.println("Page: "+ dto.page);
    }
}
