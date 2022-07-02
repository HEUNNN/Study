package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29FindNum {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 데이터의 개수
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int F = Integer.parseInt(br.readLine()); // 찾아야 할 숫자 개수
        int[] result = new int[F];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < F; i++) {
            int target = Integer.parseInt(st.nextToken());
            binarySearch(arr, 0, N - 1, target);
        }
        /*for (int i = 0; i < F; i++) {

            int start = 0;
            int end = N - 1;
            boolean flag = false;

            int target = Integer.parseInt(st.nextToken());

            while (start <= end) {
                int mid = (start + end) / 2;
                int midVal = arr[mid];

                if (midVal > target) {
                    end = mid - 1;
                } else if (midVal < target) {
                    start = mid + 1;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }*/
    }

    private static void binarySearch(int[] array, int s, int e, int target) {

        // 재귀 사용 O
        if (s > e) {
            System.out.println("0");
            return;
        }

        int mid = (s + e) / 2;
        if (array[mid] < target) {
            binarySearch(array, mid + 1, e, target);
        } else if (array[mid] == target) {
            System.out.println("1");
            return;
        } else {
            binarySearch(array, s, mid - 1, target);
        }
    }
}
