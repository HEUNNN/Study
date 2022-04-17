import kr.poly.Radio;
import kr.poly.RemoCon;
import kr.poly.TV;

public class TPC27 {
    public static void main(String[] args) {
        RemoCon tv = new TV();
        RemoCon radio = new Radio();

        tv.chDown();
        tv.chUp();
        tv.internet();

        radio.chUp();
        radio.chDown();
        radio.internet();
    }
}
