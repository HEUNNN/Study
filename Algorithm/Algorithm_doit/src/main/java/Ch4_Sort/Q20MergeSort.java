package Ch4_Sort;


import java.io.*;

public class Q20MergeSort {
    private static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] +"\n");
        }

        bw.flush();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        if (e - s < 1) return;
        int mid = (s + e) / 2;
        // 4 2 3 1 5
        mergeSort(s, mid);
        mergeSort(mid + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }

        int tmpIdx = s;
        int s1 = s;
        int s2 = mid + 1;

        while (s1 <= mid && s2 <= e) {
            if (tmp[s1] > tmp[s2]) {
                arr[tmpIdx] = tmp[s2];
                tmpIdx++;
                s2++;
            } else {
                arr[tmpIdx] = tmp[s1];
                tmpIdx++;
                s1++;
            }
        }
        // 위의 루프 다 돌고도 s1이 mid보다 작거나 같으면 두 번째 부분만 다 정렬되고 첫번째 부분은 아직 다 정렬되지 않았다는 뜻이다.
        while (s1 <= mid) {
            arr[tmpIdx] = tmp[s1];
            tmpIdx++;
            s1++;
        }

        while (s2 <= e) {
            arr[tmpIdx] = tmp[s2];
            tmpIdx++;
            s2++;
        }
    }
}
