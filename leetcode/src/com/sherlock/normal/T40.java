package com.sherlock.normal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            if (i>0 && candidates[i] == candidates[i-1]){
                continue;
            }
            if (candidates[i] <= target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                if (candidates[i] == target)
                    result.add(list);
                else
                    backtrack(result, list, candidates[i], candidates, target,i);
            }
        }

        return result;
    }
    //注意每层递归都对全体candidates做遍历会导致如[2,2,3],[3,2,2]这样的对称重复的答案的产生。这是因为发生了“往前选择”的情况，我们每次更深层的递归都往后缩小一个candidates，强制函数只能“往后选择”，这将不会出现重复答案。

    public void backtrack(List<List<Integer>> result, List<Integer> list, int sum, int[] candidates, int target,int start) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        newList.add(-1);
        for (int j = start + 1 ; j < candidates.length; j++) {
            if (j>start+1 && candidates[j] == candidates[j-1]){
                continue;
            }

            if (sum+candidates[j] == target) {
                newList.set(newList.size()-1,candidates[j]);
                result.add(newList);
            }else if (sum +candidates[j]< target){
                newList.set(newList.size()-1,candidates[j]);
                backtrack(result,newList,sum+candidates[j],candidates,target,j);
            }
        }

    }
}
