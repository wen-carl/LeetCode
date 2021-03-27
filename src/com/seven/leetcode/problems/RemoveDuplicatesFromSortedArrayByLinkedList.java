package com.seven.leetcode.problems;

import com.seven.leetcode.utils.Utils;

import java.util.Arrays;

/**
 * 83. 删除排序链表中的重复元素
 * RemoveDuplicatesFromSortedArray
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 级别：Easy
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1:
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2:
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * @author : wenguang
 * @date : 2021/3/22 9:26
 */
public class RemoveDuplicatesFromSortedArrayByLinkedList {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4};
        ListNode node = Utils.arrayToListNode(nums);
        System.out.println("in: \nnode->" + node);
        ListNode result = removeDuplicatesFromSortedArray(node);
        System.out.println("out: " + result);
    }

    public static ListNode removeDuplicatesFromSortedArray(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode pre = head;
        ListNode next = pre.next;
        while (null != next) {
            if (pre.val != next.val) {
                pre.next = next;
                pre = next;
            } else {
                pre.next = next.next;
            }
            next = next.next;
        }

        return head;
    }
}
