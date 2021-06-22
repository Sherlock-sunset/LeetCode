package com.sherlock.normal;


import java.util.Arrays;

public class T16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0, minDis = Integer.MAX_VALUE;
        int l = 0, r = nums.length - 1;
        while (l + 1 != r) {
            for (int i = l + 1; i < r; i++) {
                int dis = nums[l] + nums[i] + nums[r] - target;
                if (dis == 0)
                    return target;

                int abs = dis >= 0 ? dis : -dis;

                if (abs <= minDis){
                    minDis = abs;
                    result = target +dis;
                }

            }
            if (r-l==2){
                l++;
                r = nums.length-1;
            }else {
                r--;
            }
        }
        return result;
    }
}
