import kr.TPC.MovieVO;

public class TPC17 {
    public static void main(String[] args) {
        System.out.println("배열");
        int[] a=new int[5];
        System.out.print("a array:"+"\t");
        for(int i=0;i<a.length;i++){
            a[i] = i+1;
            System.out.print(+a[i]+"\t");
        }
        System.out.println();

        System.out.print("b array:"+"\t");
        int[] b={1, 2, 3, 4, 5};
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+"\t");
        }

        System.out.println();
        System.out.print("c array:"+"\t");
        int[] c=new int[] {1, 2, 3, 4, 5};
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+"\t");
        }
        System.out.println();
        System.out.println("클래스");

        // MovieVO 객체
        MovieVO m = new MovieVO();
        m.setMovie("Hello", 20000, "Hong", 1, 2);
        System.out.println(m.toString());
        MovieVO[] mArr = new MovieVO[5];
        mArr[0] = new MovieVO("a", 1000, "kim", 1, 3);
        mArr[1] = new MovieVO("b", 20000, "park", 2, 4);
        mArr[2] = new MovieVO("c", 10000, "lee", 3, 2);
        mArr[3] = new MovieVO("d", 40000, "yoon", 4, 1);
        mArr[4] = new MovieVO("e", 50000, "kang", 2, 1);
        System.out.println("Object Array");
        for(int i=0;i<mArr.length;i++){
            System.out.println(mArr[i]); // .toString()이 생략되어 있
        }

    }
}
