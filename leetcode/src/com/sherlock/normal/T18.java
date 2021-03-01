package com.sherlock.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Boolean> map = new HashMap<>();
        boolean flag = false;
        int maxFirst = nums.length - 4;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
            if (nums[i] == target && !flag) {
                maxFirst = i;
                flag = true;
            } else if (!flag && nums[i] > target) flag = true;
            else if (!flag) maxFirst = i;
        }
        for (int i = 0; i <= maxFirst; i++) {
            for (int four = nums.length - 1; four >= maxFirst + 3; four--) {
                for (int third = four-1; third >= maxFirst + 2; third--) {
                    int sum = nums[i]+nums[four]+nums[third];
                    int t = target- sum;
                    if (map.getOrDefault(t,false) && t>=nums[i+1] && t<=nums[third-1]){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(t);
                        list.add(nums[third]);
                        list.add(nums[four]);
                    }

                }
            }
        }


        return result;
    }
}
