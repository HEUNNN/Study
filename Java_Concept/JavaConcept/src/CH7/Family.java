package CH7;

public class Family {
    public static void main(String[] args) {
        Sun s = new Sun("Sun", 50);
        s.printName();
    }
}
class Mother {
    String name;
    int age;
    //public Mother() {} // super()가 생략, 컴파일러가 자동으로 super()를 호출해준다.
    public Mother(String name, int age) {
        // Mother 생성자에서 super()은 root 인 Object를 생성한다. 다른 생성자가 있는 경우 default 생성자는 생성되지 않기 때문에 따로 작성을 해주어야 한다.
        this.name = name;
        this.age = age;
    }
}
class Sun extends Mother{
    String name;
    int age;
    public Sun(String name, int age) {
        super("Mom", 40); // Mother 생성자는 name, age를 파라미터로 전달하는 것만 있다면 super를 작성할 때도 name, age를 파라미터로 넘겨주어야 한다.
        this.name = name;
        this.age = age;
    }
    public void printName() {
        System.out.println("sun name: " + this.name);
        System.out.println("mother name: " + super.name);
    }
}
