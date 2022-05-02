package ch14;

@FunctionalInterface
interface Myfunction {
    void myMethod(); // public abstract void myMethod();
}
public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction f = () -> {}; // (MyFunction) 형변환이 생략됨
        Object obj = (MyFunction)() -> {}; // (Object) 형변환이 생략됨
        String str = ((Object)(MyFunction)() -> {}).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);
    }
}
