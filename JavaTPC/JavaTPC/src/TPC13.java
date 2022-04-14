import kr.UDDT.Print;

public class TPC13 {
    public static void main(String[] args) {
        // Print.instanceMethod()은 static이 아니라서 객체 이름으로 바로 접근하지 못한다.
        // new 로 객체를 생성해서 접근해야한다.
        Print.classMehtod("Leehyeeun"); // overloading
        Print.classMethod();

        // Java API private 생성자 -> new className() 으로 객체 생성 불가능
        System.out.println("대표적인 Java API private 생성자 'System'");
        int v = Math.max(10,3);
        System.out.println("Max Number is " +v);

        // class 내부에 non-static 메서드와 static 메서드가 동시에 존재할 수 있다.
        // class 생성자가 private라면 non-static 메서드는 사용할 수 없지만, static 메서드는 사용이 가능하다.
        // class 생성자가 public이라면 non-static 메서드는 객체를 생성한 후 사용하면 되고,
        // -> Print p = new Print();
        // -> p.instanceMethod();
        // static 메서드는 객체 이름에 '.'을 이용하여 바로 사용하면 된다.
        // -> Print.classMethod();
    }

}
