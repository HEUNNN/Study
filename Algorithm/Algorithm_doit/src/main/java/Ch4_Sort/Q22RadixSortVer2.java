package Ch4_Sort;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Q22RadixSortVer2 {
    public static void main(String[] args) throws IOException {
        int max_size = 5;
        int[] arr = {100, 2343, 1, 23, 345, 17, 89};

        radixSort(arr, max_size);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void radixSort(int[] a, int max_size) {
        Queue<Integer>[] bucket = new LinkedList[10]; // Queue는 FIFO
        int n = a.length;

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }

        int jarisu = 1;
        for (int i = 0; i < max_size; i++) {
            for (int j = 0; j < n; j++) {
                int idx = (a[j] / jarisu) % 10;
                bucket[idx].add(a[j]);
            }

            for (int k = 0, r = 0; k < bucket.length; k++) {
                while (!bucket[k].isEmpty()) {
                    a[r++] = bucket[k].poll();
                }
            }

            jarisu *= 10;
        }
    }

}
