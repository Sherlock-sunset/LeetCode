package com.sherlock.easy;

public class T1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + "   " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums  " + nums[i]);
            for (int j = 0; j < i; j++) {
                System.out.println("temp  " + temp[j]);
                if (temp[j] == nums[i]) {
                    result[0] = j;
                    result[1] = i;
                    return result;
                }
            }
            temp[i] = target - nums[i];
        }
        return result;
    }


}
