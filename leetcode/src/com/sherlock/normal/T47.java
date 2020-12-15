package com.sherlock.normal;

import com.sherlock.sort.BublleSort;

import java.util.ArrayList;
import java.util.List;

public class T47 {
    //因为不能重复，所以每一位数字选择对时候，不能选同一个
    public List<List<Integer>> permuteUnique(int[] nums) {
        nums = new BublleSort().bubbleSort(nums); //先排序
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //因为排序过，所以只要不和上一层相同就行
            if (i==0 || nums[i] !=nums[i-1]){
                List<Integer> list  = new ArrayList<>();
                list.add(nums[i]);
                if (list.size() == nums.length){
                    result.add(list);
                }else {
                    int[] store = new int[nums.length];
                    store[i] = 1;
                    backtrack(result,list,nums,store);
                }
            }

        }
        return result;
    }

    public void backtrack(List<List<Integer>> result,List<Integer> list,int[] nums,int[] store){
        Integer lastChoose = null;
        for (int i = 0; i < nums.length; i++) {
            //之后每一层都能与上一层有相同数字，但在相同层同一个数字不能重复选择

            if (store[i] == 0 && (lastChoose==null || nums[i] != lastChoose)){//首先这个数字不能被选了，其次这个数字不能被重复选
                List<Integer> currentList = new ArrayList<>();
                currentList.addAll(list);

                lastChoose = nums[i];
                currentList.add(nums[i]);

                //长度足够返回
                if (currentList.size() == nums.length){
                    result.add(currentList);
                }else {
                    int[] currentStore = store.clone(); //直接复制是地址传递
                    currentStore[i] = 1;
                    backtrack(result,currentList,nums,currentStore);
                }
            }
        }
    }
}
