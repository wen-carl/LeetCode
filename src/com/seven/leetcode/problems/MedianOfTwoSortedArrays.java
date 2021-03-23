package com.seven.leetcode.problems;

import java.util.Arrays;

/**
 * MedianOfTwoSortedArrays
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 级别：Hard
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * @author : wenguang
 * @date : 2021/3/22 9:26
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2};
        int[] nums2 = new int[]{2};
        System.out.println("in: \nnums1" + Arrays.toString(nums1) + "\nnums2: " + Arrays.toString(nums2));
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println("out: " + result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = merge(nums1, nums2);

        int length = array.length;
        if (length == 0) {
            return 0;
        } else if (length % 2 == 0) {
            return (array[length / 2 - 1] + array[length / 2]) / 2.0;
        } else {
            return array[length / 2];
        }
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int l1 = null == nums1 ? 0 : nums1.length;
        int l2 = null == nums2 ? 0 : nums2.length;

        int[] res = new int[l1 + l2];
        int m = 0;
        int n = 0;
        int index = 0;

        while (m < l1 && n < l2) {
            if (nums1[m] <= nums2[n]) {
                res[index++] = nums1[m++];
            } else {
                res[index++] = nums2[n++];
            }
        }

        while (m < l1) {
            res[index++] = nums1[m++];
        }

        while (n < l2) {
            res[index++] = nums2[n++];
        }

        return res;
    }
}
