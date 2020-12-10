package com.sherlock.hard;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1 == null || nums1.length<=0 ? 0 : nums1.length;
        len += nums2 == null || nums2.length<=0 ? 0 : nums2.length;
        if (len == 0)
            return 0.0;
        if (len == 1)
            return nums1 == null || nums1.length<=0 ? nums2[0] : nums1[0];
        if (nums1 == null || nums1.length<=0) {
            if (nums2.length % 2 == 0)
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
            else
                return nums2[nums2.length / 2];
        }
        if (nums2 == null || nums2.length<=0) {
            if (nums1.length % 2 == 0)
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
            else
                return nums1[nums1.length / 2];
        }
        int[] nums = new int[len];
        for (int i = 0, left = 0, right = 0; i < len / 2 + 1; i++) {
            if (left >= nums1.length) {
                nums[i] = nums2[right++];
            } else if (right >= nums2.length) {
                nums[i] = nums1[left++];
            } else if (nums1[left] <= nums2[right]) {
                nums[i] = nums1[left++];
            } else {
                nums[i] = nums2[right++];
            }
        }

        if (len % 2 != 0)
            return nums[len / 2];
        else
            return (nums[len /2] + nums[len/2-1])/2.0;
    }
}
