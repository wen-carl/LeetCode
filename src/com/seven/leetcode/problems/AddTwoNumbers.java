package com.seven.leetcode.problems;

/**
 * AddTwoNumbers
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 级别：Medium
 *
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *
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
        Node one = new Node(6, null);
        Node two = new Node(7, null);
        System.out.println("in:\none: " + one + "\ntwo: " + two);
        Node res = addTwoNumbers(one, two);
        System.out.println("out: " + res);
    }

    public static Node addTwoNumbers(Node one, Node two) {
        Node tempOne = one;
        Node tempTwo = two;
        Node res = new Node(0, new Node());
        Node temp = res;
        int x = 0;
        while (null != tempOne || null != tempTwo) {
            int current = x;
            if (null != tempOne) {
                current += tempOne.getVal();
                tempOne = tempOne.getNext();
            }
            if (null != tempTwo) {
                current += tempTwo.getVal();
                tempTwo = tempTwo.getNext();
            }

            x = current / 10;
            Node node = new Node(current % 10, null);
            temp.setNext(node);
            temp = node;
        }

        if (x != 0) {
            temp.setNext(new Node(x, null));
        }

        return res.getNext();
    }

    public static class Node {
        private int val;

        private Node next;

        public Node() { }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public Node setVal(int val) {
            this.val = val;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
