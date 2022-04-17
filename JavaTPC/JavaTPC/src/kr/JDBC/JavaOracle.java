package kr.JDBC;

public class JavaOracle implements DbConnect{
    @Override
    public void getConnection(String url, String user, String password) {
        System.out.println("Connect Oracle DB");
    }
}
