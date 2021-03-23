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
 * "ab"
 *
 * @author : wenguang
 * @date : 2021/3/22 11:03
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String in = "pwwkew";
        System.out.println("in: " + in);
        int out = longestSubstringWithoutRepeatingCharacters(in);
        System.out.println("out: " + out);
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int res = 1;
        int start = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (null != index) {
                start = Math.max(start, index + 1);
            }

            res = Math.max(res, i - start + 1);

            map.put(c, i);
        }

        return res;
    }
}
