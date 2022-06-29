package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24FindPrimeNumber {
    // 백준 2023
    // 신기한 소수 찾기
    // 왼쪽부터 1자리, 2자리, 3자리, 4자리, ... n 자릿수가 모두 소수인 수를 찾아라 → 재귀 사용
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 자릿수

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int n, int jarisu) {
        if (jarisu == N) {
            // 소수인지 확인하고 프린트하고 return
            if (isPrime(n)) {
                System.out.println(n);
            }
            return; // 소수가 아니고 자리수만 N 과 같으면 return
        }


        for (int i = 1; i < 10; i++) {
            int number = (n * 10) + i;
            if (i % 2 == 0) {
                continue; // 짝수라면 다음 i 로 넘어간다.
            }
            if (isPrime(number)) { // 소수라면 재귀 함수로 자릿수를 늘림
                DFS(number, jarisu + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        // 소수 판별 법 ver 1
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }

        return true;

        // 소수 판별 법 ver 2 → 속도가 더 빠름
        /*
        int x = (int)Math.sqrt(num);
        for(int i=2;i<=x;i++){
            if(num%i==0) return false;
        }
        return true;
         */
    }
}
