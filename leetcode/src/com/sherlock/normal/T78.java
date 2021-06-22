package com.sherlock.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //Arrays.sort(nums); //由于本身有序，所以可以去掉这一行代码
        trackback(ans, nums, new ArrayList<Integer>(), 1, 0);
        ans.add(0, new ArrayList<>());
        return ans;
    }

    private void trackback(List<List<Integer>> ans, int[] nums, List<Integer> current, int len, int start) {
        if (len > nums.length) return;
        for (int i = start; i < nums.length; i++) {
            //if (current.contains(nums[i])) continue;
            List<Integer> list = new ArrayList<>();
            list.addAll(current);
            list.add(nums[i]);
            ans.add(list);
            trackback(ans, nums, list, len + 1, i + 1);
        }
    }
}
