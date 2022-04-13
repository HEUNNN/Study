public class TPC09 {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        TPC09 tpc=new TPC09();
        int res= tpc.add(a,b);
        System.out.println("non-static method result is "+res);
    }
    public int add(int x, int y){
        return x+y;
    }
}
