package kr.poly;

public class TV implements RemoCon {
    int currCH = 70;
    // Interface인 TV 클래스의 abstract method를 override ->  빠짐없이 모두 override 해야한다.
    @Override
    public void chUp() {
        if(currCH < RemoCon.MAXCH){
            currCH ++;
            System.out.println("TV CH UP, current CH: " + currCH);
        }else {
            currCH = 1;
            System.out.println("TV CH UP, current CH: " + currCH);
        }

    }

    @Override
    public void chDown() {
        if(currCH > RemoCon.MINCH){
            currCH --;
            System.out.println("TV CH DOWN, current CH: " + currCH);
        }else {
            currCH = 100;
            System.out.println("TV CH DOWN, current CH: " + currCH);
        }

    }

    @Override
    public void internet() {
        System.out.println("TV, internet is working.");
    }
    // TV 클래스만의 추가적인 기능을 넣어줘도 된다.
}
