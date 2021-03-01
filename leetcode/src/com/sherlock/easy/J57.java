package com.sherlock.easy;

import java.util.*;

public class J57 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(target - nums[i], false)) {
                int[] result = new int[2];
                result[0] = target - nums[i];
                result[1] = nums[i];
                return result;
            }
            map.put(nums[i], true);
        }
        return new int[2];
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> results = new ArrayList<>();
        for (int i = 2; i < target - 1; i++) {
            for (int j = i; j <= target - i; j++) {
                int sum = (j + (j - i + 1)) * i / 2;//首项加xxx
                if (sum == target){
                    int[] r = new int[i];
                    for (int k = j - i + 1; k <= j; k++) {
                        r[k-(j - i + 1)] = k;
                    }
                    results.add(r);
                    break;
                }else if (sum>target) break;
            }
        }
        int[][] result = new int[results.size()][];
        for (int i = results.size()-1; i >=0; i--) {
            result[results.size()-1-i] = results.get(i);
        }
        return result;
    }
}
