package Ch4_Sort;


import java.util.Arrays;

public class ComparatorEx {
    public static void main(String[] args) {
        MyInteger[] arr = new MyInteger[5];
        arr[0] = new MyInteger(2);
        arr[1] = new MyInteger(1);
        arr[2] = new MyInteger(3);
        arr[3] = new MyInteger(5);
        arr[4] = new MyInteger(4);

        Arrays.sort(arr);
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i].i);
        }
    }

    public static class MyInteger implements Comparable<MyInteger> {
        int i;
        public MyInteger(int i) {
            this.i = i;
        }

        @Override
        public int compareTo(MyInteger o) {
            return o.i - this.i; // 내림 차순
        }
    }
}
