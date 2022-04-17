package kr.poly;

public class Radio implements RemoCon{
    @Override
    public void chUp(){
        System.out.println("Radio CH UP");
        System.out.println("Max Channel: " + RemoCon.MAXCH);
    }
    @Override
    public void chDown(){
        System.out.println("Radio CH DOWN");
        System.out.println("Min Channel: " + RemoCon.MAXCH);
    }
    @Override
    public void internet(){
        System.out.println("Radio, internet is working.");
    }
}
