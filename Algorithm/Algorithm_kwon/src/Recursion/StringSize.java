package Recursion;

public class StringSize {

    public static void main(String[] args) {
        String str = "apple";
        int result = length(str);
        System.out.println("'" + str + "'" + " size: " + result);
    }

    public static int length(String str) {
        if (str.equals("")) {
            return 0; // empty
        } else {
            return 1 + length(str.substring(1));
            /* substring()
             * 1. substring(int index)일 경우
             *    0번에서 index-1까지 잘라내고 남은 문자열을 return
             * 2. substring(int beginIndex, int endIndex)일 경우
             *    beginIndex를 포함한 위치에서부터 endIndex-1까지 잘라내고 남은 문자열을 return
             * */
        }
    }
}
