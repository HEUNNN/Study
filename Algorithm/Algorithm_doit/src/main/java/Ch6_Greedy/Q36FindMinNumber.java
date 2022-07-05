package Ch6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q36FindMinNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String[] original = s.split("-");
        int sum = 0;


        String[] splitPlus1 = original[0].split("\\+");
        for (int i = 0; i < splitPlus1.length; i++) {

            sum += Integer.parseInt(splitPlus1[i]);
        }

        for (int i = 1; i < original.length; i++) {

            String[] splitPlus2 = original[i].split("\\+");
            int tmp = 0;
            for (int j = 0; j < splitPlus2.length; j++) {
                tmp += Integer.parseInt(splitPlus2[j]);
            }
            sum -= tmp;
        }
        System.out.println(sum);

    }
}
