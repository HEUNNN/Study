package Recursion;

public class ReverseString {
    public static void main(String[] args) {
        String str = "apple";
        reverse(str);
    }
    public static void reverse(String str) {
        int strLength = str.length();
        if(strLength == 0) {
            return;
        } else {
            reverse(str.substring(1));
            System.out.println(str.charAt(0));
        }
    }
}
