import kr.JDBC.DbConnect;
import kr.JDBC.JavaMySQL;
import kr.JDBC.JavaOracle;

public class TPC29 {
    public static void main(String[] args) {
        // Oracle, MySQL 등을 연결하기 위해서는 Bender에서 제공하는 Driver Class가 필요하다.
        // 가상으로 Driver Class 만들어보기
        DbConnect db1 = new JavaOracle();
        db1.getConnection("oracle", "LeeHyeeun", "1234");
        DbConnect db2 = new JavaMySQL();
        db2.getConnection("MySQL", "LeeHyeeun", "12345");
    }
}
