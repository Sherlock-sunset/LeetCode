package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class T216 {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.combinationSum3(4,24));
    }

    public static class Solution {

        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> buff, result = new ArrayList<>();
            List<Integer> data = new ArrayList<>();
            if (k == 1) {
                if (0 < n && n < 10) {
                    data.add(n);
                    result.add(data);
                }
            } else {
//                for (int i = 1; i < 10 - k; i++) {
//                    buff = combinationSum(k - 1, n - i, i + 1);
//                    if (buff != null) {
//                        for (int j = 0; j < buff.size(); j++) {
//                            buff.get(j).add(0, i);
//                            result.add(buff.get(j));
//                        }
//                    }
//                }
                result = combinationSum(k, n, 1);
            }
            return result;
        }

        public List<List<Integer>> combinationSum(int k, int n, int start) {
            List<List<Integer>> buff, result = new ArrayList<>();
            List<Integer> data;

            if (k == 1) {
                if (start <= n && n <= 9) {
                    result = new ArrayList<>();
                    data = new ArrayList<>();
                    data.add(n);
                    result.add(data);
                }
            } else {
                for (int i = start; i <= 10 - k; i++) {
                    buff = combinationSum(k - 1, n - i, i + 1);
                    if (buff.size() > 0) {
                        for (int j = 0; j < buff.size(); j++) {
                            buff.get(j).add(0, i);
                            result.add(buff.get(j));
                        }
                    }
                }
            }
            return result;
        }
    }
}
