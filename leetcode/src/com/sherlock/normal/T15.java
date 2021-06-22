package com.sherlock.normal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        Arrays.sort(nums);
        int maxL = nums.length - 3, minR = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !flag) {
                maxL = i;
                minR = i;
                flag = true;
            } else if (nums[i] > 0 && !flag) {
                minR = i;
                flag = true;
            } else if (!flag) {
                maxL = i;
            }
            map.put(nums[i], true);
        }
        flag = false;
        int l = 0, r = nums.length - 1;
        while (l <= maxL) {
            if (nums[l] > 0) return result;
            if (r >= Math.max(l + 2, minR) && nums[r] >= 0) {
                int sum = nums[l] + nums[r];
                int t = -sum;
                if (map.getOrDefault(t, false) && t >= nums[l + 1] && t <= nums[r - 1]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(t);
                    list.add(nums[r]);
                    result.add(list);
                    flag = true;
                } else {
                    flag = false;
                }

            }
            if (r - 1 >= Math.max(l + 2, minR)) {
                while (r - 1 >= Math.max(l + 2, minR) && nums[r - 1] == nums[r] && flag) r--;
                r--;
            } else {
                while (l + 1 <= maxL && nums[l + 1] == nums[l]) l++;
                l++;
                r = nums.length - 1;
            }
        }


        return result;
    }
}
