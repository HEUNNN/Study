package CH7_Class;

public class CaptionTv extends Tv{
    public boolean caption;
    public void displayCaption(String text) {
        if(caption) {
            System.out.println(text);
        }
    }
}
