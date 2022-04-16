package kr.UDDT;

public class Cat extends Animal{
    public void night(){
        System.out.println("고양이는 밤에 눈에서 빛이 난다.");
    }
    @Override
    public void eat(){
        System.out.println("고양이처럼 먹다.");
//        super.eat(); // 부모의 eat()을 가져옴
    }
}
