package com.sherlock.normal;

import com.sherlock.sort.BublleSort;

import java.util.ArrayList;
import java.util.List;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        nums = new BublleSort().bubbleSort(nums);
        for(int i = 0; i<nums.length;i++){
            System.out.print(nums[i]);
        }
        System.out.println();
        List<List<Integer>> result = new ArrayList();
        List<List<Integer>> buff = new ArrayList();

        for (int l = 0; l +2 < nums.length; l++) { //从左开始，到倒数第二个，因为中间要至少留一个位置

            for (int r = nums.length - 1; r > l + 1; r--) {//右指针从右往左移

                if (r == (nums.length - 1) || nums[r] != nums[r + 1]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[r]);
                    buff.add(list);
                    System.out.println(list);

                }
            }
            //L 移动不能和上一次相同，L+1 <nums.length-1
            while ((l+1) < nums.length  && nums[l + 1] == nums[l])
                l++;
        }
        for (int i = 0; i < buff.size(); i++) {
            System.out.print(buff.get(i));

        }


        int l = 0, r = nums.length - 1;//在中间找

        for (int i = 0; i < buff.size(); i++) {
            // System.out.println(buff.get(i));
            for (int j = l+1; j < r; j++) {//从左边+1开始找到右边-1为止
                System.out.println(l+" "+j+" "+r);
                if (buff.get(i).get(0) + buff.get(i).get(1) + nums[j] == 0) {

                    buff.get(i).add(1, nums[j]);
                    System.out.println(buff.get(i));

                    result.add(buff.get(i));
                    break;
                }
            }

            if (r - l > 2)
                r--;
            else {
                l++;
                r = nums.length - 1;
            }
        }
//        System.out.println(result.toString());
        return result;
    }
}
