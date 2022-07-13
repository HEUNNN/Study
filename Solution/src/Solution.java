import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};

        int res = solution2(a, b);
        System.out.println(res);
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int tmp = a[i] * b[i];
            answer += tmp;
        }

        return answer;
    }

    public static int solution2(int[] a, int[] b) {
        int result = IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
        IntStream.range(0, a.length).forEach(value -> System.out.println(value));
        return result;
    }

}






