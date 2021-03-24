package com.seven.leetcode.problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 456.132Pattern
 * https://leetcode-cn.com/problems/132-pattern
 * 级别：Medium
 * <p>
 * i < j < k, nums[i] < nums[k] < nums[j]
 * <p>
 * [1,2,3,4]
 * [3,1,4,2]
 * [-1,3,2,0]
 *
 * @author : wenguang
 * @date : 2021/3/22 9:26
 */
public class OneThreeTwoPattern {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 3, 2, 0};
        System.out.println("in: " + Arrays.toString(nums));
        boolean result = oneThreeTwoPattern1(nums);
        System.out.println("out: " + result);
    }

    public static boolean oneThreeTwoPattern1(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < maxK) {
                return true;
            }

            while (!deque.isEmpty() && nums[i] > deque.peek()) {
                maxK = deque.pop();
            }

            if (nums[i] > maxK) {
                deque.push(nums[i]);
            }
        }

        return false;
    }

    /**
     * 时间复杂度不匹配
     *
     * @param nums 数组
     * @return result
     */
    public static boolean oneThreeTwoPattern2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int numI = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int numJ = nums[j];

                if (numJ > numI) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int numK = nums[k];

                        if (numI < numK && numK < numJ) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
