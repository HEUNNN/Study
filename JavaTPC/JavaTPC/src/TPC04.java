public class TPC04 {
    public static void main(String[] args) {
        // 변수와 배열의 관계 -> 데이터를 이동하라
        int a,b,c;
        a=10;
        b=20;
        c=30;
        // a+b+c=? 메서드 처리 -> hap()
        // sum1() 메서드 호출을 해야한다.
        sum1(a,b,c);

        // 1차원 배열
        int[] arr; // 배열 변수 선언
        arr=new int[3]; // 배열 인스턴스 생성
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;
        sum2(arr);


        // 2차원 배열
        int[][] x=new int[3][4]; // 3행 4열
        System.out.print(x.length+"\t"); // 3
        for(int i=0;i< x.length;i++){
            System.out.print(x[i].length+"\t");
        }
        System.out.println();

        // 2차원 배열 - 가변길이 배열
        int[][] y=new int[3][];
        y[0]=new int[4];
        y[1]=new int[5];
        y[2]=new int[6];
        System.out.print(y.length+"\t");
        for(int i=0;i<y.length;i++){
            System.out.print(y[i].length+"\t");
        }
        System.out.println();

        // 2차원 구조로 9개의 정수형 변수를 만들어라 -> 3x3
        int[][] z=new int[3][3];
        z[0][0]=0;
        z[0][1]=1;
        z[0][2]=2;
        z[1][0]=3;
        z[1][1]=4;
        z[1][2]=5;
        z[2][0]=6;
        z[2][1]=7;
        z[2][2]=8;
        for(int i=0;i<z.length;i++){
            for(int j=0;j<z[i].length;j++){
                System.out.print(z[i][j]+"\t");
            }
            System.out.println();
        }

        // 가변 길이 배열
        int[][] star=new int[5][];
        star[0]=new int[1];
        star[1]=new int[2];
        star[2]=new int[3];
        star[3]=new int[4];
        star[4]=new int[5];
        for(int i=0;i<star.length;i++){
            for(int j=0;j<star[i].length;j++){
                star[i][j]='*';
                System.out.print((char)star[i][j]); // (char)을 붙여주지 않으면, 출력할 때 숫자로 출력된다.
            }
            System.out.println();
        }



    }
      public static void sum1(int a, int b, int c) {
        float sum;
        sum = a+b+c;
        System.out.println(sum);
    }

    public static void sum2(int[] x) {
        // 반복문 -> for, while
        int sum=0;
        for(int i=0;i<x.length;i++){
            sum+=x[i];
        }
        System.out.println(sum);
    }
}

