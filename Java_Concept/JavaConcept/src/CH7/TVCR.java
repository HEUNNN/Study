package CH7;

import CH7_Class.Tv;

public class TVCR extends Tv {
    VCR vcr = new VCR();

    void play() {
        vcr.Play();
    }

    public static void main(String[] args) {
        TVCR tvcr = new TVCR();
        tvcr.play();
    }
}
class VCR {
    public boolean power;
    public int counter  = 0;
    public void Power() {
        power = !power;
    }
    public void Play() {
        System.out.println("Play!!");
    }
}
