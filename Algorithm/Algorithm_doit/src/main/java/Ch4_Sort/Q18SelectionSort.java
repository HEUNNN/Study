package Ch4_Sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18SelectionSort {
    // 백준 11399
    // ATM 인출 시간 계산하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < N; i++) {
            int end = i;
            int start = 0;
            while (start < end) {
                if (arr[start] > arr[end]) {
                    int tmp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = tmp;
                }
                start++;
            }
        }

        result += arr[0];
        for (int i = 1; i < N; i++) {
            arr[i] = arr[i - 1] + arr[i];
            result += arr[i];
        }

        System.out.println(result);
    }
}
