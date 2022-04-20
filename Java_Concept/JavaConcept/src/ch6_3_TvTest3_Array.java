import ch6_class.Tv;

public class ch6_3_TvTest3_Array {
    public static void main(String[] args) {
        Tv[] tArr = new Tv[3]; // 객체 배열 생성
        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = new Tv(); // 객체 배열 생성 후, 배열 원소에 Tv 인스턴스를 생성해야한다.
            tArr[i].channel = i + 1;
            System.out.printf("tArr[%d], Current Channel: %d",i , tArr[i].channel);
            System.out.println();
        }
        for (int i = 0; i < tArr.length; i++) {
            tArr[i].channelUp();
            System.out.printf("tArr[%d], Channel Up : %d",i , tArr[i].channel);
            System.out.println();
        }
    }
}
