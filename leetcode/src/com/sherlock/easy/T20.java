package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class T20 {

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.isValid("()"));
        System.out.println(so.isValid("()[]{}"));
        System.out.println(so.isValid("(]"));
        System.out.println(so.isValid("([])"));
    }

    public static class Solution {
        public boolean isValid(String s) {
            List<Character> left = new ArrayList<>();
            left.add('(');
            left.add('[');
            left.add('{');
            List<Character> right = new ArrayList<>();
            right.add(')');
            right.add(']');
            right.add('}');
            char[] values = s.toCharArray();
            if (values.length == 0)
                return true;
            if (values.length % 2 == 1 || right.contains(values[0]))
                return false;
            Stack stack = new Stack(values.length / 2);
            stack.push(values[0]);
            for (int i = 1; i < values.length; i++) {
                if (right.contains(values[i])) {
                    if (stack.isEmpty() || left.indexOf(stack.pop()) != right.indexOf(values[i]))//这里用了stack.pop()所以不需要else，如果用的是peek（）需要
                        return false;
                } else {
                    stack.push(values[i]);
                }
            }
            return stack.isEmpty();
        }

        public class Stack {
            private char[] data;
            private int maxSize;
            private int top = -1;

            public Stack(int maxSize) {
                this.maxSize = maxSize;
                data = new char[maxSize];
            }

            /**
             * 栈内元素和
             */
            public int elementCount() {
                return top + 1;
            }

            public boolean push(char object) {
                if (top + 1 < maxSize) {
                    data[++top] = object;
                    return true;
                }
                return false;
            }

            public char pop() {
                top--;
                return data[top + 1];
            }

            public char peek() {
                return data[top];
            }

            public boolean isEmpty() {
                return top < 0;
            }
        }
    }
}
