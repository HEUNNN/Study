package kr.bit;

public class Print {
    private Print(){ // private 생성자 메서드
        super();
    }
    // 생성자를 private로 처리하면 객체를 생성할 수 없다.
    // new Print() 불가능하다.

    // 인스턴스 메서드 -> static keyword X, new로 객체 생성도 안되기 때문에 사용할 수 없다.
//    public void instanceMethod(){
//        System.out.println("인스턴스 메서드");
//    }
    public static void classMehtod(String name){
        System.out.println("My name is "+name);
    }

    // 클래스 메서드 -> static keyword O
    public static void classMethod(){
        System.out.println("클래스 메서드");
    }
    // static 키워드가 붙은 클래스 메서드는 객체를 생성하지 않아도(new 객체()) 사용할 수 있다.
    // static 키워드가 있으면 자동으로 메모리에 올라가있기 때문에 객체를 생성하지 않아도 바로 사용이 가능하다.
}
