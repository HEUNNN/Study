package CH7;

import CH7_Class.CaptionTv;

public class CaptionTvTest {
    public static void main(String[] args) {
        CaptionTv ct = new CaptionTv();
        ct.channel = 10; // 조사 클래스로부터 상속받은 멤버 변수
        ct.ChannelUp();
        System.out.println(ct.channel); // 11
        ct.displayCaption("Hello, world");
        ct.caption = true;
        ct.displayCaption("Hello, world!!");
    }
}
