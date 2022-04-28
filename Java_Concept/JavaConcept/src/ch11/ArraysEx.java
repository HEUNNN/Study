package ch11;

import java.util.*;

public class ArraysEx {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4}; // int type의 Array(배열)
        int[][] arr2D = {{11, 12, 13}, {21, 22, 23}};

        System.out.println("arr = " + Arrays.toString(arr)); // Arrays 클래스에는 배열을 다루는데 유용한 메서드가 정의되어 있고, 그 메서드들은 static이기 때문에 class 이름을 갖고 바로 사용 가능
        System.out.println("arr2D = " + Arrays.deepToString(arr2D));

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr,3); // 0, 1, 2 번 인덱스까지 copy
        int[] arr4 = Arrays.copyOf(arr, 7); // 빈 자리는 '0'으로 채움
        int[] arr5 = Arrays.copyOfRange(arr, 2, 4); // 마지막 인덱스는 포함 안됨 from <= x < to
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7);

        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println("arr3 = " + Arrays.toString(arr3));
        System.out.println("arr4 = " + Arrays.toString(arr4));
        System.out.println("arr5 = " + Arrays.toString(arr5));
        System.out.println("arr6 = " + Arrays.toString(arr6));

        int[] arr7 = new int[5];
        Arrays.fill(arr7, 9); // arr = [9, 9, 9, 9, 9]
        System.out.println("arr7 = " + Arrays.toString(arr7));

        Arrays.setAll(arr7, i -> (int)(Math.random()*6) + 1);
        System.out.println("arr7 = " + Arrays.toString(arr7));

        for(int i : arr7) {
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph) + i);
        }

        String[][] str2D = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D2 = new String[][]{{"aaa","bbb"}, {"AAA", "BBB"}};

        System.out.println(Arrays.equals(str2D, str2D2)); // false
        System.out.println(Arrays.deepEquals(str2D, str2D2)); // true

        char[] chArr = {'A', 'D', 'C', 'B', 'E'};

        System.out.println("chArr = " + Arrays.toString(chArr));
        System.out.println("index of 'B' = " + Arrays.binarySearch(chArr,'B')); // 정렬이 먼저 안되어서 올바르지 않은 결과를 얻음
        System.out.println("= After Sorting =");
        Arrays.sort(chArr);
        System.out.println("chArr = " + Arrays.toString(chArr));
        System.out.println("index of 'B' = " + Arrays.binarySearch(chArr,'B'));
    }
}
