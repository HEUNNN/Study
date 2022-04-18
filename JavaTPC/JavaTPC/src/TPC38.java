import kr.TPC.BookDTO;

import java.util.ArrayList;

public class TPC38 {
    public static void main(String[] args) {
        // ArrayList를 사용하여 BookDTO 3개를 생성 후 ArrayList에 삽입(저장)
        // ArrayList의 root는 List
        ArrayList<BookDTO> list = new ArrayList<BookDTO>(1); // size 확장 가능
        // List list = new ArrayList(); 도 가능하다

        // 다른 타입의 PDT, UDDT 삽입은 가능하지만 굳이 그렇게 하지 않는다.
        // 다른 타입의 PDT, UDDT 삽입을 방지하기 위해서 genetic type을 사용한다.
        // Genetic type: ArrayList list<BookDTO> = new ArrayList<BookDTO>(1);
        // 배열의 원소 Type이 Object 처럼 포괄적인 타입이 아니라, BookDTO라고 정확하게 정해지면 Downcasting이 필요없어진다.

        list.add(new BookDTO("MySQL", 10000, "Acompany", 200));
        list.add(new BookDTO("Oracle", 20000, "Bcompany", 300));
        list.add(new BookDTO("MariaDB", 30000, "Ccompany", 100));

        // ArrayList의 get() 메서드를 사용한다.
        // 이때 BookDTO 타입으로 get 하기 위해 Downcasting을 한다.
        for (int i = 0; i < list.size(); i++) {
//            BookDTO dto = (BookDTO)list.get(i); // Genetic type을 정하지 않았을 때 DownCasting이 필요하다.
            // 아래 2줄의 코드와 윗줄의 의미는 같다.
//            Object o = list.get(i);
//            BookDTO dto = (BookDTO)o;
//            System.out.println(dto.toString());
            // BookDTO에서 toString()을 재정의하지 않으면 default toString()의 기능인 번지수 출력이 실행된다.
            System.out.println(list.get(i).toString());
        }
    }
}

