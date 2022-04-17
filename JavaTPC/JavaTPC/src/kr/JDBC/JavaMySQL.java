package kr.JDBC;

public class JavaMySQL implements DbConnect{
    @Override
    public void getConnection(String url, String user, String password) {
        System.out.println("Connect MySQL DB");
    }
}
