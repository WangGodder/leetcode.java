package medium;

import java.util.ArrayList;

/**
 * @author: godder
 * @date: 2019/3/3
 */
public class MaxContinueOneNum {
    public int longestOnes(int[] A, int K) {
        ArrayList<Integer> lengthList = new ArrayList<>();
        ArrayList<Integer> gasList = new ArrayList<>();
        int length = 0, gas = 0;
        for (int a : A) {
            if (a == 1) {
                if (!lengthList.isEmpty() && gas > 0) {
                    gasList.add(gas);
                    gas = 0;
                }
                length++;
            } else {
                if (length > 0) {
                    lengthList.add(length);
                    length = 0;
                }
                gas++;
            }
        }
        if (length > 0) {
            lengthList.add(length);
        }
        System.out.println(lengthList);
        System.out.println(gasList);
        int result = 0;
        for (int i = 0; i < lengthList.size() - 2; i++) {
            int currentLength = lengthList.get(i), lastK = K;
            for (int j = i; j < lengthList.size() - 2; j++) {
                if (gasList.get(j) < lastK) {
                    currentLength += lengthList.get(j+1);
                    lastK -= gasList.get(j);
                } else {
                    break;
                }
            }
            result = Math.max(result, currentLength);
        }
        result = Math.max(result, lengthList.get(lengthList.size() - 1));
        return result;
    }

    public static void main(String[] args) {
        MaxContinueOneNum solution = new MaxContinueOneNum();
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;
        int result = solution.longestOnes(A, K);
        System.out.println(result);
    }
}
