import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Memo {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int length = (int) (max - min + 1);
        boolean[] check = new boolean[length];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            // pow * num 해서 min, max 사이에 들어가는 숫자의 개수를 count 하면된다.
            // pow가 2 * 2, 즉 4일 때 곱해서 min과 같거나 클 수 있는 값을 구하였고, i++ 시키면서 구한다.
            long startIdx = min / pow;
            if (min % pow != 0) startIdx++; // 나머지가 있으면 1을 더해야 min 보다 큰 수를 탐색할 수 있다.

            for (long j = startIdx; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }

        }

        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (!check[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
