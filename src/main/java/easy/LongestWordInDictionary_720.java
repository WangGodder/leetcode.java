package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: godder
 * @date: 2019/3/2
 */

/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
 */
public class LongestWordInDictionary_720 {
    public String longestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        // 排序，字典数从小到大
        Arrays.sort(words);
        // 从1各字符开始加起，如果前缀存在，则符合，否之抛
        Set<String> set = new HashSet<>();
        String result = "";
        for (String word : words) {
            // 一定有长度为0的字符
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                if (result.length() < word.length()) {
                    result = word;
                }
                set.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestWordInDictionary_720 solution = new LongestWordInDictionary_720();
        String[] words = {"w","wo","wor","worl","world"};
        String result = solution.longestWord(words);
        System.out.println(result);
    }
}
