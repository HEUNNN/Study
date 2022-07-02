package Ch5_Search;

import java.util.Arrays;

public class BinarySearch {
    // 이진 탐색

    static int result;

    public static void main(String[] args) {

//        int[] array = new int[]{3, 7, 13, 15, 23, 35, 38, 41, 46, 49, 55, 67, 68, 72, 77, 86};
        int[] array = new int[]{4, 1, 5, 2, 3};
        Arrays.sort(array);
        int endIdx = array.length - 1;

        binarySearch2(array, 0, endIdx, 7);
    }

    private static void binarySearch(int[] array, int s, int e, int target) {

        // 재귀 사용 O
        if (s > e) {
            System.out.println("값이 없습니다.");
            return;
        }

        int mid = (s + e) / 2;
        if (array[mid] < target) {
            binarySearch(array, mid + 1, e, target);
        } else if (array[mid] == target) {
            result = mid;
            System.out.println(result); // 값이 존재하는 인덱스 출력
            return;
        } else {
            binarySearch(array, s, mid - 1, target);
        }
    }

    private static void binarySearch2(int[] array, int s, int e, int target) {
        // 재귀 사용 X
        while (s <= e) {
            int midIdx = (s + e) / 2;
            int midxVal = array[midIdx];

            if (midxVal > target) {
                e = midIdx - 1;
            } else if (midxVal == target) {
                result = midIdx;
                System.out.println(result);
                return;
            } else {
                s = midIdx + 1;
            }
        }
        System.out.println("값이 없습니다.");
    }
}
