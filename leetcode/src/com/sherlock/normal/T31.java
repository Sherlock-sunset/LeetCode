package com.sherlock.normal;

public class T31 {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1)
            return;
        int p = -1;
        // 找到需要改变对位置
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]){
                p = i-1;
                break;
            }
        }

        if (p != -1){
            //在p的右边找到大于p且最小的数
            int pMin = p+1;
            for (int i = p+2; i < nums.length; i++) {
                if (nums[i]>= nums[p] && nums[i] <nums[pMin])
                    pMin = i;
            }
            //交换两个数
            int buff = nums[p];
            nums[p] = nums[pMin];
            nums[pMin] = buff;
            //对右边进行排序
            for (int i = p+1,sum = 0; i < nums.length - 1; i++,sum++) {

                for (int j = p+1; j < nums.length - sum -1; j++) {
                    if (nums[j +1] < nums[j]) {
                        buff = nums[j + 1];
                        nums[j + 1] = nums[j];
                        nums[j] = buff;
                    }
                }
//            System.out.print(nums[nums.length-1-i]);

            }
            return;
        }

        int l=0,r=nums.length-1;
        while (l < r){
            int buff = nums[l];
            nums[l] = nums[r];
            nums[r] = buff;
            l++;
            r--;
        }

    }
}
