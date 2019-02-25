package easy;

import java.util.Arrays;

/**
 * @author: godder
 * @date: 2019/2/24
 */
public class SmallestRange1_908 {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        int max = A[0], min = A[0];
        for (int num : A) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return Math.max(max - min - 2 * K, 0);
    }

    public static void main(String[] args) {
        SmallestRange1_908 solution = new SmallestRange1_908();
        int[] A = {1,3,6};
        int K = 3;
        int result = solution.smallestRangeI(A, K);
        System.out.println(result);
    }
}
