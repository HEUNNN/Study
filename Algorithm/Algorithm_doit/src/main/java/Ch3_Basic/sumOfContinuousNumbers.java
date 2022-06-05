package Ch3_Basic;

import java.util.Scanner;

public class sumOfContinuousNumbers {
    // 백준 2018
    // 투 포인터를 사용하여 연속된 자연수의 합 구하기
    /*
     * 1 번째 줄에 정수 N이 주어진다.
     * 입력된 자연수 N을 연속된 자연수의 합으로 나타낼 수 있는 경우의 개수를 출력한다.
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1;
        int cnt = 1;
        int si = 1; // start index
        int ei = 1; // end index

        // idx가 곧 연속되는 숫자 배열의 원소
        // N = 5 일때 arr ={1 ,2 ,3, 4, 5}를 따로 만들 필요 없다.
        // ei 가 N이 되는 순간 따져볼 것도 없다. 연속된 자연수이기 때문이다.
        while (ei != N) {
            if (sum > N) {
                sum -= si;
                si++;
            } else if (sum < N) {
                ei++;
                sum += ei;
            } else { // sum == N
                cnt++;
                sum -= si;
                si++;
            }
        }
        System.out.println(cnt);

    }
}
