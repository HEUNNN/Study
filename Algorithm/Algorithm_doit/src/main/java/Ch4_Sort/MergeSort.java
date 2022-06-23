package Ch4_Sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 6, 1, 5};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] sorted; // 부분 배열을 합치는 과정에서 정렬하여 원소를 담을 임시 배열

    private static void mergeSort(int[] a) {
        sorted = new int[a.length];
        mergeSort(a, 0, a.length - 1);
        sorted = null;
    }


    private static void mergeSort(int[] a, int left, int right) {
        /*
         * left == right, 부분 리스트가 1개의 원소를 가질때까지 쪼갠다.
         * */
        if (left == right) return;

        int mid = (left + right) / 2;

        mergeSort(a, left, mid); // 절반 중 왼쪽 부분 리스트
        mergeSort(a, mid + 1, right); // 절반 중 오른쪽 부분 리스트

        merge(a, left, mid, right);

    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left; // 왼쪽 부분리스트의 시작점
        int r = mid + 1; // 오른쪽 부분리스트의 시작점
        int idx = left;

        while (l <= mid && r <= right) {
            if (a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        // 왼쪽 부분 리스트가 먼저 새 배열에 먼저 채워질 경우, 즉 오른쪽 부분리스트 원소가 아직 남아 있을 경우
        // 오른쪽 부분리스트의 나머지 원소들을 sorted에 채워준다.
        if (l > mid) {
            while (r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        // 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }

    }
}
