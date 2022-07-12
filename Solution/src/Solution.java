import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        int result = solution(nums);
        System.out.println(result);

    }

    public static int solution(int[] nums) {

        int answer = 0;
        int half = nums.length / 2;

        Arrays.sort(nums);
        int diffElem = 1;
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] != nums[i + 1]) {
                diffElem++;
            }
        }

        if (diffElem >= half) {
            answer = half;
        } else {
            answer = diffElem;
        }

        return answer;
    }
    
    public static int solution2(int[] nums) {
        // hashSet은 중복을 허용하지 않는다.
        int N = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int answer;

        for (int i = 0; i < N; i++) {
            hs.add(nums[i]);
        }

        int size = hs.size();

        if (size >= (N/2)) {
            answer = (N/2);
        } else {
            answer = size;
        }

        return answer;
    }
}






