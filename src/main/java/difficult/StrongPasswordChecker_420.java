package difficult;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: godder
 * @date: 2019/2/24
 */

/**
 * A password is considered strong if below conditions are all met:
 *
 * It has at least 6 characters and at most 20 characters.
 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
 *
 * Insertion, deletion or replace of any one character are all considered as one change.
 */
public class StrongPasswordChecker_420 {
    public int strongPasswordChecker(String s) {
        boolean lowerCase = false, upperCase = false, digit = false;
        char[] charts = s.toCharArray();
        int lastSameIndex = 0;
        int continueChange = 0; // 因连续所需要修改的次数  （连续个数整除3）
        int i = 0;
        // 将每次重复的长度记录下来，并且按照%3后的值由小到大排序
        Stack<Integer> continueLengthStack = new Stack<Integer>(), tempStack = new Stack<Integer>();
        // 记录得到连续的长度以及之对于重复需要更改的次数 (长度/3) 以及要求的类型是否包含
        for (; i < charts.length; i++) {
            char c = charts[i];
            lowerCase |= Character.isLowerCase(c);
            upperCase |= Character.isUpperCase(c);
            digit |= Character.isDigit(c);
            if (i > 0 && c == charts[i-1]) {
                continue;
            }
            int length = i - lastSameIndex;
            continueChange += length / 3;
            if (length > 2) {
                while (!continueLengthStack.isEmpty() && length > continueLengthStack.peek()) {
                    tempStack.push(continueLengthStack.pop());
                }
                continueLengthStack.push(length);
                while (!tempStack.isEmpty()) {
                    continueLengthStack.push(tempStack.pop());
                }
            }
            lastSameIndex = i;
        }
        int length = i - lastSameIndex;
        continueChange += length / 3;
        if (length > 2) {
            while (!continueLengthStack.isEmpty() && length > continueLengthStack.peek()) {
                tempStack.push(continueLengthStack.pop());
            }
            continueLengthStack.push(length);
            while (!tempStack.isEmpty()) {
                continueLengthStack.push(tempStack.pop());
            }
        }
        // 记录因为缺少类型所需要修改的次数 （增加或修改）
        int existChange = 0;
        if (!lowerCase) {
            existChange++;
        }
        if (!upperCase) {
            existChange++;
        }
        if (!digit) {
            existChange++;
        }

        int result = 0;
        if (charts.length < 6) {
            // 当需要插入元素的时候，不需要考虑重复的问题，即使有重复那么插入也可以解决
            result = Math.max(6 - charts.length, existChange);
        }
        if (charts.length > 20) {
            // 当需要删除元素的时候，考虑删除重复元素是否能满足减少修改次数 （重复的个数删除后/3的值减少）
            int continueExchangeNum = continueChange;
            int removeNum = charts.length - 20;
            // 按照分配原则，先将损耗最少的长度减少，每次只减少1次操作数
            while (!continueLengthStack.isEmpty() && removeNum > 0) {
                int l = continueLengthStack.pop();
                if (l % 3 < removeNum) {
                    continueExchangeNum --;
                    removeNum -= ((l % 3) + 1);
                    // l = (l / 3) * 3 - 1;
                }
            }
            // 如果还有可删除的个数没用，则剩下的所有长度%3 都等于2，即每次都需要损耗3
            if (removeNum > 0) {
                continueExchangeNum -= removeNum / 3;   // 可能会出现负数，但后面的Math会保证最小为0
            }
            // 删除不能满足的重复问题，替换可以解决
            result = Math.max(existChange, continueExchangeNum) + (charts.length - 20);
        }
        if (charts.length > 5 && charts.length < 21) {
            result = Math.max(continueChange, existChange);
        }
        return result;

    }

    public static void main(String... args) {
        StrongPasswordChecker_420 solution = new StrongPasswordChecker_420();
        String input = "aaaaaaaAAAAAA6666bbbbaaaaaaABBC";
        int result = solution.strongPasswordChecker(input);
        System.out.println(result);
    }
}
