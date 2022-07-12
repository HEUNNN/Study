public class Solution {

    public static void main(String[] args) {

        int[] arr = {1, 2, 7, 6, 4};
        int result = solution(arr);
        System.out.println(result);

    }

    public static int solution(int[] nums) {

        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    boolean prime = isPrime((nums[i] + nums[j] + nums[k]));
                    if (prime) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static boolean isPrime(int number) {
        boolean p = true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                p = false;
            }
        }
        return p;
    }
}






