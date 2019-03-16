package medium;

/**
 * @author: godder
 * @date: 2019/3/5
 */
/*
You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.
 */
public class CircularArrayLoop_457 {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean positive = nums[i] > 0;
            int j = i + nums[i];
            j = j >= 0? j % nums.length : nums.length - (Math.abs(j) % nums.length);
            int times = 1;
            while (j != i && times++ < nums.length) {
                if (nums[j] > 0 != positive) {
                    break;
                }
                j = j + nums[j];
                j = j >= 0? j % nums.length : nums.length - (Math.abs(j) % nums.length);
            }
            if (j == i && times > 1) {
                return true;
            }
        }
        return false;
    }
}
