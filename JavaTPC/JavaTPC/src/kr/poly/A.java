package kr.poly;

public class A extends Object{
    public A() {
        super();
    }
    public void display(){
        System.out.println("Display method");

    }
    @Override
    public String toString() {
        return "Overrided toString()";
    }
}
