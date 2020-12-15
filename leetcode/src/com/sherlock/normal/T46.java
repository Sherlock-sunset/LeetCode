package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list  = new ArrayList<>();
            list.add(nums[i]);
            if (list.size() == nums.length){
                result.add(list);
            }else {
                backtrack(result,list,nums);
            }
        }
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> list,int[] nums){
        for (int i = 0; i < nums.length; i++) {
            List<Integer> currentList = new ArrayList<>();
            currentList.addAll(list);
            if (!currentList.contains(nums[i])){
                currentList.add(nums[i]);
                if (currentList.size() == nums.length){
                    result.add(currentList);
                }else {
                    backtrack(result,currentList,nums);
                }
            }
        }
    }
}
