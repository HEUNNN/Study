import kr.inflearn.IntArray;

public class TPC36 {
    public static void main(String[] args) {
        // 정수 3개를 배열에 저장하고 출력 -> 클래스(API)를 사용하지 않는 경우
        int[] arr1 = new int[3];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 1;
            System.out.print(arr1[i] + "\t");
        }
        System.out.println();

        // 배열처럼 동작하는 class(API)를 생성하여 사용하는 경우 -> 객체지향적인 방식
        IntArray arr2 = new IntArray(3);
        System.out.println(arr2.size()); // 0
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        System.out.println(arr2.size()); // 3
        for (int i = 0; i < arr2.size(); i++) {
            System.out.print(arr2.get(i) + "\t");
        }
    }
}