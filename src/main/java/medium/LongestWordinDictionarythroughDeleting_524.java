package medium;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/6
 */

/*
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output:
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output:
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordinDictionarythroughDeleting_524 {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String word: d) {
            if (word.length() < result.length()) {
                continue;
            }
            if (isContain(s, word)) {
                if (result.length() < word.length()) {
                    result = word;
                }
                if (result.length() == word.length()) {
                    result = result.compareTo(word) < 0? result : word;
                }
            }
        }
        return result;
    }

    private boolean isContain(String target, String query) {
        if (query.length() > target.length()) {
            return false;
        }
        char[] targetArray = target.toCharArray();
        char[] queryArray = query.toCharArray();
        int i = 0, j = 0;
        for (; i < targetArray.length && j < queryArray.length; i++) {
            if (targetArray[i] == queryArray[j]) {
                j++;
                continue;
            }
        }
        if (j == queryArray.length) {
            return true;
        }
        return false;
    }
}
