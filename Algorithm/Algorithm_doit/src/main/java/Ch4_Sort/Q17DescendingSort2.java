package Ch4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17DescendingSort2 {
    // 선택 정렬 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < length; i++) {
            // 15234
            // 51234
            // 54231
            // 54321
            int maxIdx = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[maxIdx] < arr[j]) {
                    maxIdx = j;
                }
            }
            if (arr[i] < arr[maxIdx]) {
                int tmp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = tmp;
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
        }
    }
}
