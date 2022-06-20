package Ch4_Sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Q17DescendingSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        Arrays.sort(arr);

        for (int i = 0; i <= N - i - 1; i++) {
            int end = N - i - 1;
            if (i == end) {
                break;
            }
            int tmp = arr[i];
            arr[i] = arr[end];
            arr[end] = tmp;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }


    }
}
