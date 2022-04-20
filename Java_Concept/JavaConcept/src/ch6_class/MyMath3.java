package ch6_class;

public class MyMath3 {
    private String name;
    private int age;

    // Overloading
    public MyMath3() {
        super();
    }
    public MyMath3(String name, int age) { // default 생성자와 name, age를 초기화 하는 생성자 overloading
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
