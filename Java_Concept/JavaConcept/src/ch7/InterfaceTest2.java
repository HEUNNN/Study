package ch7;

public class InterfaceTest2 {
    public static void main(String[] args) {
        A a= new A();
        a.autoPlay(new B());
        a.autoPlay(new C());
    }
}
class A {
    public void autoPlay(I i) { // Interface I 타입의 매개변수를 받는다는 뜻
        i.play();
    }
}
interface I {
    public abstract void play();
}

class B implements I {
    public void play() {
        System.out.println("play in B class");
    }
}
class C implements I {
    public void play() {
        System.out.println("play in A class");
    }
}