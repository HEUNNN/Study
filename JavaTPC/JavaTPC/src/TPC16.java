import kr.UDDT.Overload;

public class TPC16 {
    public static void main(String[] args) {
        // static으로 정의한 Overload class method
        int res1 = Overload.sum(3,4); // sum_int_int(3, 4);

        Overload ov = new Overload();
        // non-static으로 정의한 Overload class method
        float res2 = ov.sum(3, 3.4f); // sum_int_float(3, 3.4f)
        float res3 = ov.sum(2.35f, 4.78f); // sum_float_float(2.35f, 4.78f)
        
        System.out.println("res1: " + res1 +", res2: "+res2 + ", res3: "+res3);
    }
}
