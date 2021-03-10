package com.sherlock.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0 || nums[i] != nums[i - 1]) {
                list.add(nums[i]);
                result.add(list);
                trackback(result, list, i + 1, nums);
            }

        }
        return result;
    }

    private void trackback(List<List<Integer>> result, List<Integer> data, int pos, int[] nums) {
        for (int i = pos; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(data);
            if (i == pos || nums[i] != nums[i - 1]) {
                list.add(nums[i]);
                result.add(list);
                trackback(result, list, i+1, nums);
            }


        }
    }
}
