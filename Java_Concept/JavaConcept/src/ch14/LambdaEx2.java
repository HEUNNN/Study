package ch14;

@FunctionalInterface
interface Myfunction2 {
    void myMethod(); // public abstract void myMethod();
}
public class LambdaEx2 {
    public static void main(String[] args) {
        Myfunction2 f = () -> {}; // (MyFunction2) 형변환이 생략됨
        Object obj = (Myfunction2)() -> {}; // (Object) 형변환이 생략됨
        String str = ((Object)(Myfunction2)() -> {}).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);
    }
}
