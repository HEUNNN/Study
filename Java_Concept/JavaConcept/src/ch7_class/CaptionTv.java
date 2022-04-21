package ch7_class;

public class CaptionTv extends Tv{
    public boolean caption;
    public void displayCaption(String text) {
        if(caption) {
            System.out.println(text);
        }
    }
}
