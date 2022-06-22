package Ch4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19QuickSort {
    // 백준 11004
    // K 번째 수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, arr.length - 1, K);

        System.out.println(arr[K]);

    }

    public static void quickSort(int[] a, int s, int e, int K) {
        if (s < e) {
            int idx = partition(a, s, e);

            if (idx < K) {
                quickSort(a, idx + 1, e, K);
            } else if (idx == K) {
                return; // main으로 돌아서 arr[K] 하면 된다.
            } else {
                quickSort(a, s, idx - 1, K);
            }
        }
    }

    public static int partition(int[] a, int s, int e) {
        int mid = (s + e) / 2;
        int pivot = a[mid];
        swap(a, s, mid);
        int lo = s;
        int hi = e;


        while (lo < hi) {
            while (a[hi] > pivot && lo < hi) {
                hi--;
            }
            while (a[lo] <= pivot && lo < hi) {
                lo++;
            }
            swap(a, hi, lo);
        }
        swap(a, s, lo);
        return lo;

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
