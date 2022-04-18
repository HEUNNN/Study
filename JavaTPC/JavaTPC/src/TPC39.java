public class TPC39 {
    public static void main(String[] args) {
        // Wrapper Class: 기본 자료형을 Class 타입으로 사용할 수 있게 해준다.
        int a = 10;
//        Integer b = new Integer(1); // 해당 버전부터는 Integer 방식은 권장, 사용하지 않는다. Java Compiler가 Boxing하여 아래와 같이 사용한다.
        Integer b = 10;
        System.out.println(b.intValue()); // 10
        System.out.println(b.toString()); // 10

        // Wrapper 를 사용한 이유
        Object[] obj = new Object[6];

        // Unboxing 방법
        obj[0] = new Integer(1); // 정확한 정석 표현
        obj[1] = new Integer(2); // Object class와 Integer의 타입은 class로 같음
        obj[2] = new Integer(3);

        // Boxing 방법
        obj[3] =4;
        obj[4] =5;
        obj[5] = 6;

        for (int i = 0; i < obj.length; i++) {
            System.out.print(obj[i].toString() + "\t"); // Integer class에서 재정의한 toString()이 사용된다.
        }
        System.out.println();

        // "100" + "100" = 200 -> String인 "100"을 정수형으로 변환해야 sum 계산이 된다.
        String x = "100";
        String y = "100";
        System.out.println(x + y); // "100100"
        int val1 = Integer.parseInt(x);
        int val2 = Integer.parseInt(y);
        System.out.println(val1 + val2); // 200

        // 100 + 100 = "100100"
        String str1 = String.valueOf(val1);
        String str2 = String.valueOf(val2);
        System.out.println(str1 + str2); // "100100"
    }
}
