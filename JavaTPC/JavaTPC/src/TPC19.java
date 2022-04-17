import com.google.gson.Gson;
import kr.TPC.BookVO;
import kr.TPC.MyUtil;
import java.lang.*; // * 는 전체를 뜻함, java.lang.String을 하나하나 import 하기 번거롭기 때문
// import java.lang.*;은 default package로 생략되어 있다.
public class TPC19 {
    public static void main(String[] args) {
        // 1. Java에서 제공해주는 Class => API
        // 문자열(String class)
        String str = new String("APPLE"); // String 앞에 String이 속한 패키지 이름 java.lang. 이 생략되어 있다.
        System.out.println("toLowerCase()사용: "+ str.toLowerCase());

        // 2. 직접 만들어서 사용하는 Class -> DTO/VO, DAO, Utillity API
        MyUtil my=new MyUtil();
        System.out.println("Utillity API: " + my.sum());

        // 3. 다른 사람이 만들어 둔 Class -> API
        // Gson -> json
        // https://mvnrepository.com/ 에서 다운로드
        // intellij의 file에서 Project structure로 들어가고, Modules에서 Dependencies에 들어간 후 Jars or Directories + 추가한다.
        Gson g =new Gson();
        BookVO vo = new BookVO("자바", 13000, "영진", 800);
        String json = g.toJson(vo); // String type으로 변수 선언 후 할당
        System.out.println(g.toJson((vo)));
        System.out.println(json);
    }
}
