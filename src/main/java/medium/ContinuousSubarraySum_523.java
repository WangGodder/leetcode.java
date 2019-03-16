package medium;

import java.lang.reflect.Array;

/**
 * @author: godder
 * @date: 2019/3/9
 */
public class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0 && nums[i] == 0) {
                return true;
            }
            if (k == 0) {
                continue;
            }
            sum += nums[i];
            if (sum % k == 0) {
                return true;
            }

            if (sum > k) {
                int subSum = 0;
                for (int j = i; j > 0; j--) {
                    subSum += nums[j];
                    if (i > j && subSum % k == 0) {
                        return true;
                    }
                }
            }
        }
        System.out.println(sum);
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum_523 continuousSubarraySum_523 = new ContinuousSubarraySum_523();


    }
}
