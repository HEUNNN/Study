package Ch4_Sort;


public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {5, 3, 8, 9, 2, 4, 7};
        int[] arr = {5, 7, 3, 8, 1, 9};
        sort(arr);

        System.out.println();
        System.out.print("answer: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sort(int[] a) {
        pivotSort(a, 0, a.length - 1);
    }

    private static void pivotSort(int[] arr, int lo, int hi) {
        if (lo >= hi) { // ???
            return;
        }

        int pivotIdx = partition(arr, lo, hi);

        pivotSort(arr, lo, pivotIdx - 1);
        pivotSort(arr, pivotIdx + 1, hi);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int lo = start;
        int hi = end;

        while (lo < hi) {

            while (arr[hi] > pivot && lo < hi) {
                hi--; // 이 while문과 아래의 while문의 자리가 바뀌면 안된다.
            }

            while (arr[lo] <= pivot && lo < hi) {
                lo++;
            }
            swap(arr, lo, hi);
            print(arr, null);

        }

        swap(arr, start, lo); // start: pivot의 index
        print(arr, "swap");
        return lo;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    private static void print(int[] a, String msg) {
        int N = a.length;
        if (msg != null) {
            System.out.print(msg + ": ");
        }
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
