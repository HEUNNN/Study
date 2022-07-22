package Ch7_TheoryOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q39FindMinNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int max = 10000000;

        int[] arr = new int[max + 1];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        double sqrt = Math.sqrt(max);
        for (int i = 2; i <= sqrt; i++) {
            if (arr[i] == 0) continue;

            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        // 팬린드롬 찾기
        for (int i = N; i < arr.length; i++) {
            if (arr[i] == 0) continue;

            boolean palindrome = isPalindrome(arr[i]);
            if (palindrome == true) {
                System.out.println(arr[i]);
                return;
            }
        }

    }

    private static boolean isPalindrome(int number) {

        char[] numChars = String.valueOf(number).toCharArray();

        int s = 0;
        int e = numChars.length - 1;

        while (s < e) {
            if (numChars[s] != numChars[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
