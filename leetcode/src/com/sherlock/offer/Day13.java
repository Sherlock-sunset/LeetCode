package com.sherlock.offer;

public class Day13 {
    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     */
    public int[] exchange(int[] nums) {
        if (nums == null) return nums;
        int right = nums.length - 1;
        for (int i = 0; i < right; ) {
            if (nums[i] % 2 == 0) {
                int temp = nums[right];
                nums[right--] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        return nums;
    }

    /**
     * 剑指 Offer 57. 和为s的两个数字
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return new int[2];
        int[] ans = new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ans[0] = nums[left];
                ans[1] = nums[right];
                break;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;

    }

    /**
     * 剑指 Offer 58 - I. 翻转单词顺序
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     */
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return s;
        String[] strings = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].isEmpty()) continue;
            if (i < strings.length - 1) {
                ans.append(" ").append(strings[i]);
            } else {
                ans.append(strings[i]);
            }
        }
        return ans.toString();
    }
}
