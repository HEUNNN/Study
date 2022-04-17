package kr.poly;

public class TV implements RemoCon {
    // Interface인 TV 클래스의 abstract method를 override ->  빠짐없이 모두 override 해야한다.
    @Override
    public void chUp() {
        System.out.println("TV CH UP");
    }

    @Override
    public void chDown() {
        System.out.println("TV CH DOWN");
    }

    @Override
    public void internet() {
        System.out.println("TV, internet is working.");
    }
    // TV 클래스만의 추가적인 기능을 넣어줘도 된다.
}
