package com.seven.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LongestSubstringWithoutRepeatingCharacters
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 级别：Medium
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @author : wenguang
 * @date : 2021/3/22 11:03
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String in = "pwwkew";
        System.out.println("in: " + in);
        int out = longestSubstringWithoutRepeatingCharacters1(in);
        System.out.println("out: " + out);
    }

    public static int longestSubstringWithoutRepeatingCharacters1(String para) {
        int len = 0;
        for (int i = 0; i < para.length(); i++) {
            for (int j = i + 1; j <para.length(); j++) {
                char charJ = para.charAt(j);
                boolean shouldBreak = false;
                for (int k = i; k < j; k++) {
                    char charK = para.charAt(k);
                    if (charK == charJ) {
                        shouldBreak = true;
                        break;
                    }
                }
                len = Math.max(j - i, len);
                if (shouldBreak) {
                    break;
                }
            }
        }

        return len;
    }

    public static int longestSubstringWithoutRepeatingCharacters2(String para) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < para.length(); i++) {
            char c = para.charAt(i);
            Integer index = map.get(c);
            if (null != index) {
                res = Math.max(res, i - index);
            }

            map.put(c, i);
        }

        return res;
    }
}
