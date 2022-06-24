package Ch4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21MergeSortEx2 {
    private static int[] a;
    private static int[] tmp;
    private static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        a = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        System.out.println(cnt);

    }

    private static void mergeSort(int s, int e) {
        if ((e - s) < 1) return;

        int mid = (s + e) / 2;

        mergeSort(s, mid);
        mergeSort(mid + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = a[i];
        }

        int s1 = s;
        int s2 = mid + 1;
        int tmpIdx = s; // 원래 원소의 자리에서 tmpIdx로 이동해야한다.

        while (s1 <= mid && s2 <= e) {
            if (tmp[s1] > tmp[s2]) {
                a[tmpIdx] = tmp[s2];
                cnt = cnt + s2 - tmpIdx;
                tmpIdx++;
                s2++;
            } else {
                a[tmpIdx] = tmp[s1];
                tmpIdx++;
                s1++;
            }
        }


        while (s1 <= mid) {
            a[tmpIdx] = tmp[s1];
            tmpIdx++;
            s1++;
        }

        while (s2 <= e) {
            a[tmpIdx] = tmp[s2];
            tmpIdx++;
            s2++;
        }

    }

}
