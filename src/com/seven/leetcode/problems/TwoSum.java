package com.seven.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 * https://leetcode-cn.com/problems/two-sum
 * 级别：Easy
 * <p>
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author : wenguang
 * @date : 2021/3/22 9:26
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 17;
        System.out.println("in: " + Arrays.toString(nums) + "\ntarget: " + target);
        int[] result = twoSum2(nums, target);
        System.out.println("out: " + Arrays.toString(result));
    }

    /**
     * 两数之和
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums 输入数组
     * @param target 目标值
     * @return 索引数组
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

    /**
     * 两数之和
     *
     * @param nums 输入数组
     * @param target 目标值
     * @return 索引数组
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (null != index) {
                return new int[] {index, i};
            }

            map.put(target - nums[i], i);
        }

        return null;
    }
}
