package com.seven.leetcode.problems;

import com.seven.leetcode.utils.Utils;

/**
 * 61. 旋转链表
 * RotateLinkedList
 * https://leetcode-cn.com/problems/rotate-list/
 * 级别：Medium
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。。
 *
 * 示例 1:
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例 2:
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * [1]
 * 0
 *
 * @author : wenguang
 * @date : 2021/3/22 9:26
 */
public class RotateLinkedList {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode node = Utils.arrayToListNode(nums);
        System.out.println("in: \nnode->" + node);
        ListNode result = rotateRight(node, 2);
        System.out.println("out: " + result);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next || k == 0) {
            return head;
        }

        ListNode next = head;
        int lenth = 1;
        while (null != next.next) {
            lenth ++;
            next = next.next;
        }

        int step = lenth - k % lenth;

        if (lenth == step) {
            return head;
        }

        int i = 0;
        while (i < step) {
            i ++;
            ListNode temp = head.next;
            next.next = head;
            head.next = null;
            next = head;
            head = temp;
        }

        return head;
    }
}
