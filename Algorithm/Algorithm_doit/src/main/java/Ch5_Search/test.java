package Ch5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            while (true) {
                int target = Integer.parseInt(br.readLine());
                System.out.println("ok");

                if (target == -1) {
                    return; // "2" 출력 안된다.
                    // break; 라면 "2" 출력된다.
                }
            }
        }
        System.out.println("2");

    }
}
