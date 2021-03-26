package com.seven.leetcode.utils;

import com.seven.leetcode.problems.ListNode;

public class Utils {
    private Utils() {}

    public static ListNode arrayToListNode(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        ListNode node = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            node = new ListNode(num, node);
        }

        return node;
    }
}
