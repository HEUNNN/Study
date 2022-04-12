import kr.bit.Book;
import kr.bit.PersonVO;

public class TPC03 {
    public static void main(String[] args) {
        // PDT (Primitive Data Type) vs UDDT(User Define Data Type, 사용자 정의 자료형)
        // 정수 1개를 저장하기 위한 변수를 선언하시오. -> PDT(기본 자료형)
        int a; // 변수 선언

        // 책 1권을 저장하기 위한 변수를 선언하시오. -> UDDT(class로 만들어야 함)  *class: 새로운 자료형을 모델링하는 도구
        Book b; // Book 이라는 자료형, b는 변수이다. 변수에는 1개의 데이터만 저장한다.
        b=new Book(); // 생성자를 사용하여 인스턴스 변수(=객체 변수)를 생성한다. 변수에는 생성한 객체의 메모리 주소가 할당된다.
        b.title="Java Book";
        b.price=15000;
        b.company="Hansol";
        b.page=100;
//        System.out.println(b.title); // println에서 ln을 없애면 한줄로 출력된다.
//        System.out.println(b.price);
//        System.out.println(b.company);
//        System.out.println(b.page);
        System.out.print(b.title+"\t"); // 한줄로 출력
        System.out.print(b.price+"\t");
        System.out.print(b.company+"\t");
        System.out.println(b.page);

        PersonVO person;
        person=new PersonVO();
        person.name="Leehyeeun";
        person.age=25;
        person.weight=47;
        person.height=157;
        System.out.print(person.name+"\t");
        System.out.print(person.age+"\t");
        System.out.print(person.weight+"\t");
        System.out.print(person.height+"\t");
    }
}
