package com.seven.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LongestPalindromicSubstring
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 级别：Medium
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author : wenguang
 * @date : 2021/3/22 11:03
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String in = "cbbd";
        System.out.println("in: " + in);
        String out = longestPalindromicSubstring1(in);
        System.out.println("out: " + out);
    }

    public static String longestPalindromicSubstring1(String s) {
        if (null == s || s.length() <= 1) {
            return "";
        }

        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (null != index) {
                if (end - start < i - index) {
                    start = index;
                    end = i;
                }
            }

            map.put(c, i);
        }

        return s.substring(start, end + 1);
    }

    public static String longestPalindromicSubstring2(String s) {
        if (null == s || s.length() <= 1) {
            return "";
        }

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> indexes = map.get(c);
            if (null != indexes) {
                indexes.add(i);
            } else {
                indexes = new ArrayList<>();
                indexes.add(i);
                map.put(c, indexes);
            }
        }

        int[] reduce;
        reduce = map.values()
            .stream()
            .reduce(new int[]{0, 0},
                (a, b) -> {
                    for (int i = 1; i < b.size(); i++) {
                        Integer one = b.get(i - 1);
                        Integer two = b.get(i);

                        if (two - one > a[1] - a[0]) {
                            a[1] = two;
                            a[0] = one;
                        }
                    }

                    return a;
                },
                (x, y) -> x
            );

        if (reduce[0] == 0 && reduce[1] == 0) {
            return "";
        }

        return s.substring(reduce[0], reduce[1] + 1);
    }
}
