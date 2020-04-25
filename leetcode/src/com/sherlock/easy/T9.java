package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T9 {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.isPalindrome(10));
        System.out.println(so.isPalindrome(121));
        System.out.println(so.isPalindrome(-121));
    }

    public static class Solution {

        //不转换成字符串的方法，转换成字符串很简单（前后一起读，不同就返回false）
        public boolean isPalindrome(int x) {
            if (x > 0 && x % 10 != 0) {//被10整除的肯定不是回文数
                int len = lenthInt(x);
                if (len == 1)
                    return true;
                return reverse(x) == x;
            } else if (x == 0) {
                return true;
            }
            return false;
        }
        /**
         * 求整数长度
         */
        private int lenthInt(int value) {
            int len = 1;
            while (value / 10 > 0) {
                value = value / 10;
                len++;
            }
            return len;
        }
        public int reverse(int x) {
            boolean isNegative = x < 0;
            List<Integer> enqueue = new ArrayList<>();
            if (isNegative && x / -10 > 0) {  //有这个步骤是因为考虑的32位的表示 负值能比正值多表示一个数字
                enqueue.add(-(x % -10));
                x = x / -10;
            }
            while (x / 10 > 0) {
                enqueue.add(x % 10);
                x = x / 10;
            }
            enqueue.add(x % 10);

            double temp = 0;
            for (int i = 0; i < enqueue.size(); i++) {
                if ((temp * 10 + enqueue.get(i)) > Integer.MAX_VALUE)
                    return 0;
                temp = temp * 10 + enqueue.get(i);
            }
            return isNegative ? -(int) temp : (int) temp;
        }
    }
}
