package Ch4_Sort;

import java.io.*;


public class Q22RadixSortVer1 {
    // 백준 10989
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        radixSort(arr, 5);
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    private static void radixSort(int[] a, int max_size) {
        int jarisu = 1;
        int count = 0;
        int[] output = new int[a.length];
        while (count != max_size) {
            int[] bucket = new int[10];

            for (int i = 0; i < a.length; i++) {
                int idx = (a[i] / jarisu) % 10;
                bucket[idx]++;
            }

            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1]; // 예) 일의 자리수가 특정 숫자 n인 숫자들의 개수를 합 배열로 표현
            }

            for (int i = a.length - 1; i >= 0; i--) {
                int idx = (a[i] / jarisu) % 10;
                output[bucket[idx] - 1] = a[i];
                bucket[idx]--;
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;

        }


    }
}
