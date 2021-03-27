package com.seven.leetcode.problems;

/**
 * AddTwoNumbers
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 级别：Medium
 * <p>
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author : wenguang
 * @date : 2021/3/22 9:55
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
//        Node one = new Node(0, new Node(1, new Node(2, null)));
//        Node two = new Node(1, new Node(0, new Node(9, null)));
        ListNode one = new ListNode(6, null);
        ListNode two = new ListNode(7, null);
        System.out.println("in:\none: " + one + "\ntwo: " + two);
        ListNode res = addTwoNumbers(one, two);
        System.out.println("out: " + res);
    }

    public static ListNode addTwoNumbers(ListNode one, ListNode two) {
        ListNode tempOne = one;
        ListNode tempTwo = two;
        ListNode res = new ListNode(0, new ListNode());
        ListNode temp = res;
        int x = 0;
        while (null != tempOne || null != tempTwo) {
            int current = x;
            if (null != tempOne) {
                current += tempOne.val;
                tempOne = tempOne.next;
            }
            if (null != tempTwo) {
                current += tempTwo.val;
                tempTwo = tempTwo.next;
            }

            x = current / 10;
            ListNode listNode = new ListNode(current % 10, null);
            temp.next = listNode;
            temp = listNode;
        }

        if (x != 0) {
            temp.next = new ListNode(x, null);
        }

        return res.next;
    }
}
