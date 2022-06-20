package Ch4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Q16BubbleSort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Data[] origin = new Data[N];
        int[] sortArr = new int[N];

        for (int i = 0; i < N; i++) {
            origin[i] = new Data(Integer.parseInt(br.readLine()), i);

        }

        Arrays.sort(origin);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int tmp = origin[i].index - i;
            if (max < tmp) {
                max = tmp;
            }
        }

        System.out.println(max + 1);
    }

    public static class Data implements Comparable<Data> {
        int value;
        int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {

            return this.value - o.value; // value, index 중 value 값을 기준으로 오름차순 정렬
            // 이 정렬 기준로 바탕으로 Arrays.sort()가 실행된다.
        }
    }
}
