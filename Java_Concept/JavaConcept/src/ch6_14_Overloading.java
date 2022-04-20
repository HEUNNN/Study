import ch6_class.MyMath3;

public class ch6_14_Overloading {
    public static void main(String[] args) {
        // overloading된 생성자 사용하기
        MyMath3 mm1 = new MyMath3(); // default 생성자 호출
        mm1.setAge(25);
        mm1.setName("hyeeun");
        System.out.printf("userName: %s, userAge:%d%n", mm1.getName(), mm1.getAge());
        MyMath3 mm2 = new MyMath3("Hyeeun", 25); // name, age를 파라미터로 전달하는 생성자
        System.out.printf("userName: %s, userAge:%d%n", mm2.getName(), mm2.getAge());

    }
}
