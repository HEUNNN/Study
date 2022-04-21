package CH7;
// Overloading VS Overrriding
public class Parent {
    public void parrentMethod() {

    }
}
class Child extends Parent {
    public void  parrentMethod() {
        System.out.println("Overriding");
    }
    public void parrentMethod(int i) {
        System.out.println("Overloading");
        System.out.printf("i: %d%n", i);
    }

    public void childMethod() {
        System.out.println("Child's Method");
    }
    public void childMethod(String name) { // Overloading
        System.out.printf("User name is %s%n", name);
    }
//    public void childMethod() { // Error, 중복 정의
//        System.out.println("Child's Method");
//    }
}