package com.seven.leetcode.problems;

import java.util.Arrays;

/**
 * RemoveDuplicatesFromSortedArray
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 级别：Easy
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author : wenguang
 * @date : 2021/3/22 9:26
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("in: \nnums->" + Arrays.toString(nums));
        int result = removeDuplicatesFromSortedArray(nums);
        System.out.println("out: " + result + "\nnums->" + Arrays.toString(nums));
    }

    public static int removeDuplicatesFromSortedArray(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }
}
