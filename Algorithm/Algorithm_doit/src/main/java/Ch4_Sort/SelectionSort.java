package Ch4_Sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 2,3,  1, 6};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    private static void selectionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int start = 0;
            int target = a[i];
            while (start < i) {
                if (a[start] > target) {
                    swap(a, start, i);
                }
                start++;
            }
        }
    }

    private static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

}
