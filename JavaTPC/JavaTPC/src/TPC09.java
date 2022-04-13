public class TPC09 {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        TPC09 tpc=new TPC09(); // heap area 영역에 클래스가 생성
        int res= tpc.add(a,b);
        System.out.println("non-static method result is "+res);
    }
    public int add(int x, int y){
        return x+y;
    }
}
